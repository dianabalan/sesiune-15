package employees.model;

public class Contractor extends Employee {

    private double hourlyPay;
    private int hoursPerDay;

    public Contractor(String cnp, String name, int seniority, double hourlyPay, int hoursPerDay) {
        super(cnp, name, seniority);
        this.hourlyPay = hourlyPay;
        this.hoursPerDay = hoursPerDay;
    }

    @Override
    public double calculateYearlyPay() {
        return 12 * 21 * hourlyPay * hoursPerDay;
    }



}
