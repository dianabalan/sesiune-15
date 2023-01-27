package employees.exceptions;

public class InexistentEmployeeException extends Exception {

    public InexistentEmployeeException(String message) {
        super(message);
    }
}
