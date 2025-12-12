/*Find Frequency of Elements
Given a list of strings, count the frequency of each element and return the results in a Map<String, Integer>.
Example:
Input: ["apple", "banana", "apple", "orange"] → Output: {apple=2, banana=1, orange=1}.
 */

import java.util.HashMap;
import java.util.Scanner;

public class FindFrequencyOfElements {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter Array Size:");
        int n=sc.nextInt();
        sc.nextLine();
        String arr[]=new String[n];
        System.out.println("Enter Fruit name:");
        for(int i=0;i<n;i++){
            arr[i]=sc.nextLine();
        }
        HashMap<String, Integer> map =new HashMap<>();
        for(String val:arr){
            if(!map.containsKey(val)){
                map.put(val,1);
            }else{
                map.put(val,map.get(val)+1);
            }
        }
        System.out.println(map);
    }
}
