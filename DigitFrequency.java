import java.util.Scanner;

public class DigitFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        long number = sc.nextLong();

        if (number < 0) {
            number = -number;
        }

        String numStr = Long.toString(number);
        int len = numStr.length();
        int[] digits = new int[len];

        for (int i = 0; i < len; i++) {
            digits[i] = numStr.charAt(i) - '0';
        }

        int[] frequency = new int[10];

        for (int d : digits) {
            frequency[d]++;
        }

        System.out.println("\n--- Digit Frequency ---");
        for (int i = 0; i < 10; i++) {
            if (frequency[i] > 0) {
                System.out.println("Digit " + i + " → " + frequency[i] + " times");
            }
        }

        sc.close();
    }
}
