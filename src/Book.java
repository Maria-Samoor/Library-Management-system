import java.security.InvalidParameterException;
import java.time.DateTimeException;
import java.time.Year;

/**
 * Represents a book with attributes such as ISBN, year of publication, title, type, publisher, and author.
 */
public class Book {
    private int year;
    private String title;
    private String isbn;
    private String type;
    private String publisher;
    private Author author;

    /**
     * Constructor to Initialize a Book object with ISBN, year, title, type, publisher, and author.
     *
     * @param isbn       the ISBN of the book
     * @param year       the year of publication
     * @param title      the title of the book
     * @param type       the type of the book
     * @param publisher  the publisher of the book
     * @param author     the author of the book
     */
    public Book(String isbn, int year, String title, String type, String publisher, Author author) {
        this.isbn = isbn;
        this.year = year;
        this.title = title;
        this.type = type;
        this.publisher = publisher;
        this.author = author;
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Sets the ISBN of the book.
     *
     * @param isbn  the ISBN to set
     */
    public void setIsbn(String isbn) {
        if (isbn.length() == 13) {
            this.isbn = isbn;
        } else {
            throw new InvalidParameterException("ISBN must 13 digits long.");
        }
    }

    /**
     * Gets the year of publication.
     *
     * @return the year of publication
     */
    public int getYear() {
        return year;
    }

    /**
     * Sets the year of publication.
     * Ensures the year is positive and not in the future.
     *
     * @param year  the year of publication to set
     */
    public void setYear(int year) {
        int currentYear = Year.now().getValue();
        if (year > 0 && year <= currentYear) {
            this.year = year;
        } else {
            throw new DateTimeException("Year must be a positive number and not in the future.");
        }
    }

    /**
     * Gets the title of the book.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the book.
     *
     * @param title  the title to set
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the type of the book.
     *
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the type of the book.
     *
     * @param type  the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * Gets the publisher of the book.
     *
     * @return the publisher
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Sets the publisher of the book.
     *
     * @param publisher  the publisher to set
     */
    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * Sets the author of the book.
     *
     * @param author  the author to set
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * Returns a string representation of the book.
     *
     * @return a string representation of the book
     */
    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", year=" + year +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", publisher='" + publisher + '\'' +
                ", author=" + author +
                '}';
    }
}