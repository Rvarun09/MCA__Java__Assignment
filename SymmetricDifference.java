/*Symmetric Difference
Find the symmetric difference (elements present in either set but not in both) of two sets.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Output: {1, 2, 4, 5}. */

import java.util.HashSet;

public class SymmetricDifference {
    public static void main(String[] args) {
        HashSet<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        HashSet<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        HashSet<Integer> ans=new HashSet<>(set1);
        for(Integer num:set2){
            if(ans.contains(num)){
                ans.remove(num);
            }else{
                ans.add(num);
            }
        }
        System.out.println("Symmetric Difference: "+ans);
    }
}
