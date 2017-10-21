package problem_4;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        PrefixTree tree = new PrefixTree();
        int n = in.nextInt();
        for (int i = 0; i < n; i++) {
            String op = in.next();
            String contact = in.next();
            if ("find".equals(op)) {
                System.out.println(tree.countMatches(contact));
            } else if ("add".equals(op)) {
                tree.add(contact);
            } else {
                throw new IllegalArgumentException(op);
            }
        }


    }

    public static class PrefixTree {

        //The offset of the letter 'a' in ASCII
        static final int OFFSET = 97;
        //The number of different characters that the String can be made of
        static final int COUNT = 26;

        public class Node {
            //Count for how often the node was already traversed during insertion
            //Meaning how many words were inserted that start with the prefix leading to this node
            public int count = 1;
            public Node[] children = new Node[COUNT];
        }

        Node root = new Node();

        public int countMatches(String prefix) {
            Node currNode = root;
            char[] prefixArray = prefix.toCharArray();
            for (int i = 0; i < prefixArray.length - 1; i++) {
                int index = prefixArray[i] - OFFSET;
                if (currNode.children[index] != null) {
                    currNode = currNode.children[index];
                } else {
                    return 0;
                }
            }
            int lastCharIndex = prefixArray[prefixArray.length - 1] - OFFSET;
            return currNode.children[lastCharIndex] != null ? currNode.children[lastCharIndex].count : 0;
        }

        public void add(String name) {
            Node currNode = root;
            char[] nameArray = name.toCharArray();
            for (int i = 0; i < nameArray.length; i++) {
                int index = nameArray[i] - OFFSET;
                if (currNode.children[index] != null) {
                    currNode = currNode.children[index];
                    currNode.count++;
                } else {
                    currNode.children[index] = new Node();
                    currNode = currNode.children[index];
                }
            }
        }


    }
}
