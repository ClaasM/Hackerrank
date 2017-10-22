package problem_12;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
                queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
                queue.dequeue();
            } else if (operation == 3) { // print/peek
                System.out.println(queue.peek());
            }
        }
        scan.close();
    }

    public static class MyQueue<T> {

        /*
        Two stacks are used.
        The dequeue contains the elements such that the first element is the oldest.
        When a new element is added, all elements from the dequeue are moved to the enqueue,
        the new element is added to the bottom of the dequeue,
        and all old elements are added back,
        such that the new element is now at the bottom of the dequeue.
         */
        Stack<T> enqueue;
        Stack<T> dequeue;

        public MyQueue() {
            enqueue = new Stack<>();
            dequeue = new Stack<>();
        }

        public void enqueue(T i) {
            enqueue.push(i);
        }

        public T dequeue() {
            if (dequeue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.push(enqueue.pop());
                }
            }
            T element = dequeue.pop();
            return element;
        }

        public T peek() {
            if (dequeue.isEmpty()) {
                while (!enqueue.isEmpty()) {
                    dequeue.push(enqueue.pop());
                }
            }
            return dequeue.peek();
        }
    }
}
