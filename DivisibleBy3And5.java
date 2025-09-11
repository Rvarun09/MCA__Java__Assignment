import java.util.Scanner;

public class DivisibleBy3And5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String result = (n % 3 == 0 && n % 5 == 0) ? "Divisible" : "Not Divisible";
        System.out.println(result);
        sc.close();
    }
}
