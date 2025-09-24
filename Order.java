public class Order {
    String orderId;
    String orderDate;
    Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }
    String getOrderStatus() {
        return "Order placed";
    }
    void displayOrderInfo() {
        System.out.println("Order ID: " + orderId);
        System.out.println("Order Date: " + orderDate);
        System.out.println("Status: " + getOrderStatus());
    }
}
class ShippedOrder extends Order {
    String trackingNumber;
    ShippedOrder(String orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }
    @Override
    String getOrderStatus() {
        return "Order shipped";
    }
    @Override
    void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Tracking Number: " + trackingNumber);
    }
}
class DeliveredOrder extends ShippedOrder {
    String deliveryDate;
    DeliveredOrder(String orderId, String orderDate, String trackingNumber, String deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }
    @Override
    String getOrderStatus() {
        return "Order delivered";
    }
    @Override
    void displayOrderInfo() {
        super.displayOrderInfo();
        System.out.println("Delivery Date: " + deliveryDate);
    }
}
class Parcel {
    public static void main(String[] args) {
        Order order = new Order("O123", "2025/9/24");
        ShippedOrder shippedOrder = new ShippedOrder("O124", "2025/9/20", "TRK123456");
        DeliveredOrder deliveredOrder = new DeliveredOrder("O125", "2025/9/15", "TRK654321", "2025/9/22");
        System.out.println("Basic Order Info:");
        order.displayOrderInfo();
        System.out.println("\nShipped Order Info:");
        shippedOrder.displayOrderInfo();
        System.out.println("\nDelivered Order Info:");
        deliveredOrder.displayOrderInfo();
    }
}

