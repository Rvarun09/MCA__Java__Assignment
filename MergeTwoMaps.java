/*Merge Two Maps
Merge two maps such that if a key exists in both, sum their values.
Example:
Map1: {A=1, B=2}, Map2: {B=3, C=4} → Output: {A=1, B=5, C=4}. */

import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String, Integer> map1 = new HashMap<>();
        map1.put("A", 1);
        map1.put("B", 2);

        Map<String, Integer> map2 = new HashMap<>();
        map2.put("B", 3);
        map2.put("C", 4);

        Map<String, Integer> mergedMap = new HashMap<>(map1);
        for(String val:map2.keySet()){
            if(mergedMap.containsKey(val)){
                mergedMap.put(val, mergedMap.get(val)+map2.get(val));
            } else {
                mergedMap.put(val, map2.get(val));
            }
        }
        System.out.println("Merged Map: " + mergedMap);
    }
}
