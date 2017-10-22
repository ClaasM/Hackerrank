package problem_10;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int a[] = new int[n];
        HashSet<Integer> set = new HashSet<>();
        for (int a_i = 0; a_i < n; a_i++) {
            int next = in.nextInt();
            if (!set.contains(next))
                set.add(next);
            else
                set.remove(next);
        }
        System.out.println(set.iterator().next());
    }
}
