public class Book2 {
    String title;
    String author;
    double price;
    boolean available;

    Book2(String t, String a, double p, boolean av) {
        title = t;
        author = a;
        price = p;
        available = av;
    }

    void borrowBook() {
        if (available) {
            available = false;
            System.out.println(title + " has been borrowed.");
        } else {
            System.out.println(title + " is not available.");
        }
    }

    void display() {
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Available: " + available);
        System.out.println();
    }

    public static void main(String[] args) {
        Book2 b1 = new Book2("Java Basics", "James Gosling", 499.99, true);
        b1.display();
        b1.borrowBook();
        b1.display();
        b1.borrowBook();
    }
}
