public class CarRental {
    String customerName;
    String carModel;
    int rentalDays;
    double dailyRate;

    CarRental() {
        customerName = "Unknown";
        carModel = "Standard";
        rentalDays = 1;
        dailyRate = 1000;
    }

    CarRental(String c, String m, int d, double rate) {
        customerName = c;
        carModel = m;
        rentalDays = d;
        dailyRate = rate;
    }

    double calculateTotalCost() {
        return rentalDays * dailyRate;
    }

    void display() {
        System.out.println("Customer: " + customerName);
        System.out.println("Car Model: " + carModel);
        System.out.println("Rental Days: " + rentalDays);
        System.out.println("Total Cost: " + calculateTotalCost());
        System.out.println();
    }

    public static void main(String[] args) {
        CarRental r1 = new CarRental();
        CarRental r2 = new CarRental("Alice", "Sedan", 5, 1500);

        r1.display();
        r2.display();
    }
}
