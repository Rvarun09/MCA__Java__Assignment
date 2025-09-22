public class Product {
    private static double discount = 0.0;

    private final String productID;
    private String productName;
    private double price;
    private int quantity;

    public Product(String productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
    }

    public void displayDetails() {
        if (this instanceof Product) {
            System.out.println("Product ID: " + productID);
            System.out.println("Product Name: " + productName);
            System.out.println("Price: " + price);
            System.out.println("Quantity: " + quantity);
            System.out.println("Discount: " + discount + "%");
        } else {
            System.out.println("Not a valid Product object.");
        }
    }

    public static void main(String[] args) {
        Product.updateDiscount(10.0);
        Product p1 = new Product("P001", "Laptop", 50000.0, 2);
        Product p2 = new Product("P002", "Mouse", 500.0, 5);

        p1.displayDetails();
        System.out.println();
        p2.displayDetails();
    }
}