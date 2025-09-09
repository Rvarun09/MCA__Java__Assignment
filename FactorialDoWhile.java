import java.util.Scanner;

public class FactorialDoWhile {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a number: ");
        int num = sc.nextInt();

        int factorial = 1;
        int i = 1;

        do {
            factorial *= i;
            i++;
        } while (i <= num);

        System.out.println("Factorial of " + num + " = " + factorial);

        sc.close();
    }
}
