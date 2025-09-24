public class Vehicle1 {
    String model;
    int maxSpeed;
    Vehicle1(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }
    void showDetails() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}
interface Refuelable {
    void refuel(); 
}
class ElectricVehicle extends Vehicle1 {
    int batteryCapacity; 
    ElectricVehicle(String model, int maxSpeed, int batteryCapacity) {
        super(model, maxSpeed);
        this.batteryCapacity = batteryCapacity;
    }
    void charge() {
        System.out.println(model + " is charging with " + batteryCapacity + " kWh capacity.");
    }
    @Override
    void showDetails() {
        super.showDetails();
        System.out.println("Battery Capacity: " + batteryCapacity + " kWh");
    }
}
class PetrolVehicle extends Vehicle1 implements Refuelable {
    double fuelTankCapacity; 
    PetrolVehicle(String model, int maxSpeed, double fuelTankCapacity) {
        super(model, maxSpeed);
        this.fuelTankCapacity = fuelTankCapacity;
    }
    @Override
    public void refuel() {
        System.out.println(model + " is refueling with " + fuelTankCapacity + " liters capacity.");
    }
    @Override
    void showDetails() {
        super.showDetails();
        System.out.println("Fuel Tank Capacity: " + fuelTankCapacity + " liters");
    }
}
class VehicleSystemDemo {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model S", 250, 100);
        PetrolVehicle pv = new PetrolVehicle("Toyota Corolla", 180, 50);

        System.out.println("---- Electric Vehicle ----");
        ev.showDetails();
        ev.charge();

        System.out.println("\n---- Petrol Vehicle ----");
        pv.showDetails();
        pv.refuel();
    }
}
