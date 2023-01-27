package employees.model;

import java.util.ArrayList;
import java.util.List;

public class Intern extends Employee {

    private List<Double> grades;
    private int internshipDuration;

    private double monthlyPay;

    public Intern(String cnp, String name, int seniority, int internshipDuration, double monthlyPay) {
        super(cnp, name, seniority);
        this.grades = new ArrayList<>();
        this.internshipDuration = internshipDuration;
        this.monthlyPay = monthlyPay;
    }

    public void addGrade(double grade) {
        this.grades.add(grade);
    }


    @Override
    public double calculateYearlyPay() {
        return this.internshipDuration * this.monthlyPay;
    }
}
