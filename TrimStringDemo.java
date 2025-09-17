import java.util.Scanner;

public class TrimStringDemo {

    public static int[] findTrimIndices(String text) {
        int start = 0, end = 0;
        int len = 0;
        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }

        for (start = 0; start < len; start++) {
            if (text.charAt(start) != ' ') {
                break;
            }
        }

        for (end = len - 1; end >= start; end--) {
            if (text.charAt(end) != ' ') {
                break;
            }
        }

        return new int[]{start, end};
    }

    public static String customSubstring(String text, int start, int end) {
        String result = "";
        for (int i = start; i <= end; i++) {
            result += text.charAt(i);
        }
        return result;
    }

    public static boolean compareStrings(String s1, String s2) {
        int len1 = 0, len2 = 0;
        try {
            while (true) {
                s1.charAt(len1);
                len1++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        try {
            while (true) {
                s2.charAt(len2);
                len2++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }
        if (len1 != len2) return false;
        for (int i = 0; i < len1; i++) {
            if (s1.charAt(i) != s2.charAt(i)) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string with spaces: ");
        String text = sc.nextLine();

        int[] indices = findTrimIndices(text);
        String customTrimmed = customSubstring(text, indices[0], indices[1]);
        String builtInTrimmed = text.trim();

        System.out.println("\nCustom Trimmed: \"" + customTrimmed + "\"");
        System.out.println("Built-in Trimmed: \"" + builtInTrimmed + "\"");

        boolean comparison = compareStrings(customTrimmed, builtInTrimmed);
        System.out.println("Comparison result: " + comparison);

        sc.close();
    }
}
