/*Find the Key with the Highest Value
Given a Map<String, Integer>, find the key with the maximum value.
Example:
Input: {A=10, B=20, C=15} → Output: B. */

import java.util.HashMap;
import java.util.Map;

public class FindKeyWithHighestValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 15);
        int max=Integer.MIN_VALUE;
        String r="";
        for(String val:map.keySet()){
            if(map.get(val)>max){
                r=val;
                max=map.get(val);
            }
        }
        System.out.println("Key with the highest value: " + r);
    }
}
