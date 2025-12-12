/*Invert a Map
Invert a Map<K, V> to produce a Map<V, K>. Handle duplicate values by storing them in a list.
Example:
Input: {A=1, B=2, C=1} → Output: {1=[A, C], 2=[B]}. */
import java.util.*;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 1);
        map.put("B", 2);
        map.put("C", 1);
        Map<Integer, List<String>> inverted = new HashMap<>();

        for (String key : map.keySet()) {
            int value = map.get(key);
            List<String> list;
            if (inverted.containsKey(value)) {
                list = inverted.get(value);
            } else {
                list = new ArrayList<>();
            }
            list.add(key);
            inverted.put(value, list);
        }
        System.out.println(inverted);
    }
}
