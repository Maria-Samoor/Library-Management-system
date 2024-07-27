//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.List;

public class Main {
    private static final int STUDENT_USER = 1;
    private static final int STAFF_USER = 2;
    private static final int ADD_BOOK= 1;
    private static final int REMOVE_BOOK = 2;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Library library = new Library();

        Author author1 = new Author("naji", "male", "12345", "fiction");
        Book book1 = new Book("1234567891011", 2005, "book1", "paper", "company 1", author1);
        library.addBook(book1);

        Author author2 = new Author("alali", "male", "67890", "non-fiction");
        Book book2 = new Book("1110987654321", 2000, "book2", "pdf", "company 2", author2);
        library.addBook(book2);

        library.addStudent(new Student("maria", "female", "401899599", "237111"));
        library.addStudent(new Student("ahmad", "male", "401899999", "201172"));
        library.addStaff(new Staff("staff1", "male", "401899992", 50000));
        library.addStaff(new Staff("staff2", "female", "401899991", 60000));
        System.out.println("Enter 1 if you are a student, 2 if you are a staff:");
        int userType = scanner.nextInt();

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
        String studentId = scanner.next();
        if (library.isValidStudent(studentId)) {
            library.displayBooks();
            System.out.print("Enter index of the book you want to rent: ");
            int bookIndexToRent = scanner.nextInt();
            /*
             Thread: handle each borrow request in a Thread.
             Thread takes runnable object as an argument (implementation of abstract method (run) in runnable interface).
             runnable: functional interface, hence we can use lambda.               * library.rentBook(bookIndexToRent - 1) : implementation of run method.
            */
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
        System.out.println("Choose operation to perform: enter 1 to add Book and 2 to remove book:");
        int action = scanner.nextInt();

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
        System.out.println("Enter book details:");
        System.out.print("ISBN: ");
        String isbn = scanner.next();
        System.out.print("Year: ");
        int year = scanner.nextInt();
        System.out.print("Title: ");
        String title = scanner.next();
        System.out.print("Type: ");
        String type = scanner.next();
        System.out.print("Publisher: ");
        String publisher = scanner.next();
        System.out.print("Author name: ");
        String authorName = scanner.next();
        System.out.print("Author gender: ");
        String authorGender = scanner.next();
        System.out.print("Author national ID: ");
        String authorNationalID = scanner.next();
        System.out.print("Author genre: ");
        String authorGenre = scanner.next();

        Author author = new Author(authorName, authorGender, authorNationalID, authorGenre);
        Book newBook = new Book(isbn, year, title, type, publisher, author);
        library.addBook(newBook);
        System.out.println("Book added.");
    }

    /**
     * Prompts the user to enter the index of the book to remove and removes the book from the library.
     *
     * @param library the library instance
     */
    private static void removeBook(Library library) {
        library.displayBooks();
        System.out.print("Enter index of the book to remove: ");
        int removeIndex = scanner.nextInt();
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

