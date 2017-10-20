package com.claasm;

import java.util.Stack;

public class PowerSet {

    public static void main(String[] args) {
        // write your code here
        printPowerSets(new int[]{1,2,3}, new Stack<>(), 0);
    }

    public static void printPowerSets(int[] set, Stack<Integer> currentSet, int startIndex) {
        for (int i = startIndex; i < set.length; i++) {
            currentSet.push(set[i]);
            printSet(currentSet);
            printPowerSets(set, currentSet, i + 1);
            currentSet.pop();
        }
    }

    private static void printSet(Stack<Integer> currentSet) {
        System.out.print("{");
        for (int element : currentSet) {
            System.out.print(element + ", ");
        }
        System.out.println("}");
    }

}
