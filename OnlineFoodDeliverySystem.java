abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }

    public abstract double calculateTotalPrice();
}

interface Discountable {
    double applyDiscount(double total);
    String getDiscountDetails();
}

class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity();
    }

    @Override
    public double applyDiscount(double total) {
        return total - (total * 0.1);
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount applied on Veg Item.";
    }
}

class NonVegItem extends FoodItem implements Discountable {
    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + 50;
    }

    @Override
    public double applyDiscount(double total) {
        return total - (total * 0.05);
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount applied on Non-Veg Item.";
    }
}

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {
        VegItem veg = new VegItem("Paneer Tikka", 200, 2);
        NonVegItem nonVeg = new NonVegItem("Chicken Biryani", 300, 1);

        System.out.println("=== Veg Item ===");
        veg.getItemDetails();
        double vegTotal = veg.calculateTotalPrice();
        System.out.println("Total Price: " + vegTotal);
        double vegDiscounted = veg.applyDiscount(vegTotal);
        System.out.println("After Discount: " + vegDiscounted);
        System.out.println(veg.getDiscountDetails());

        System.out.println("-------------------------");

        System.out.println("=== Non-Veg Item ===");
        nonVeg.getItemDetails();
        double nonVegTotal = nonVeg.calculateTotalPrice();
        System.out.println("Total Price: " + nonVegTotal);
        double nonVegDiscounted = nonVeg.applyDiscount(nonVegTotal);
        System.out.println("After Discount: " + nonVegDiscounted);
        System.out.println(nonVeg.getDiscountDetails());
    }
}
