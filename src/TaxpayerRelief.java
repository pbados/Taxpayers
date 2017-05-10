import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Created by Patryk on 20-02-2017.
 */
public class TaxpayerRelief extends Taxpayer {

    private BigDecimal taxRelief = new BigDecimal(0.15);
    private static String[] countriesCoveredByRelief = {"Poland", "Germany", "Russia", "France", "Sweden"};

    public BigDecimal getTaxRelief() {
        return taxRelief;
    }

    public void setTaxRelief(BigDecimal taxRelief) {
        this.taxRelief = taxRelief;
    }

    public TaxpayerRelief(String name, String surname, int age, String country, BigDecimal income) {
        super(name, surname, age, country, income);
        this.taxRelief = taxRelief;
    }

    public BigDecimal taxCalculate() {

        boolean ifTaxRelief = false;

        if (getIncome().compareTo(taxFreeAllowance) >0) {

            for (int i = 0; i < countriesCoveredByRelief.length; i++) {
                if (countriesCoveredByRelief[i].equals(getCountry())) {
                    ifTaxRelief = true;
                }
            }
            if (ifTaxRelief == true) {
                BigDecimal tax = ((getIncome().subtract(taxFreeAllowance)).multiply(taxAmount)).subtract(taxRelief.multiply((getIncome().subtract(taxFreeAllowance).multiply(taxAmount))));
                System.out.println("Taxpayer " + getName()+" "+ getSurname()+". Income "+ getIncome().setScale(2, RoundingMode.CEILING)+". Taxpayer has tax relief because she/he is from country "+getCountry()+". Tax to pay: "+tax.setScale(2, RoundingMode.CEILING));
                return ((getIncome().subtract(taxFreeAllowance)).multiply(taxAmount)).subtract(taxRelief.multiply((getIncome().subtract(taxFreeAllowance).multiply(taxAmount))));
            } else {
                BigDecimal tax = (getIncome().subtract(taxFreeAllowance)).multiply(taxAmount);
                System.out.println("Taxpayer " + getName()+" "+ getSurname()+". Income "+ getIncome().setScale(2, RoundingMode.CEILING)+". Taxpayer hasn't tax relief. Tax to pay: "+tax.setScale(2, RoundingMode.CEILING));
                return (getIncome().subtract(taxFreeAllowance)).multiply(taxAmount);
            }
        }else{
            System.out.println("Taxpayer "+ getName()+" "+ getSurname()+". Income "+ getIncome().setScale(2, RoundingMode.CEILING)+". Taxpayer is free from the tax. Income is smaller than tax free allowance.");
            return BigDecimal.valueOf(0);
        }

    }
}
