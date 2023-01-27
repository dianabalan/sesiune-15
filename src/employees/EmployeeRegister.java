package employees;

import employees.exceptions.EmployeeAlreadyExistsException;
import employees.exceptions.InexistentEmployeeException;
import employees.model.Employee;

import java.util.HashSet;
import java.util.Set;

public class EmployeeRegister {

    public static int countInterns = 0;
    public static int countContractors = 0;
    public static int countSalariedEmployees = 0;

    private Set<Employee> employees;

    public EmployeeRegister() {
        this.employees = new HashSet<>();
    }


    public void add(Employee employee) throws Exception {
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyExistsException(String.format("Employee with cnp: %s already exists.", employee.getCnp()));
        } else {
            try {
                employees.add(employee);
            } catch (Exception e) {
                throw new Exception(String.format("Something happened when adding employee: %s ", e.getMessage()));
            }
        }

    }


    public Employee removeByCnp(String cnp) throws Exception {
        for (Employee employee : this.employees) {
            if (employee.getCnp().equals(cnp)) {
                try {
                    this.employees.remove(employee);
                    System.out.println(String.format("Successfully removed %s", employee));
                    return employee;
                } catch (Exception e) {
                    throw new Exception(String.format("Something happened when removing employee: %s", e.getMessage()));
                }
            }
        }

        throw new InexistentEmployeeException(String.format("Employee with cnp: %s does not exist.", cnp));
    }

    public Employee searchByCnp(String cnp) throws InexistentEmployeeException {
        for (Employee employee : this.employees) {
            if (employee.getCnp().equals(cnp)) {
                return employee;
            }
        }

        throw new InexistentEmployeeException(String.format("Employee with cnp: %s does not exist.", cnp));
    }


    public double totalYearlyPay() {
        double total = 0.0;
        for (Employee employee : this.employees) {
            total += employee.calculateYearlyPay();
        }
        return total;
    }

    @Override
    public String toString() {
        return "EmployeeRegister{" +
                "employees=" + employees +
                '}';
    }
}
