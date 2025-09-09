import java.util.Scanner;

public class AreaOfCircle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking radius input
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();

        // Formula: Area = π * r^2
        double area = Math.PI * radius * radius;

        // Printing result
        System.out.println("Area of the circle: " + area);

        sc.close();
    }
}
