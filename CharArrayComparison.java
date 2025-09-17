import java.util.Scanner;

public class CharArrayComparison {

    public static char[] customToCharArray(String text) {
        char[] result = new char[text.length()];
        for (int i = 0; i < text.length(); i++) {
            result[i] = text.charAt(i);
        }
        return result;
    }

    public static boolean compareArrays(char[] arr1, char[] arr2) {
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.next();

        char[] customArray = customToCharArray(text);
        char[] builtInArray = text.toCharArray();

        boolean comparison = compareArrays(customArray, builtInArray);

        System.out.println("\nCustom char array: ");
        for (char c : customArray) {
            System.out.print(c + " ");
        }

        System.out.println("\nBuilt-in char array: ");
        for (char c : builtInArray) {
            System.out.print(c + " ");
        }

        System.out.println("\nComparison result: " + comparison);

        sc.close();
    }
}
