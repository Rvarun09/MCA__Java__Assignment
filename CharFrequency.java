import java.util.Scanner;

public class CharFrequency {

    public static String[][] findCharFrequency(String text) {
        int[] freq = new int[256];
        int len = 0;

        try {
            while (true) {
                text.charAt(len);
                len++;
            }
        } catch (StringIndexOutOfBoundsException e) {
        }

        for (int i = 0; i < len; i++) {
            freq[text.charAt(i)]++;
        }

        int uniqueCount = 0;
        for (int i = 0; i < len; i++) {
            if (freq[text.charAt(i)] != 0) {
                uniqueCount++;
                freq[text.charAt(i)] = -freq[text.charAt(i)];
            }
        }

        String[][] result = new String[uniqueCount][2];
        int index = 0;
        for (int i = 0; i < len; i++) {
            char c = text.charAt(i);
            if (freq[c] < 0) {
                result[index][0] = String.valueOf(c);
                result[index][1] = String.valueOf(-freq[c]);
                index++;
                freq[c] = 0; // mark as added
            }
        }

        return result;
    }

    public static void displayFrequency(String[][] data) {
        System.out.println("Character\tFrequency");
        System.out.println("-------------------------");
        for (int i = 0; i < data.length; i++) {
            System.out.println(data[i][0] + "\t\t" + data[i][1]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String text = sc.nextLine();

        String[][] frequencyData = findCharFrequency(text);

        displayFrequency(frequencyData);

        sc.close();
    }
}
