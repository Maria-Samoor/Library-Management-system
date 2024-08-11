public class LibraryFactory {
    public static Library createLibrary(String objectsType) {
        Library library = new Library();
        switch (objectsType.toLowerCase()) {
            case "books":
                addBooks(library);
                break;
            case "students":
                addStudents(library);
                break;
            case "staff":
                addStaff(library);
                break;
            case "all":
                addBooks(library);
                addStudents(library);
                addStaff(library);
                break;
            default:
                System.out.println("Unknown" + objectsType);
                break;
        }
        return library;
    }

    private static void addBooks(Library library) {
        Author fictionAuthor = new Author("naji", "male", "12345", "fiction");
        Book paperBook = new Book("1234567891011", 2005, "paperBook", "paper", "company 1", fictionAuthor);
        library.addBook(paperBook);

        Author nonFictionAuthor = new Author("alali", "male", "67890", "non-fiction");
        Book pdfBook = new Book("1110987654321", 2000, "pdfBook", "pdf", "company 2", nonFictionAuthor);
        library.addBook(pdfBook);
    }

    private static void addStudents(Library library) {
        library.addStudent(new Student("maria", "female", "401899599", "237111"));
        library.addStudent(new Student("ahmad", "male", "401899999", "201172"));
    }

    private static void addStaff(Library library) {
        library.addStaff(new Staff("staff1", "male", "401899992", 50000));
        library.addStaff(new Staff("staff2", "female", "401899991", 60000));
    }
}
