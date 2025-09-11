import java.util.Scanner;

public class Factorial {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), fact = 1, i = 1;
        do {
            fact *= i;
            i++;
        } while (i <= n);
        System.out.println("Factorial = " + fact);
        sc.close();
    }
}
