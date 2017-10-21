package problem_3;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    class Node {
        int data;
        Node left;
        Node right;
    }

    boolean checkBST(Node root) {
        // The min is -1 because BST can contain 0 and still be valid
        return checkBSTrecursive(root, -1, Integer.MAX_VALUE);
    }

    boolean checkBSTrecursive(Node root, int min, int max){
        return root.data > min && root.data < max
                && (root.left == null || checkBSTrecursive(root.left, min, root.data))
                && (root.right == null || checkBSTrecursive(root.right, root.data, max));
    }
}
