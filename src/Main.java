//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final int STUDENT_USER = 1;// Identifier for student user type
    private static final int STAFF_USER = 2;// Identifier for staff user type
    private static final int ADD_BOOK= 1; // Action code for adding a book
    private static final int REMOVE_BOOK = 2; // Action code for removing a book
    private static Scanner scanner = new Scanner(System.in);// Scanner instance for user input
    
    public static void main(String[] args) {
        Library library = new Library();

        Author fictionAuthor = new Author("naji", "male", "12345", "fiction");
        Book paperBook = new Book("1234567891011", 2005, "paperBook", "paper", "company 1", fictionAuthor);
        library.addBook(paperBook);

        Author nonFictionAuthor = new Author("alali", "male", "67890", "non-fiction");
        Book pdfBook = new Book("1110987654321", 2000, "pdfBook", "pdf", "company 2", nonFictionAuthor);
        library.addBook(pdfBook);

        library.addStudent(new Student("maria", "female", "401899599", "237111"));
        library.addStudent(new Student("ahmad", "male", "401899999", "201172"));
        library.addStaff(new Staff("staff1", "male", "401899992", 50000));
        library.addStaff(new Staff("staff2", "female", "401899991", 60000));
        int userType = UserInputHandler.getUserType();

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
        String studentId = UserInputHandler.getStudentId();
        if (library.isValidStudent(studentId)) {
            library.displayBooks();
            int bookIndexToRent = UserInputHandler.getBookIndexToRent();
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
        int action = UserInputHandler.getStaffAction();
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
        String[] bookDetails = UserInputHandler.getBookDetails(bookAttributes);

        Author author = new Author(bookDetails[5], bookDetails[6], bookDetails[7], bookDetails[8]);
        Book newBook = new Book(bookDetails[0], Integer.parseInt(bookDetails[1]), bookDetails[2], bookDetails[3], bookDetails[4], author);
        library.addBook(newBook);
        System.out.println("Book added.");
    }

    /**
     * Prompts the user to enter the index of the book to remove the book from the library.
     *
     * @param library the library instance
     */
    private static void removeBook(Library library) {
        library.displayBooks();
        int removeIndex = UserInputHandler.getRemoveBookIndex();
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

