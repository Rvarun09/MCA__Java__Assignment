import java.util.Comparator;

public class InventoryManagementSystem {

    static class Item {
        String name;
        int id;
        int quantity;
        double price;
        Item next;

        public Item(String name, int id, int quantity, double price) {
            this.name = name;
            this.id = id;
            this.quantity = quantity;
            this.price = price;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.format("[ID: %d, Name: %s, Qty: %d, Price: $%.2f]",
                id, name, quantity, price);
        }
    }

    static class InventoryList {
        Item head;

        public InventoryList() {
            this.head = null;
        }

        public boolean isEmpty() {
            return head == null;
        }

        public void addFirst(Item newItem) {
            newItem.next = head;
            head = newItem;
            System.out.println("Added first: " + newItem.name);
        }

        public void addLast(Item newItem) {
            if (isEmpty()) {
                head = newItem;
                System.out.println("Added last: " + newItem.name);
                return;
            }
            Item current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newItem;
            System.out.println("Added last: " + newItem.name);
        }

        public void addAtPosition(Item newItem, int position) {
            if (position <= 0) {
                System.out.println("Position must be positive.");
                return;
            }
            if (position == 1) {
                addFirst(newItem);
                return;
            }
            
            Item current = head;
            int count = 1;

            while (current != null && count < position - 1) {
                current = current.next;
                count++;
            }

            if (current == null) {
                System.out.println("Position " + position + " is beyond the list size.");
            } else {
                newItem.next = current.next;
                current.next = newItem;
                System.out.println("Added at position " + position + ": " + newItem.name);
            }
        }


        public void removeById(int id) {
            if (isEmpty()) {
                System.out.println("List is empty. Cannot remove.");
                return;
            }

            if (head.id == id) {
                System.out.println("Removed item: " + head.name);
                head = head.next;
                return;
            }

            Item current = head;
            while (current.next != null && current.next.id != id) {
                current = current.next;
            }

            if (current.next == null) {
                System.out.println("Item with ID " + id + " not found.");
            } else {
                System.out.println("Removed item: " + current.next.name);
                current.next = current.next.next;
            }
        }

        // --- 3. UPDATE Quantity ---

        public void updateQuantity(int id, int newQuantity) {
            Item current = head;
            while (current != null) {
                if (current.id == id) {
                    System.out.println("Updated quantity for " + current.name + ": " + current.quantity + " -> " + newQuantity);
                    current.quantity = newQuantity;
                    return;
                }
                current = current.next;
            }
            System.out.println("Item with ID " + id + " not found. Quantity not updated.");
        }


        public void search(int id, String name) {
            Item current = head;
            boolean found = false;
            
            System.out.println("\nSearch Results:");

            while (current != null) {
                boolean matchesId = id != -1 && current.id == id;
                boolean matchesName = name != null && current.name.equalsIgnoreCase(name);

                if (matchesId || matchesName) {
                    System.out.println("Found: " + current);
                    found = true;
                }
                current = current.next;
            }
            
            if (!found) {
                System.out.println("No item found matching the criteria.");
            }
        }
        

        public double calculateTotalValue() {
            double totalValue = 0.0;
            Item current = head;
            while (current != null) {
                totalValue += (double)current.quantity * current.price;
                current = current.next;
            }
            return totalValue;
        }

        // --- 6. SORT Functionality (Implemented using Merge Sort) ---

        public void sort(String field, boolean ascending) {
            head = mergeSort(head, field, ascending);
            System.out.println("\nInventory sorted by " + field + (ascending ? " (Ascending)." : " (Descending)."));
        }

        private Item mergeSort(Item h, String field, boolean ascending) {
            if (h == null || h.next == null) {
                return h;
            }

            Item middle = getMiddle(h);
            Item nextOfMiddle = middle.next;
            middle.next = null; 

            Item left = mergeSort(h, field, ascending);
            Item right = mergeSort(nextOfMiddle, field, ascending);

            return sortedMerge(left, right, field, ascending);
        }

        private Item getMiddle(Item h) {
            if (h == null) return h;
            Item slow = h;
            Item fast = h.next;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        private Item sortedMerge(Item a, Item b, String field, boolean ascending) {
            Item result = null;

            if (a == null) return b;
            if (b == null) return a;

            Comparator<Item> comparator = createComparator(field, ascending);

            if (comparator.compare(a, b) <= 0) {
                result = a;
                result.next = sortedMerge(a.next, b, field, ascending);
            } else {
                result = b;
                result.next = sortedMerge(a, b.next, field, ascending);
            }
            return result;
        }

        private Comparator<Item> createComparator(String field, boolean ascending) {
            Comparator<Item> baseComparator;
            
            switch (field.toLowerCase()) {
                case "name":
                    baseComparator = Comparator.comparing(item -> item.name.toLowerCase());
                    break;
                case "price":
                    baseComparator = Comparator.comparingDouble(item -> item.price);
                    break;
                case "quantity":
                    baseComparator = Comparator.comparingInt(item -> item.quantity);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid sort field: " + field);
            }
            
            return ascending ? baseComparator : baseComparator.reversed();
        }

        // --- DISPLAY Functionality ---

        public void displayAll() {
            if (isEmpty()) {
                System.out.println("\nInventory is empty.");
                return;
            }
            System.out.println("\n--- Current Inventory ---");
            Item current = head;
            while (current != null) {
                System.out.println(current);
                current = current.next;
            }
        }
    }


    public static void main(String[] args) {
        InventoryList inventory = new InventoryList();

        System.out.println("--- ADD OPERATIONS ---");
        inventory.addLast(new Item("Laptop", 101, 5, 1200.00));
        inventory.addFirst(new Item("Monitor", 100, 10, 300.50));
        inventory.addAtPosition(new Item("Keyboard", 102, 25, 75.99), 3);
        inventory.addLast(new Item("Mouse", 103, 50, 25.00));
        
        inventory.displayAll();

        System.out.println("\n--- UPDATE OPERATION ---");
        inventory.updateQuantity(101, 8); 

        System.out.println("\n--- REMOVE OPERATION ---");
        inventory.removeById(103);
        inventory.displayAll();

        System.out.println("\n--- SEARCH OPERATIONS ---");
        inventory.search(100, null); 
        inventory.search(-1, "laptop");
        
        System.out.println("\n--- VALUE CALCULATION ---");
        System.out.printf("Total Inventory Value: $%.2f%n", inventory.calculateTotalValue());


        System.out.println("\n--- SORT OPERATIONS (by Name Ascending) ---");
        inventory.sort("Name", true);
        inventory.displayAll();

        System.out.println("\n--- SORT OPERATIONS (by Price Descending) ---");
        inventory.sort("Price", false);
        inventory.displayAll();
    }
}