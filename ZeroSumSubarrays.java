import java.util.*;

public class ZeroSumSubarrays {

    public static List<int[]> findZeroSumSubarrays(int[] arr) {
    
        Map<Integer, List<Integer>> map = new HashMap<>();

        List<int[]> result = new ArrayList<>();
        int sum = 0;

        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (map.containsKey(sum)) {
                for (int startIndex : map.get(sum)) {
                    
                    result.add(new int[]{startIndex + 1, i});
                }
            }

            map.computeIfAbsent(sum, k -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, -6, 3, -1, 4, -4, 2, -2};

        List<int[]> zeroSumSubarrays = findZeroSumSubarrays(arr);

        System.out.println("Zero-sum subarrays:");
        for (int[] range : zeroSumSubarrays) {
            System.out.println("Start: " + range[0] + ", End: " + range[1]);
        }
    }
}
