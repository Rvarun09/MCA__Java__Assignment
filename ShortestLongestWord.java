import java.util.Scanner;

public class ShortestLongestWord {

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

    public static String[] customSplit(String text) {
        int len = customLength(text);
        int spaceCount = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaceCount++;
            }
        }

        int[] spaces = new int[spaceCount + 2];
        spaces[0] = -1;
        int index = 1;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                spaces[index++] = i;
            }
        }
        spaces[index] = len;

        String[] words = new String[spaceCount + 1];
        for (int i = 0; i < words.length; i++) {
            String word = "";
            for (int j = spaces[i] + 1; j < spaces[i + 1]; j++) {
                word += text.charAt(j);
            }
            words[i] = word;
        }
        return words;
    }

    public static String[][] wordsWithLengths(String[] words) {
        String[][] result = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            result[i][0] = words[i];
            result[i][1] = String.valueOf(customLength(words[i]));
        }
        return result;
    }

    public static int[] findShortestAndLongest(String[][] wordTable) {
        int minIndex = 0, maxIndex = 0;
        int minLen = Integer.parseInt(wordTable[0][1]);
        int maxLen = minLen;

        for (int i = 1; i < wordTable.length; i++) {
            int length = Integer.parseInt(wordTable[i][1]);
            if (length < minLen) {
                minLen = length;
                minIndex = i;
            }
            if (length > maxLen) {
                maxLen = length;
                maxIndex = i;
            }
        }

        return new int[]{minIndex, maxIndex};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a sentence: ");
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] wordTable = wordsWithLengths(words);

        System.out.println("\nWord\tLength");
        System.out.println("----------------");
        for (int i = 0; i < wordTable.length; i++) {
            System.out.println(wordTable[i][0] + "\t" + Integer.parseInt(wordTable[i][1]));
        }

        int[] result = findShortestAndLongest(wordTable);

        System.out.println("\nShortest Word: " + wordTable[result[0]][0] + " (Length: " + wordTable[result[0]][1] + ")");
        System.out.println("Longest Word: " + wordTable[result[1]][0] + " (Length: " + wordTable[result[1]][1] + ")");

        sc.close();
    }
}
