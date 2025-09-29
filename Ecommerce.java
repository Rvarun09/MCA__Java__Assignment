abstract class Product {
    private int productId;
    private String name;
    private double price;
    public Product(int productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }
    public int getProductId() {
        return productId;
    }
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {  
        this.price = price;
    }
    public abstract double calculateDiscount();
    public abstract void printFinalPrice();
}
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}
class Electronics extends Product implements Taxable {
    public Electronics(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10;
    }
    @Override
    public double calculateTax() {
        return getPrice() * 0.18; 
    }
    @Override
    public String getTaxDetails() {
        return "Electronics Tax: 18%";
    }
    @Override
    public void printFinalPrice() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;
        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Base Price: " + getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println(getTaxDetails());
        System.out.println("Final Price: " + finalPrice);
        System.out.println("--------------------------");
    }
}
class Clothing extends Product implements Taxable {
    public Clothing(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20;
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; 
    }
    @Override
    public String getTaxDetails() {
        return "Clothing Tax: 5%";
    }
    @Override
    public void printFinalPrice() {
        double discount = calculateDiscount();
        double tax = calculateTax();
        double finalPrice = getPrice() + tax - discount;

        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Base Price: " + getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("Tax: " + tax);
        System.out.println(getTaxDetails());
        System.out.println("Final Price: " + finalPrice);
        System.out.println("--------------------------");
    }
}
class Groceries extends Product {
    public Groceries(int productId, String name, double price) {
        super(productId, name, price);
    }
    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05;
    }
    @Override
    public void printFinalPrice() {
        double discount = calculateDiscount();
        double finalPrice = getPrice() - discount; // no tax

        System.out.println("Product ID: " + getProductId());
        System.out.println("Name: " + getName());
        System.out.println("Base Price: " + getPrice());
        System.out.println("Discount: " + discount);
        System.out.println("No Tax applicable.");
        System.out.println("Final Price: " + finalPrice);
        System.out.println("--------------------------");
    }
}
public class Ecommerce{
    public static void main(String[] args) {
        Electronics laptop = new Electronics(101, "Laptop", 60000);
        Clothing shirt = new Clothing(102, "Shirt", 2000);
        Groceries rice = new Groceries(103, "Rice Bag", 1500);
        laptop.printFinalPrice();
        shirt.printFinalPrice();
        rice.printFinalPrice();
    }
}
