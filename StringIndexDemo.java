import java.util.Scanner;

public class StringIndexDemo {

    public static void generateException(String text) {
        System.out.println("Character at index " + text.length() + ": " + text.charAt(text.length()));
    }

    public static void handleException(String text) {
        try {
            System.out.println("Character at index " + text.length() + ": " + text.charAt(text.length()));
        } catch (StringIndexOutOfBoundsException e) {
            System.out.println("StringIndexOutOfBoundsException handled: " + e);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.next();

        System.out.println("\nGenerating Exception:");
        try {
            generateException(input);
        } catch (Exception e) {
            System.out.println("Exception occurred: " + e);
        }

        System.out.println("\nHandling Exception:");
        handleException(input);

        sc.close();
    }
}
