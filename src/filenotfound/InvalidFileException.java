package filenotfound;

public class InvalidFileException extends Exception {

    private String internalCode;

    public InvalidFileException(String internalCode){
        super("Invalid file.");
        this.internalCode = internalCode;
    }

    public String getInternalCode() {
        return internalCode;
    }
}
