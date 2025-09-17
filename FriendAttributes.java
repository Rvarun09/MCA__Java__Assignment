import java.util.Scanner;

public class FriendAttributes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] ages = new int[3];
        double[] heights = new double[3];
        for (int i = 0; i < 3; i++) {
            ages[i] = sc.nextInt();
            heights[i] = sc.nextDouble();
        }
        System.out.println("Youngest friend: " + getYoungest(ages));
        System.out.println("Tallest friend: " + getTallest(heights));
        sc.close();
    }

    static String getYoungest(int[] ages) {
        int minIndex = 0;
        for (int i = 1; i < ages.length; i++) {
            if (ages[i] < ages[minIndex]) minIndex = i;
        }
        return getFriendName(minIndex);
    }

    static String getTallest(double[] heights) {
        int maxIndex = 0;
        for (int i = 1; i < heights.length; i++) {
            if (heights[i] > heights[maxIndex]) maxIndex = i;
        }
        return getFriendName(maxIndex);
    }

    static String getFriendName(int index) {
        switch(index) {
            case 0: return "Amar";
            case 1: return "Akbar";
            case 2: return "Anthony";
            default: return "Unknown";
        }
    }
}

