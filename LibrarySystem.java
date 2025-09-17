class Book {
    public String ISBN;
    protected String title;
    private String author;

    Book(String isbn, String t, String a) {
        ISBN = isbn;
        title = t;
        author = a;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public String getAuthor() {
        return author;
    }

    public void display() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println();
    }
}

class EBook extends Book {
    double fileSize;

    EBook(String isbn, String t, String a, double size) {
        super(isbn, t, a);
        fileSize = size;
    }

    public void displayEBook() {
        System.out.println("ISBN: " + ISBN);
        System.out.println("Title: " + title);
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println("Author: " + getAuthor());
        System.out.println();
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        Book b1 = new Book("978-1234567890", "Java Basics", "James Gosling");
        b1.display();
        b1.setAuthor("John Doe");
        b1.display();

        EBook e1 = new EBook("978-0987654321", "Python Guide", "Guido van Rossum", 2.5);
        e1.displayEBook();
        e1.setAuthor("Alex Smith");
        e1.displayEBook();
    }
}
