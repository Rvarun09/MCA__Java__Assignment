/*Remove Duplicates While Preserving Order
Remove duplicate elements from a list while maintaining the original order of elements.
Example:
Input: [3, 1, 2, 2, 3, 4] → Output: [3, 1, 2, 4]. */


import java.util.ArrayList;
import java.util.Scanner;

public class RemoveDuplicatesWhilePreservingOrder {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the list:");
        int n=sc.nextInt();
        System.out.println("Enter the elements of the list:");
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        ArrayList<Integer> result=new ArrayList<>();
        for(int num:list){
            if(!result.contains(num)){
                result.add(num);
            }
        }
        System.out.println(result);
    }
}
