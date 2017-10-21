package problem_1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for (int a_i = 0; a_i < n; a_i++) {
            a[a_i] = in.nextInt();
        }

        //The array that will contain the result after the rotation
        int[] result = new int[n];
        //For each element...
        for (int i = 0; i < n; i++) {
            // After k rotations, all elements are placed k to the left
            // Careful! in java, % actually calculates the remainder
            int remainder = (i - k) % n;
            //To get the modulus, we might have to add n once
            int position;
            if (remainder<0) position = remainder + n;
            else position = remainder;
            // modulo the length of the array (we have to use abs since in Java, % actually calculates the remainder)
            result[position] = a[i];
        }

        //Print the result.
        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        //Go to the next line
        System.out.println();
    }
}
