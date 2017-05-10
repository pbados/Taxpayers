import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * Created by Patryk on 20-02-2017.
 */
public class Main {

    public static BigDecimal totalTax(Taxpayer[] p, Test t) {
        BigDecimal totalTax=new BigDecimal(0);
        for(int i=0;i<p.length;i++){
            if(t.test(p[i])){
                totalTax = totalTax.add(p[i].taxCalculate());
            }
        }
        return totalTax;
    }
    public static void main(String[] args) {

        Taxpayer[] taxpayers = new Taxpayer[]{
                new TaxpayerRelief("Jan", "Kowalski", 23, "Poland", new BigDecimal(3442.05)),
                new TaxpayerRelief("Miguel", "Soros", 21, "Portugal", new BigDecimal(34984.47)),
                new TaxpayerRelief("Marius", "Jankauskas", 21, "Lithuania", new BigDecimal(7842.93)),
                new TaxpayerRelief("Thomas", "Reus", 25, "Germany", new BigDecimal(6622.00)),
                new TaxpayerRelief("Marcin", "Gutek", 69, "Poland", new BigDecimal(32.30)),
                new TaxpayerRelief("Jura", "Kopanenko", 42, "Russia", new BigDecimal(8725.14)),
                new TaxpayerRelief("Clara", "Pierre", 42, "France", new BigDecimal(465.77)),
                new TaxpayerRelief("Jesus", "Villa", 22, "Spain", new BigDecimal(22542.78)),
                new TaxpayerRelief("Lucas", "Hohannson", 24, "Sweden", new BigDecimal(423542.23)),
        };

        BigDecimal sumOfTaxes = totalTax(taxpayers, p -> p.getAge() >= 20 && p.getAge() <= 65 /*&& p.taxCalculate().compareTo(BigDecimal.valueOf(200)) > 0 */);

        MathContext mc = new MathContext(2, RoundingMode.CEILING);
        System.out.println("Sum of the taxes to pay by all taxpayers: "+sumOfTaxes.setScale(2, RoundingMode.CEILING));
    }
}

