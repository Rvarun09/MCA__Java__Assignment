public class Item {
    int itemCode;
    String itemName;
    double price;
    public Item(int itemCode, String itemName, double price) {
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.price = price;
    }
    public void displayDetails() {
        System.out.println("Item Code: " + itemCode);
        System.out.println("Item Name: " + itemName);
        System.out.println("Price per Unit: $" + price);
    }
    public double calculateTotalCost(int quantity) {
        return price * quantity;
    }
    public static void main(String[] args) {
        Item item = new Item(101, "USB Flash Drive", 15.99);
        item.displayDetails();
        int quantity = 3;
        double totalCost = item.calculateTotalCost(quantity);
        System.out.println("Quantity: " + quantity);
        System.out.println("Total Cost: $" + totalCost);
    }
}
