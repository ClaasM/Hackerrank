package problem_17;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int p = in.nextInt();
        outer:
        for (int a0 = 0; a0 < p; a0++) {
            long next = in.nextLong();
            if (next == 1) {
                System.out.println("Not prime");
            } else {
                for (long i = 2; i <= Math.sqrt(next); i++) {
                    if (next % i == 0) {
                        System.out.println("Not prime");
                        continue outer;
                    }
                }
                System.out.println("Prime");
            }
        }
    }
}
