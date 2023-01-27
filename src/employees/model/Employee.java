package employees.model;

import java.util.Objects;

public abstract class Employee {

    private String cnp;
    private int seniority; //expressed in months
    private String name;

    public Employee(String cnp){
        this.cnp = cnp;
    }

    public Employee(String cnp, String name, int seniority) {
        this.cnp = cnp;
        this.name = name;
        this.seniority = seniority;
    }

    public abstract double calculateYearlyPay();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Employee employee = (Employee) o;
        return Objects.equals(cnp, employee.cnp);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cnp);
    }

    public String getCnp() {
        return cnp;
    }


    @Override
    public String toString() {
        return "Employee{" +
                "cnp='" + cnp + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    public int getSeniority() {
        return seniority;
    }

    public String getName() {
        return name;
    }
}
