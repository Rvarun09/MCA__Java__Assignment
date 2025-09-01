public class StaticFinalExample {

    public static final double PI = 3.14159;

    public static void main(String[] args) {

        double radius = 5.0;
        double area = PI * radius * radius;
        System.out.println("The area of a circle with radius " + radius + " is: " + area);

        StaticFinalExample example = new StaticFinalExample();
        double circumference = example.PI * 2 * radius;
        System.out.println("The circumference of a circle with radius " + radius + " is: " + circumference);
        System.out.println("(Note: It is best practice to access a static variable with the class name.)");

        System.out.println("\nAttempting to change the value of PI...");
        try {
        
        } catch (Exception e) {
            System.out.println("Error: A static final variable cannot be reassigned.");
        }
    }    
}
