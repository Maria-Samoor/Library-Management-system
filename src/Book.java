public class Book {
    private int isbn;// international standard book number, unique for each book
    private int year; //year of publish
    private String title;
    private String type; //book type, ex: pdf, audio, paper, etc.
    private String publisher; //the name of the company that published the book
    private Author author;

    public Book(int isbn, int year, String title, String type, String publisher, Author author) {
        this.isbn = isbn;
        this.year = year;
        this.title = title;
        this.type = type;
        this.publisher = publisher;
        this.author = author;
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public Book(int isbn, int year, String title, String type, Author author) {
        this.isbn = isbn;
        this.year = year;
        this.title = title;
        this.type = type;
        this.author = author;
    }

    public Book(int isbn) {
        this.isbn = isbn;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

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