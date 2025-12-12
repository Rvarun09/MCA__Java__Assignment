/*Implement a Stack Using Queues
Implement a stack data structure using two queues and support push, pop, and top operations.
Example:
Push 1, 2, 3 → Pop → Output: 3. */

import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();
    public void push(int x) {
        while (!q1.isEmpty()) {
            q2.add(q1.remove());
        }
        q1.add(x);
        while (!q2.isEmpty()) {
            q1.add(q2.remove());
        }
    }
    public int pop() {
        if (q1.isEmpty()) return -1;
        return q1.remove();
    }
    public int top() {
        if (q1.isEmpty()) return -1;
        return q1.peek();
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }
}

public class StackUsingQueue {
    public static void main(String[] args) {
        MyStack st = new MyStack();
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("Popped: " + st.pop());
        System.out.println("Top: " + st.top());
    }
}

