import java.util.Scanner;

public class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int number = sc.nextInt();

        int temp = number;
        int count = 0;
        while (temp != 0) {
            temp /= 10;
            count++;
        }

        int[] digits = new int[count];
        temp = number;
        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        int[] reversed = new int[count];
        for (int i = 0; i < count; i++) {
            reversed[i] = digits[count - 1 - i];
        }

        System.out.println("\nDigits in original order:");
        for (int i = count - 1; i >= 0; i--) {
            System.out.print(digits[i] + " ");
        }

        System.out.println("\nDigits in reverse order:");
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i] + " ");
        }

        System.out.print("\nReversed number: ");
        for (int i = 0; i < count; i++) {
            System.out.print(reversed[i]);
        }

        sc.close();
    }
}
