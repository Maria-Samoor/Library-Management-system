import java.util.InputMismatchException;
import java.util.Scanner;

public class UserInputHandler {
    private static final int DEFAULT_INT = 0; // Default value for integer inputs
    private static final String DEFAULT_STRING = ""; // Default value for string inputs
    private static Scanner scanner = new Scanner(System.in); // Scanner instance for user input

    /**
     * Gets the user type from the user input.
     *
     * @return the user type
     */
    public static int getUserType() {
        System.out.println("Enter 1 if you are a student, 2 if you are a staff:");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number (1 or 2).");
            return DEFAULT_INT;
        } finally {
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
     * Gets the book index to rent from the user input.
     *
     * @return the book index to rent
     */
    public static int getBookIndexToRent() {
        System.out.print("Enter index of the book you want to rent: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid index.");
            return DEFAULT_INT;
        } finally {
            scanner.nextLine();
        }
    }

    /**
     * Gets the action from the user input for staff operations.
     *
     * @return the action
     */
    public static int getStaffAction() {
        System.out.println("Choose operation to perform: enter 1 to add Book and 2 to remove book:");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a number (1 or 2).");
            return DEFAULT_INT;
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
        for (int i = 0; i < bookAttributes.length; i++) {
            System.out.print(bookAttributes[i]);
            try {
                details[i] = scanner.next();
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter valid details.");
                details[i] = DEFAULT_STRING;
            } finally {
                scanner.nextLine();
            }
        }
        return details;
    }

    /**
     * Gets the index of the book to remove from the user input.
     *
     * @return the index of the book to remove
     */
    public static int getRemoveBookIndex() {
        System.out.print("Enter index of the book to remove: ");
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid index.");
            return DEFAULT_INT;
        } finally {
            scanner.nextLine(); // clear the invalid input
        }
    }
}
