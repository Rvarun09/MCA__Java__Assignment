import java.util.Scanner;

public class BMICalculator2D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int number = sc.nextInt();

        double[][] personData = new double[number][3];
        String[] weightStatus = new String[number];

        for (int i = 0; i < number; i++) {
            System.out.println("\nEnter details for Person " + (i + 1));
t
            double w;
            do {
                System.out.print("Enter weight (kg): ");
                w = sc.nextDouble();
                if (w <= 0) {
                    System.out.println("Weight must be positive. Try again.");
                }
            } while (w <= 0);

            // Height
            double h;
            do {
                System.out.print("Enter height (m): ");
                h = sc.nextDouble();
                if (h <= 0) {
                    System.out.println("Height must be positive. Try again.");
                }
            } while (h <= 0);

            personData[i][0] = h;
            personData[i][1] = w;
        }

        for (int i = 0; i < number; i++) {
            double h = personData[i][0];
            double w = personData[i][1];
            double bmi = w / (h * h);

            personData[i][2] = bmi;

            if (bmi < 18.5) {
                weightStatus[i] = "Underweight";
            } else if (bmi < 25) {
                weightStatus[i] = "Normal weight";
            } else if (bmi < 30) {
                weightStatus[i] = "Overweight";
            } else {
                weightStatus[i] = "Obese";
            }
        }

        System.out.println("\n--- BMI Report ---");
        System.out.printf("%-10s %-10s %-10s %-15s%n", "Height(m)", "Weight(kg)", "BMI", "Status");

        for (int i = 0; i < number; i++) {
            System.out.printf("%-10.2f %-10.2f %-10.2f %-15s%n",
                    personData[i][0], personData[i][1], personData[i][2], weightStatus[i]);
        }

        sc.close();
    }
}
