public class StaticVsInstance {

    public static int numberOfWheels = 4;

    public String color;

    public StaticVsInstance(String color) {
        this.color = color;
    }

    public void displayDetails() {
        System.out.println("Car Color: " + this.color + ", Number of Wheels: " + numberOfWheels);
    }

    public static void main(String[] args) {
        StaticVsInstance car1 = new StaticVsInstance("Red");
        System.out.println("Initial State of car1");
        car1.displayDetails();
        System.out.println();

        StaticVsInstance car2 = new StaticVsInstance("Blue");
        System.out.println("Initial State of car2 ");
        car2.displayDetails();
        System.out.println();
        
        System.out.println("Modifying 'car1's color");
        car1.color = "Green"; 
        System.out.println("After changing car1's color:");
        System.out.print("car1 details: ");
        car1.displayDetails();
        System.out.print("car2 details: ");
        car2.displayDetails(); 
        System.out.println();

        System.out.println(" Modifying 'numberOfWheels'");
        StaticVsInstance.numberOfWheels = 6;
        System.out.println("After changing numberOfWheels:");
        System.out.print("car1 details: ");
        car1.displayDetails(); 
        System.out.print("car2 details: ");
        car2.displayDetails();
        System.out.println();
    }
    
}
