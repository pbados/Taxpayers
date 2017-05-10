import java.math.BigDecimal;

/**
 * Created by Patryk on 20-02-2017.
 */
public class Taxpayer {
    protected String name;
    protected String surname;
    protected int age;
    protected String country;
    protected BigDecimal income;

    protected static BigDecimal taxFreeAllowance = new BigDecimal(2000);
    protected static BigDecimal taxAmount = new BigDecimal(0.2); //20%

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getIncome() {
        return income;
    }

    public void setIncome(BigDecimal income) {
        this.income = income;
    }

    public static BigDecimal getTaxFreeAllowance() {
        return taxFreeAllowance;
    }

    public static void setTaxFreeAllowance(BigDecimal taxFreeAllowance) {
        Taxpayer.taxFreeAllowance = taxFreeAllowance;
    }

    public static BigDecimal getTaxAmount() {
        return taxAmount;
    }

    public static void setTaxAmount(BigDecimal taxAmount) {
        Taxpayer.taxAmount = taxAmount;
    }

    public Taxpayer(String name, String surname, int age, String country, BigDecimal income) {
        super();
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.country = country;
        this.income = income;
    }

    @Override
    public String toString() {
        return "Podatnik{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", country='" + country + '\'' +
                ", income=" + income +
                '}';
    }

    public BigDecimal taxCalculate(){
        return (getIncome().subtract(taxFreeAllowance)).multiply(taxAmount);
    }
}
