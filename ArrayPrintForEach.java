import java.util.Scanner;

public class ArrayPrintForEach {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter 5 integers:");
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }

        System.out.println("The elements of the array are:");
        for (int num : numbers) {
            System.out.println(num);
        }

        sc.close();
    }
}
