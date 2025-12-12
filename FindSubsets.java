/*Find Subsets
Check if one set is a subset of another.
Example:
Set1: {2, 3}, Set2: {1, 2, 3, 4} → Output: true. */

import java.util.HashSet;

public class FindSubsets {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(2);
        set1.add(4);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(1);
        set2.add(2);
        set2.add(3);
        set2.add(4);
        boolean isSubset = true;
        for (int element : set1) {
            if (!set2.contains(element)) {
                isSubset = false;
                break;
            }
        }
        System.out.println("Set1 is a subset of Set2: " + isSubset);
    }
}
