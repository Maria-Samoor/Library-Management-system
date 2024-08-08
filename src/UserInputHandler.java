import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  UserInputHandler: class for handling user input
 */
public class UserInputHandler {
    private static final int DEFAULT_INT = 0; // Default value for integer inputs
    private static final String DEFAULT_STRING = ""; // Default value for string inputs
    protected static final int TYPE_FLAG = 1; // Const used to determine user type
    protected static final int BOOK_RENT_FLAG = 2;// Const used to rent book by user of type student
    protected static final int STAFF_ACTION_FLAG = 3;// Const used for staff action
    protected static final int REMOVE_BOOK_FLAG = 4;// Const used to determine action of removing book by staff
    protected static Scanner scanner = new Scanner(System.in); // Scanner instance for user input

    /**
     * Handles different types of user input based on the provided flag.
     *
     * @param inputType the type of input to handle
     * @return the input value as an integer
     */
    public static int getInput(int inputType) {
        String prompt = switch (inputType) {
            case TYPE_FLAG -> "Enter 1 if you are a student, 2 if you are a staff:";
            case BOOK_RENT_FLAG -> "Enter index of the book you want to rent: ";
            case STAFF_ACTION_FLAG -> "Choose operation to perform: enter 1 to add Book and 2 to remove book:";
            case REMOVE_BOOK_FLAG -> "Enter index of the book to remove: ";
            default -> "Invalid input type";
        };
        System.out.println(prompt);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid number.");
            return DEFAULT_INT;
        }
        finally {
            scanner.nextLine();
        }
    }

    /**
     * Gets the student ID from the user input.
     *
     * @return the student ID
     */
    public static String getStudentId() {
        System.out.print("Enter your student ID: ");
        try {
            return scanner.next();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid student ID.");
            return DEFAULT_STRING;
        } finally {
            scanner.nextLine();
        }
    }

    /**
     * Gets the book details from the user input.
     *
     * @param bookAttributes the bookAttributes for the book details
     * @return the book details
     */
    public static String[] getBookDetails(String[] bookAttributes) {
        String[] details = new String[bookAttributes.length];
        try {
            for (int i = 0; i < bookAttributes.length; i++) {
                System.out.print(bookAttributes[i] );
                String input = scanner.nextLine().trim();
                if (input.isEmpty()) {
                    System.out.println("Invalid input. Book details cannot be empty.");
                    return null;
                }
                details[i] = input;
            }
        } catch (InputMismatchException e) {
            System.out.println("Invalid input type. Please enter the correct type of value.");
            scanner.nextLine();
            return null;
        }
        return details;
    }

}
