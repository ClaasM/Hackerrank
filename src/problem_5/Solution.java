package problem_5;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {


    public static boolean isBalanced(String input) {
        Stack<Character> expressionStack = new Stack<>();
        char[] expressions = input.toCharArray();
        for (char expression : expressions) {
            if (expression == ')') { if(expressionStack.isEmpty() || expressionStack.pop() != '(') return false;
            } else if (expression == '}') {if(expressionStack.isEmpty() || expressionStack.pop() != '{') return false;
            } else if (expression == ']') {if(expressionStack.isEmpty() || expressionStack.pop() != '[') return false;
            } else {
                expressionStack.push(expression);
            }
        }
        return expressionStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println((isBalanced(expression)) ? "YES" : "NO");
        }
    }
}
