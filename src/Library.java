import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
class Library {
    private ArrayList<Book> books;
    private ArrayList<Student> students;
    private Lock lock = new ReentrantLock(); //lock used for synchronization

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        try {
            books.remove(index);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("This index does not exist.");
        }
    }

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

    public void rentBook(int index) {
        if (index < 0 || index >= books.size()) {
            System.out.println("This index does not exist.");
            return;
        }

        //synchronized(object): to ensure one thread can access this object at a time
        synchronized (books.get(index)) {
            System.out.println("You have rented: " + books.get(index));
            books.remove(index);
        }

    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public boolean isValidStudent(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equals(studentId)) {
                return true;
            }
        }
        return false;
    }
}