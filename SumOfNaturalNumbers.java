import java.util.Scanner;

public class SumOfNaturalNumbers {

    public static int findSum(int n) {
        int sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += i;
        }

        return sum;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive integer: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Please enter a positive integer.");
        } else {
            int result = findSum(n);
            System.out.println("Sum of first " + n + " natural numbers is: " + result);
        }

        scanner.close();
    }
}
