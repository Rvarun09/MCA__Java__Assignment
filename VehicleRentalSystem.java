abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }
    public abstract double calculateRentalCost(int days);
    public void displayDetails() {
        System.out.println("Vehicle Number: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate per Day: " + rentalRate);
    }
}

interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

class Car extends Vehicle implements Insurable {
    private String policyNumber; 

    public Car(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days; 
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.10; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + policyNumber;
    }
}

class Bike extends Vehicle implements Insurable {
    private String policyNumber;

    public Bike(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days * 0.8; 
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.05; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + policyNumber;
    }
}

class Truck extends Vehicle implements Insurable {
    private String policyNumber;

    public Truck(String vehicleNumber, double rentalRate, String policyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.policyNumber = policyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; 
    }

    @Override
    public double calculateInsurance() {
        return getRentalRate() * 0.15; 
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + policyNumber;
    }
}
public class VehicleRentalSystem {
    public static void main(String[] args) {
        int days = 5;
        Car car = new Car("CAR123", 2000, "CAR-POL-001");
        Bike bike = new Bike("BIKE456", 500, "BIKE-POL-002");
        Truck truck = new Truck("TRUCK789", 5000, "TRUCK-POL-003");

        car.displayDetails();
        System.out.println("Rental Cost for " + days + " days: " + car.calculateRentalCost(days));
        System.out.println("Insurance Cost: " + car.calculateInsurance());
        System.out.println(car.getInsuranceDetails());
        System.out.println("--------------------------");

        bike.displayDetails();
        System.out.println("Rental Cost for " + days + " days: " + bike.calculateRentalCost(days));
        System.out.println("Insurance Cost: " + bike.calculateInsurance());
        System.out.println(bike.getInsuranceDetails());
        System.out.println("--------------------------");

        truck.displayDetails();
        System.out.println("Rental Cost for " + days + " days: " + truck.calculateRentalCost(days));
        System.out.println("Insurance Cost: " + truck.calculateInsurance());
        System.out.println(truck.getInsuranceDetails());
        System.out.println("--------------------------");
    }
}
