class CartItem {
    String itemName;
    double price;
    int quantity;
    void setItem(String name, double price, int quantity) {
        this.itemName = name;
        this.price = price;
        this.quantity = quantity;
    }
    double getTotalPrice() {
        return price * quantity;
    }
    void displayItem() {
        System.out.println(quantity + " x " + itemName + " = $" + getTotalPrice());
    }
}

public class ShoppingCart {
    public static void main(String[] args) {
        CartItem item1 = new CartItem();
        CartItem item2 = new CartItem();
        item1.setItem("Apple", 1.00, 3);
        item2.setItem("Milk", 2.50, 1);
        item1.displayItem();
        item2.displayItem();
        double total = item1.getTotalPrice() + item2.getTotalPrice();
        System.out.println("Total Cost: $" + total);
    }
}
