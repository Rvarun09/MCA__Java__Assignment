public class Vehicle {
    private static double registrationFee = 500.0;

    private final String registrationNumber;
    private String ownerName;
    private String vehicleType;

    public Vehicle(String ownerName, String vehicleType, String registrationNumber) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
        this.registrationNumber = registrationNumber;
    }

    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    public void displayRegistrationDetails() {
        if (this instanceof Vehicle) {
            System.out.println("Owner Name: " + ownerName);
            System.out.println("Vehicle Type: " + vehicleType);
            System.out.println("Registration Number: " + registrationNumber);
            System.out.println("Registration Fee: " + registrationFee);
        } else {
            System.out.println("Not a valid Vehicle object.");
        }
    }

    public static void main(String[] args) {
        Vehicle.updateRegistrationFee(750.0);
        Vehicle v1 = new Vehicle("Alice", "Car", "MH12AB1234");
        Vehicle v2 = new Vehicle("Bob", "Bike", "MH14XY5678");

        v1.displayRegistrationDetails();
        System.out.println();
        v2.displayRegistrationDetails();
    }
}