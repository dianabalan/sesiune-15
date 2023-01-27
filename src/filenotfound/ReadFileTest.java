package filenotfound;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ReadFileTest {

    public static void main(String[] args) {


        Scanner scanner = null;

        try {

            String fileName = "file_input.txt";

            validate(fileName);

            scanner = new Scanner(new File(fileName));

            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());
            System.out.println(scanner.nextLine());

            System.exit(0);

        } catch (NoSuchElementException e) {
            System.out.println("No more lines!");
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (InvalidFileException e) {
            System.out.println(e.getMessage() + " : " + e.getInternalCode());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    private static void validate(String fileName) throws Exception {
        if (!fileName.contains(".")) {
            throw new Exception("This is not a valid file name! Should contain point. " + fileName);
        }

        if (!fileName.startsWith("file_")) {
            throw new InvalidFileException(InternalCode.INVALID_PREFIX);
        }
        if (!fileName.endsWith(".txt")) {
            throw new InvalidFileException(InternalCode.INVALID_EXTENSION);
        }
    }


}
