//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();

        Author author1 = new Author("naji", "male", "12345", "fiction");
        Book book1 = new Book(123, 2005, "book1", "paper", "company 1", author1);
        library.addBook(book1);

        Author author2 = new Author("alali", "male", "67890", "non-fiction");
        Book book2 = new Book(456, 2000, "book2", "pdf", "company 2", author2);
        library.addBook(book2);

        library.addStudent(new Student("maria", "female", "401899599", "237111"));
        library.addStudent(new Student("ahmad", "male", "401899999", "201172"));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 1 if you are a student, 2 if you are a staff:");
        int userType = scanner.nextInt();

        if (userType == 1) {
            System.out.println("Enter your student ID:");
            String studentId = scanner.next();
            if (library.isValidStudent(studentId)) {
                library.displayBooks();
                System.out.println("Enter index of the book you want to rent:");
                int bookIndexToRent = scanner.nextInt();
                /*
                * Thread: handle each borrow request in a Thread.
                * Thread takes runnable object as an argument (implementation of abstract method (run) in runnable interface).
                * runnable: functional interface, hence we can use lambda.
                * library.rentBook(bookIndexToRent - 1) : implementation of run method.
                */
                new Thread(() -> library.rentBook(bookIndexToRent - 1)).start();
            } else {
                System.out.println("Invalid student ID.");
            }
        } else if (userType == 2) {
            System.out.println("Choose operation to perform: enter 1 to add Book and 2 to remove book:");
            int action = scanner.nextInt();

            switch (action) {
                case 1:
                    System.out.println("Enter book details:");
                    System.out.print("ISBN: ");
                    int isbn = scanner.nextInt();
                    System.out.print("year: ");
                    int year = scanner.nextInt();
                    System.out.print("title: ");
                    String title = scanner.nextLine();
                    System.out.print("type: ");
                    String type = scanner.nextLine();
                    System.out.print("publisher: ");
                    String publisher = scanner.nextLine();
                    System.out.print("author name: ");
                    String authorName = scanner.nextLine();
                    System.out.print("author gender: ");
                    String authorGender = scanner.nextLine();
                    System.out.print("author national ID: ");
                    String authorNationalID = scanner.nextLine();
                    System.out.print("author genre: ");
                    String authorGenre = scanner.nextLine();
                    Author author = new Author(authorName, authorGender, authorNationalID, authorGenre);
                    Book newBook = new Book(isbn, year, title, type, publisher, author);
                    library.addBook(newBook);
                    System.out.println("book added.");
                    break;
                case 2:
                    library.displayBooks();
                    System.out.println("Enter index of the book to remove:");
                    int removeIndex = scanner.nextInt();
                    library.removeBook(removeIndex - 1);
                    System.out.println("book removed.");
                    break;
                default:
                    System.out.println("Invalid input.");
                    break;
            }
        } else {
            System.out.println("Invalid input.");
        }

        scanner.close();
    }
}