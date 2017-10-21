package problem_2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {

    //The offset of the letter 'a' in ASCII
    static final int OFFSET = 97;
    //The number of different characters that the String can be made of
    static final int COUNT = 26;

    public static int numberNeeded(String first, String second) {
        char[] firstCharacters = first.toCharArray();
        char[] secondCharacters = second.toCharArray();
        int[] firstCharacterCount = new int[COUNT];
        int[] secondCharacterCount = new int[COUNT];

        for (char c : firstCharacters) {
            firstCharacterCount[c - OFFSET]++;
        }

        for (char c : secondCharacters) {
            secondCharacterCount[c - OFFSET]++;
        }

        int diffSum = 0;
        for (int i = 0; i < COUNT; i++) {
            // Add the difference to the sum
            diffSum += Math.abs(firstCharacterCount[i] - secondCharacterCount[i]);
        }

        return diffSum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();

        System.out.println(numberNeeded(a, b));
    }
}
