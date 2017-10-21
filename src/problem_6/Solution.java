package problem_6;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PriorityQueue<Integer> descendingLeft = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));
        PriorityQueue<Integer> ascendingRight = new PriorityQueue<>((o1, o2) -> Integer.compare(o1, o2));
        int n = in.nextInt();

        for (int i = 0; i < n; i++) {
            int next = in.nextInt();

            if (descendingLeft.isEmpty() || next <= descendingLeft.peek()) {
                descendingLeft.add(next);
                // Make sure it is balanced, whereas the descending, left one is allowed to be one bigger
                if (descendingLeft.size() > ascendingRight.size() + 1) {
                    ascendingRight.add(descendingLeft.poll());
                }

            } else {
                ascendingRight.add(next);
                if (descendingLeft.size() < ascendingRight.size()) {
                    descendingLeft.add(ascendingRight.poll());
                }
            }


            // Print the current median
            if (ascendingRight.size() == descendingLeft.size()) {
                System.out.println((float) (ascendingRight.peek() + descendingLeft.peek()) / 2.0);
            } else {
                System.out.println((float) descendingLeft.peek());
            }

        }
    }
}
