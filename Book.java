public class Book {
    private static String libraryName = "Default Library";

    private final String isbn;
    private String title;
    private String author;

    public Book(String title, String author, String isbn) {
        this.title = this.title = title;
        this.author = this.author = author;
        this.isbn = isbn;
    }

    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    public static void setLibraryName(String name) {
        libraryName = name;
    }

    public void displayDetails() {
        if (this instanceof Book) {
            System.out.println("Title: " + title);
            System.out.println("Author: " + author);
            System.out.println("ISBN: " + isbn);
        } else {
            System.out.println("Not a valid Book object.");
        }
    }

    public static void main(String[] args) {
        Book.setLibraryName("Copilot Library");
        Book book1 = new Book("Java Basics", "Alice", "1111");
        Book book2 = new Book("Python Essentials", "Bob", "2222");

        Book.displayLibraryName();
        book1.displayDetails();
        System.out.println();
        book2.displayDetails();
    }
}