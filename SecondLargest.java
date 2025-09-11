import java.util.Scanner;

public class SecondLargest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[10];
        System.out.println("Enter 10 numbers:");
        for (int i = 0; i < 10; i++) arr[i] = sc.nextInt();

        int first = Integer.MIN_VALUE, second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > first) {
                second = first;
                first = num;
            } else if (num > second && num != first) {
                second = num;
            }
        }
        System.out.println("Second Largest = " + second);
        sc.close();
    }
}
