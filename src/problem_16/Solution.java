package problem_16;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();

        HashMap<String, Integer> magazine = new HashMap<>();
        for (int magazine_i = 0; magazine_i < m; magazine_i++) {
            String next = in.next();
            magazine.put(next, magazine.getOrDefault(next, 0) + 1);
        }
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            String next = in.next();
            int count = magazine.getOrDefault(next, 0);
            if (count == 0) {
                System.out.println("No");
                return;
            }
            magazine.put(next, count - 1);
        }
        System.out.println("Yes");
    }
}

