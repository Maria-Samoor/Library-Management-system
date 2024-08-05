import java.util.ArrayList;
import java.util.List;

/**
 * Represents a library that manages a collection of books, students, and staff.
 * Provides functionality to add, remove, display, and rent books,
 * Provides functionality to add, remove, and display students, and staff.
 */

class Library {
    private ArrayList<Book> books; // List to store the books in the library
    private ArrayList<Student> students; // List to store the students registered in the library
    private ArrayList<Staff> staff; // List to store the staff members of the library

    /**
     * Constructor initialize a new Library instance with empty lists for books, students, and staff.
     */
    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
        staff = new ArrayList<>();
    }

    /**
     * Adds a book to the library's collection.
     *
     * @param book  the book to add to the library
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new NullPointerException("Cannot add a null book.");
        }
        books.add(book);
    }

    /**
     * Removes a book from the library's collection based on the provided index.
     * Handles cases where the index is out of bounds.
     *
     * @param index  the index of the book to remove
     */
    public void removeBook(int index) {
        try {
            books.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This index does not exist.");
        }
    }

    /**
     * Displays all available books in the library.
     * If no books are available, a message is displayed.
     */
    public void displayBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }
        System.out.println("Available books:");
        for (int i = 0; i < books.size(); i++) {
            Book book = books.get(i);
            System.out.println(i + 1 + " - Title: " + book.getTitle());
        }
    }

    /**
     * Rents a book to a user based on the provided index.
     * synchronized(object) used to ensure one thread can access this object at a time
     *
     * @param index  the index of the book to rent
     */
    public void rentBook(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("This index does not exist.");
            return;
        }
        synchronized (books.get(index)) {
            System.out.println("You have rented: " + books.get(index));
            books.remove(index);
        }

    }

    /**
     * Adds a student to the library's list of registered students.
     *
     * @param student  the student to add to the library
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Checks if a student ID is valid by comparing it against the list of registered students.
     *
     * @param studentId  the ID of the student to validate
     * @return true if the student ID is found, false otherwise
     */
    public boolean isValidStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Adds a staff member to the library's list of staff members.
     *
     * @param staffMember  the staff member to add to the library
     */
    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
    }

    /**
     * Removes a staff member from the library's list based on the provided index.
     * Handles cases where the index is out of bounds.
     *
     * @param index  the index of the staff member to remove
     */
    public void removeStaff(int index) {
        try {
            staff.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This index does not exist.");
        }
    }

    /**
     * Displays all staff members in the library.
     * If no staff members are available, a message is displayed.
     */
    public void displayStaff() {
        if (staff.isEmpty()) {
            System.out.println("No staff members available.");
            return;
        }
        System.out.println("Staff members:");
        for (int i = 0; i < staff.size(); i++) {
            Staff staffMember = staff.get(i);
            System.out.println(i + 1 + " - Name: " + staffMember.getName() + ", Salary: " + staffMember.getSalary());
        }
    }
    /**
     * Gets the list of staff members.
     *
     * @return the list of staff members
     */
    public List<Staff> getStaff() {
        return staff;
    }
}