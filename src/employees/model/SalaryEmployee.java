package employees.model;

public class SalaryEmployee extends Employee {

    private double monthlySalary;

    private String benefitsPackageOption;

    public SalaryEmployee(String cnp, String name, int seniority, double monthlySalary, String benefitsPackageOption) {
        super(cnp, name, seniority);
        this.monthlySalary = monthlySalary;
        this.benefitsPackageOption = benefitsPackageOption;
    }

    @Override
    public double calculateYearlyPay() {
        return 12 * this.monthlySalary;
    }
}
