import java.util.Scanner;

public class TriangleRun {

    public static double calculateRounds(double side1, double side2, double side3) {
        double perimeter = side1 + side2 + side3;
        double totalDistance = 5000.0; 
        return totalDistance / perimeter;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter the length of side 1 (in meters): ");
            double side1 = scanner.nextDouble();

            System.out.print("Enter the length of side 2 (in meters): ");
            double side2 = scanner.nextDouble();

            System.out.print("Enter the length of side 3 (in meters): ");
            double side3 = scanner.nextDouble();

            if (side1 <= 0 || side2 <= 0 || side3 <= 0 ||
                (side1 + side2 <= side3) ||
                (side2 + side3 <= side1) ||
                (side1 + side3 <= side2)) {
                System.out.println("Invalid triangle sides. The given sides cannot form a triangle.");
                return;
            }

            double rounds = calculateRounds(side1, side2, side3);
            System.out.printf("The athlete needs to run approximately %.2f rounds to complete 5 km.%n", rounds);

        } catch (Exception e) {
            System.out.println("Invalid input. Please enter numeric values.");
        } finally {
            scanner.close();
        }
    }
}
