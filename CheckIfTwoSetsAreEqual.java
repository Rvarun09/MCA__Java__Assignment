/*Check if Two Sets Are Equal
Compare two sets and determine if they contain the same elements, regardless of order.
Example:
Set1: {1, 2, 3}, Set2: {3, 2, 1} → Output: true. */

import java.util.HashSet;

public class CheckIfTwoSetsAreEqual {
    public static void main(String[] args) {
        HashSet<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        HashSet<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
        boolean areEqual = set1.equals(set2);
        System.out.println("Are the two sets equal:" + areEqual);
    }
}
