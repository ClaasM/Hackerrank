package problem_20;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for (int a0 = 0; a0 < s; a0++) {
            int n = in.nextInt();
            int[] waysToGo = new int[n];
            if (waysToGo.length > 0) waysToGo[0] = 1;
            if (waysToGo.length > 1) waysToGo[1] = 2;
            if (waysToGo.length > 2) waysToGo[2] = 4;
            for (int i = 3; i < n; i++) {
                waysToGo[i] = waysToGo[i - 1] + waysToGo[i - 2] + waysToGo[i - 3];
            }
            System.out.println(waysToGo[waysToGo.length - 1]);
        }
    }
}
