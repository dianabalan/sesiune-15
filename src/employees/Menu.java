package employees;

import employees.exceptions.InexistentEmployeeException;
import employees.model.Contractor;
import employees.model.Employee;
import employees.model.Intern;
import employees.model.SalaryEmployee;

import java.util.Objects;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EmployeeRegister register = new EmployeeRegister();

        do {
            displayMainMenu();
            processOption(scanner, register);
        } while (true);
    }

    private static void processOption(Scanner scanner, EmployeeRegister register) {
        int option;
        String cnp;
        System.out.println("Choose option: ");
        try {
            option = Integer.parseInt(scanner.nextLine());

            switch (option) {
                case 0:
                    System.exit(0);
                case 1:
                    displaySubMenu();
                    Employee employee = readEmployeeInfo(scanner);
                    if (!Objects.isNull(employee)) { //employee!=null
                        try {
                            register.add(employee);
                            updateCount(employee, +1);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                    }
                    break;
                case 2:
                    System.out.println("Input cnp: ");
                    cnp = scanner.nextLine();
                    try {
                        Employee removed = register.removeByCnp(cnp);
                        updateCount(removed, -1);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    break;
                case 3:
                    System.out.println("Input cnp: ");
                    cnp = scanner.nextLine();

                    try {
                        register.searchByCnp(cnp);
                    } catch (InexistentEmployeeException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Number of interns¶: " + EmployeeRegister.countInterns);
                    break;
                case 5:
                    System.out.println("Number of contractors: " + EmployeeRegister.countContractors);
                    break;
                case 6:
                    System.out.println("Number of salary employees: " + EmployeeRegister.countSalariedEmployees);
                    break;
                case 7:
                    System.out.println("Total yearly pay : " + register.totalYearlyPay());
                    break;
                case 8:
                    System.out.println(register);
                    break;
                default:
                    System.out.println("Invalid option.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Option is not a number.");
        }
    }

    /*
    sign can have values: -1, +1
     */
    private static void updateCount(Employee removed, int sign) {
        if (removed instanceof Intern) {
            EmployeeRegister.countInterns += sign;
        } else if (removed instanceof Contractor) {
            EmployeeRegister.countContractors += sign;
        } else {
            EmployeeRegister.countSalariedEmployees += sign;
        }
    }

    private static Employee readEmployeeInfo(Scanner scanner) {
        try {
            int employeeType = Integer.parseInt(scanner.nextLine());

            System.out.println("Input cnp: ");
            String cnp = scanner.nextLine();
            System.out.println("Input name: ");
            String name = scanner.nextLine();
            System.out.println("Input seniority: ");
            int seniority = Integer.parseInt(scanner.nextLine());

            switch (employeeType) {
                case 1:
                    System.out.println("Input internship duration: ");
                    int internshipDuration = Integer.parseInt(scanner.nextLine());

                    System.out.println("Input monthly pay: ");
                    double monthlyPay = Double.parseDouble(scanner.nextLine());
                    return new Intern(cnp, name, seniority, internshipDuration, monthlyPay);

                case 2:
                    System.out.println("Input hourly pay: ");
                    int hourlyPay = Integer.parseInt(scanner.nextLine());

                    System.out.println("Input hours per day worked: ");
                    int hoursPerDay = Integer.parseInt(scanner.nextLine());
                    return new Contractor(cnp, name, seniority, hourlyPay, hoursPerDay);

                case 3:
                    System.out.println("Input monthly salary: ");
                    double monthlySalary = Double.parseDouble(scanner.nextLine());

                    System.out.println("Input benefits package option: ");
                    String benefitsOption = scanner.nextLine();

                    return new SalaryEmployee(cnp, name, seniority, monthlySalary, benefitsOption);
                default:
                    System.out.println("Invalid option.");
                    return null;
            }

        } catch (NumberFormatException e) {
            System.out.println("Option is not a number");
            return null;
        }

    }

    private static void displaySubMenu() {
        System.out.println("Choose option for employee type: ");
        System.out.println("1. Intern");
        System.out.println("2. Contractor");
        System.out.println("3. Salary employee");
    }


    private static void displayMainMenu() {
        System.out.println("**********MENU**********");

        System.out.println("0. Exit");
        System.out.println("1. Add employee");
        System.out.println("2. Remove by cnp");
        System.out.println("3. Search by cnp");
        System.out.println("4. Number of interns");
        System.out.println("5. Number of contractors");
        System.out.println("6. Number of salaried employees");
        System.out.println("7. Calculate yearly pay - all employees");
        System.out.println("8. Display all");
        System.out.println("************************");
    }
}
