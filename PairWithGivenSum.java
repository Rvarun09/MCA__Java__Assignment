import java.util.*;

public class PairWithGivenSum {

    public static boolean hasPairWithSum(int[] arr, int target) {
        Set<Integer> seen = new HashSet<>();

        for (int num : arr) {
            int complement = target - num;

            // If complement already seen, we found a pair
            if (seen.contains(complement)) {
                return true;
            }

            seen.add(num);
        }

        return false;
    }

    public static void main(String[] args) {
        int[] arr = {8, 7, 2, 5, 3, 1};
        int target = 10;

        boolean result = hasPairWithSum(arr, target);
        System.out.println("Pair exists? " + result);
    }
}
