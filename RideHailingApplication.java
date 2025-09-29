abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;
    private String currentLocation;

    public Vehicle(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
        this.currentLocation = currentLocation;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: " + ratePerKm);
        System.out.println("Current Location: " + currentLocation);
    }

    public abstract double calculateFare(double distance);
}

interface GPS {
    String getCurrentLocation();
    void updateLocation(String location);
}

class Car extends Vehicle implements GPS {
    public Car(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 50;
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

class Bike extends Vehicle implements GPS {
    public Bike(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

class Auto extends Vehicle implements GPS {
    public Auto(String vehicleId, String driverName, double ratePerKm, String currentLocation) {
        super(vehicleId, driverName, ratePerKm, currentLocation);
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm() + 20;
    }

    @Override
    public String getCurrentLocation() {
        return super.getCurrentLocation();
    }

    @Override
    public void updateLocation(String location) {
        setCurrentLocation(location);
    }
}

public class RideHailingApplication {
    public static void main(String[] args) {
        Car car = new Car("C101", "Alice", 15, "Downtown");
        Bike bike = new Bike("B202", "Bob", 8, "City Center");
        Auto auto = new Auto("A303", "Charlie", 10, "Station Road");

        System.out.println("=== Car Ride ===");
        car.getVehicleDetails();
        System.out.println("Fare: " + car.calculateFare(10));
        car.updateLocation("Airport");
        System.out.println("Updated Location: " + car.getCurrentLocation());

        System.out.println("-------------------------");

        System.out.println("=== Bike Ride ===");
        bike.getVehicleDetails();
        System.out.println("Fare: " + bike.calculateFare(10));
        bike.updateLocation("Mall");
        System.out.println("Updated Location: " + bike.getCurrentLocation());

        System.out.println("-------------------------");

        System.out.println("=== Auto Ride ===");
        auto.getVehicleDetails();
        System.out.println("Fare: " + auto.calculateFare(10));
        auto.updateLocation("Bus Stand");
        System.out.println("Updated Location: " + auto.getCurrentLocation());
    }
}
