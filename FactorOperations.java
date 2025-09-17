import java.util.Scanner;

public class FactorOperations{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] factors = findFactors(num);
        for (int f : factors) {
            System.out.print(f + " ");
        }
        System.out.println();
        System.out.println(sumFactors(factors));
        System.out.println(sumSquareFactors(factors));
        System.out.println(productFactors(factors));
        sc.close();
    }

    static int[] findFactors(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) count++;
        }
        int[] arr = new int[count];
        int index = 0;
        for (int i = 1; i <= n; i++) {
            if (n % i == 0) arr[index++] = i;
        }
        return arr;
    }

    static int sumFactors(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += i;
        return sum;
    }

    static int productFactors(int[] arr) {
        int product = 1;
        for (int i : arr) product *= i;
        return product;
    }

    static int sumSquareFactors(int[] arr) {
        int sum = 0;
        for (int i : arr) sum += Math.pow(i, 2);
        return sum;
    }
}
