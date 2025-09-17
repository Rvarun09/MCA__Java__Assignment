import java.util.Scanner;

public class SumNaturalNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n <= 0) {
            System.exit(0);
        }
        int sumRec = sumRecursive(n);
        int sumFormula = sumFormula(n);
        System.out.println("Sum using recursion: " + sumRec);
        System.out.println("Sum using formula: " + sumFormula);
        System.out.println(sumRec == sumFormula ? "Results are equal" : "Results differ");
        sc.close();
    }

    static int sumRecursive(int n) {
        if (n == 1) return 1;
        return n + sumRecursive(n - 1);
    }

    static int sumFormula(int n) {
        return n * (n + 1) / 2;
    }
}
