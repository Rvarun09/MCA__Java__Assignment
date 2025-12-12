/*Rotate Elements in a List
Rotate the elements of a list by a given number of positions.
Example:
Input: [10, 20, 30, 40, 50], rotate by 2 → Output: [30, 40, 50, 10, 20]. */

import java.util.ArrayList;
import java.util.Scanner;

public class RotateElementsList {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of elements in the list:");
        int n=sc.nextInt();
        ArrayList<Integer> list=new ArrayList<>();
        System.out.println("Enter the elements of the list:");
        for(int i=0;i<n;i++){
            list.add(sc.nextInt());
        }
        System.out.print("Enter how many time rotate the list by:");
        int k=sc.nextInt();
        k=k%n;
        ArrayList<Integer> rotatedList=new ArrayList<>();
        for(int i=(n-k)-1;i<n;i++){
            rotatedList.add(list.get(i));
        }
        for(int i=0;i<(n-k)-1;i++){
            rotatedList.add(list.get(i));
        }
        System.out.println("Rotated List: " + rotatedList);
    }
}
