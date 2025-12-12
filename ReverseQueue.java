/*Reverse a Queue
Reverse the elements of a queue using only queue operations (e.g., add, remove, isEmpty).
Example:
Input: [10, 20, 30] → Output: [30, 20, 10]. */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> qe){
        if(qe.isEmpty()){
            return;
        }
        int front=qe.remove();
        reverseQueue(qe);
        qe.add(front);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Queue<Integer> qe=new LinkedList<>();
        System.out.println("Enter number of elements in queue:");
        int n=sc.nextInt();
        System.out.println("Enter elements of queue:");
        for(int i=0;i<n;i++){
            qe.add(sc.nextInt());
        }
        reverseQueue(qe);
        System.out.println("Reverse Queue: "+qe);
    }
}
