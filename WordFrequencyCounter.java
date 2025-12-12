/*Word Frequency Counter
Read a text file and count the frequency of each word using a HashMap. Ignore case and punctuation.
Example:
Input: "Hello world, hello Java!" → Output: {hello=2, world=1, java=1} */

import java.util.HashMap;
import java.util.Scanner;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the text:");
        String text=sc.nextLine();
        text=text.toLowerCase();
        text=text.replaceAll("[^a-z]", " ");
        HashMap<String, Integer> map= new HashMap<>();
        String[] arr=text.split("\\s+");
        for(String val:arr){
            if(!map.containsKey(val)){
                map.put(val,1);
            } else {
                map.put(val,map.get(val)+1);
            }
        }
        System.out.println(map);
    }
}
