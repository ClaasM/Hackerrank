package problem_15;

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
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        boolean swapped = true;
        int swapCount = 0;
        while (swapped) {
            swapped = false;
            for (int i = 0; i < a.length - 1; i++) {
                if (a[i] > a[i + 1]) {
                    int temp = a[i + 1];
                    a[i + 1] = a[i];
                    a[i] = temp;
                    swapped = true;
                    swapCount++;
                }
            }
        }

        System.out.println("Array is sorted in " + swapCount + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[a.length - 1]);


        //
        //
        //"Last Element: lastElement"
    }
}
