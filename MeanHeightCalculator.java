import java.util.Scanner;

public class MeanHeightCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] heights = new double[11]; 
        double sum = 0.0;

        for (int i = 0; i < heights.length; i++) {
            System.out.print("Enter height of player " + (i + 1) + " (in cm): ");
            heights[i] = scanner.nextDouble();
            sum += heights[i]; 
        }

        double mean = sum / heights.length;

        System.out.printf("\nThe mean height of the football team is: %.2f cm\n", mean);

        scanner.close();
    }
}
