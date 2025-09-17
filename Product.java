public class Product {
    String productName;
    double price;
    static int totalProducts = 0;

    Product(String name, double p) {
        productName = name;
        price = p;
        totalProducts++;
    }

    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
        System.out.println();
    }

    static void displayTotalProducts() {
        System.out.println("Total Products: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Phone", 25000);
        Product p3 = new Product("Tablet", 30000);

        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        Product.displayTotalProducts();
    }
}
    