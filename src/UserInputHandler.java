import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *  UserInputHandler: class for handling user input
 */
public class UserInputHandler {
    protected static Scanner scanner = new Scanner(System.in); // Scanner instance for user input

    /**
     * Handles different types of user input based on the provided type.
     *
     * @param type the type of input to handle (e.g., "User", "Book", "Staff", "Student")
     * @return the input value as a generic type
     */
    public static <T> T getInput(String type) {
        while (true) {
            try {
                return switch (type.toLowerCase()) {
                    case "user", "book", "staff" -> (T) (Integer) scanner.nextInt();
                    case "student" -> (T) scanner.nextLine();
                    default -> throw new IllegalArgumentException("Invalid input type");
                };
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid value.");
            } finally {
                scanner.nextLine();
            }

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
