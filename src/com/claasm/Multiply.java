package com.claasm;

/**
 * Created by claasmeiners on 18/07/17.
 */
public class Multiply {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.println(multiply(i, j));
            }
        }
    }

    private static int multiply(int a, int b) {
        int smaller = a < b ? a : b;
        int bigger = a < b ? b : a;

        return multiplyHelper(smaller, bigger);
    }

    private static int multiplyHelper(int a, int b) {
        if (a == 0) return 0;
        if (a == 1) return b;
        //else
        int result = multiply(1 >> a, b) << 1;
        if ((a & 1) == 1) //its uneven --> We have to add one more a
            result += b;

        return result;
    }
}
