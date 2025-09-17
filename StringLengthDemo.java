import java.util.Scanner;

public class StringLengthDemo {

    public static int customLength(String text) {
        int count = 0;
        try {
            while (true) {
                text.charAt(count);
                count++;
            }
        } catch (StringIndexOutOfBoundsException e) {
            return count;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        int customLen = customLength(text);
        int builtInLen = text.length();

        System.out.println("\nLength using custom method: " + customLen);
        System.out.println("Length using built-in method: " + builtInLen);

        sc.close();
    }
}
