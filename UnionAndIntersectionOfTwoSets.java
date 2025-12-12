/*Union and Intersection of Two Sets
Given two sets, compute their union and intersection.
Example:
Set1: {1, 2, 3}, Set2: {3, 4, 5} → Union: {1, 2, 3, 4, 5}, Intersection: {3}. */

import java.util.HashSet;
import java.util.Set;

public class UnionAndIntersectionOfTwoSets {
    public static void main(String[] args) {
        Set<Integer> set1=new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        Set<Integer> set2=new HashSet<>();
        set2.add(3);
        set2.add(4);
        set2.add(5);
        Set<Integer> union=new HashSet<>(set1);
        for(Integer num:set2){
            union.add(num);
        }
        Set<Integer> intersection=new HashSet<>();
        for(Integer num:set1){
            if(set2.contains(num)){
                intersection.add(num);
            }
        }
        System.out.println("Union: "+union);
        System.out.println("Intersection: "+intersection);
        
    }
}
