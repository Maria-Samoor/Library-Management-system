import java.util.Scanner;
import java.util.List;

public class Main {
    private static final int STUDENT_USER = 1;// Identifier for student user type
    private static final int STAFF_USER = 2;// Identifier for staff user type
    private static final int ADD_BOOK= 1; // Action code for adding a book
    private static final int REMOVE_BOOK = 2; // Action code for removing a book
    private static Scanner scanner = new Scanner(System.in);// Scanner instance for user input

    public static void main(String[] args) {

        Library library = LibraryFactory.createLibrary("all");
        System.out.print("Enter 1 if you are a student, 2 if you are a staff: ");
        int userType = UserInputHandler.<Integer>getInput("User");
        if (userType == STUDENT_USER) {
            handleStudent(library);
        } else if (userType == STAFF_USER) {
            handleStaff(library);
            displayMaxSalary(library);
        } else {
            System.out.println("Invalid input.");
        }
        scanner.close();
    }

    /**
     * Handles operations for students, such as renting books.
     *
     * @param library the library instance
     */
    private static void handleStudent(Library library) {
        System.out.print("Enter your student ID: ");
        String studentId = UserInputHandler.<String>getInput("Student");
        if (library.isValidStudent(studentId)) {
            library.displayBooks();
            System.out.print("Enter index of the book you want to rent: ");
            int bookIndexToRent = UserInputHandler.<Integer>getInput("Book");
            new Thread(() -> library.rentBook(bookIndexToRent - 1)).start();
        } else {
            System.out.println("Invalid student ID.");
        }
    }

    /**
     * Handles operations for staff, such as adding or removing books.
     *
     * @param library the library instance
     */
    private static void handleStaff(Library library) {
        System.out.print("Choose operation to perform: enter 1 to add Book and 2 to remove book: ");
        int action = UserInputHandler.<Integer>getInput("Staff");
        if (action == ADD_BOOK) {
            addBook(library);
        } else if (action == REMOVE_BOOK) {
            removeBook(library);
        } else {
            System.out.println("Invalid input.");
        }
    }

    /**
     * Prompts the user to enter book details and adds the book to the library.
     *
     * @param library the library instance
     */
    private static void addBook(Library library) {
        String[] bookAttributes = {"ISBN: ", "Year: ", "Title: ", "Type: ", "Publisher: ", "Author name: ", "Author gender: ", "Author national ID: ", "Author genre: "};
        try{
        String[] bookDetails = UserInputHandler.getBookDetails(bookAttributes);
        Author author = new Author(bookDetails[5], bookDetails[6], bookDetails[7], bookDetails[8]);
        Book newBook = new Book(bookDetails[0], Integer.parseInt(bookDetails[1]), bookDetails[2], bookDetails[3], bookDetails[4], author);
        library.addBook(newBook);
        } catch (NullPointerException e) {
            System.out.println("You need to add book info");
        }
    }

    /**
     * Prompts the user to enter the index of the book to remove the book from the library.
     *
     * @param library the library instance
     */
    private static void removeBook(Library library) {
        library.displayBooks();
        System.out.print("Enter index of the book to remove: ");
        int removeIndex = UserInputHandler.<Integer>getInput("Book");
        library.removeBook(removeIndex - 1);
        System.out.println("Book removed.");
    }

    /**
     * Displays the maximum salary of the staff members using streams.
     *
     * @param library the library instance
     */
    private static void displayMaxSalary(Library library) {
        List<Staff> staffList = library.getStaff();
        if (staffList.isEmpty()) {
            System.out.println("No staff members available.");
            return;
        }
        float maxSalary = (float) staffList
                .stream()
                .mapToDouble(Staff::getSalary)
                .max()
                .orElse(0);

        System.out.println("Maximum salary among staff members: " + maxSalary);
    }

}

