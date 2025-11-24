import java.util.ArrayList;
import java.util.List;

class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    @Override
    public String toString() {
        return "'" + title + "' by " + author;
    }
}

class Library {
    private String name;
    private List<Book> books; 

    public Library(String name) {
        this.name = name;
    
        this.books = new ArrayList<>(); 
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void displayLibrary() {
        System.out.println("--- Library: " + name + " ---");
        if (books.isEmpty()) {
            System.out.println("No books currently in catalog.");
        } else {
            for (Book b : books) {
                System.out.println(b);
            }
        }
        System.out.println(); 
    }
}

public class LibrarySystem {
    public static void main(String[] args) {
        
        Book b1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book b2 = new Book("1984", "George Orwell");
        Book b3 = new Book("Clean Code", "Robert C. Martin");

        Library cityLib = new Library("City Central Library");
        Library uniLib = new Library("University Tech Library");

        cityLib.addBook(b1);
        cityLib.addBook(b2);
        
        uniLib.addBook(b3);
        uniLib.addBook(b2); 

       
        cityLib.displayLibrary();
        uniLib.displayLibrary();

        cityLib = null; 
        
        System.out.println(">> City Library has been destroyed.");
        System.out.println(">> Verifying if Book 1 still exists...");
        System.out.println(">> Result: " + b1); 
    }
}