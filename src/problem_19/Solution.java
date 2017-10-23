package problem_19;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    class Player {
        String name;
        int score;

        Player(String name, int score) {
            this.name = name;
            this.score = score;
        }
    }

    // Write your Checker class here
    class Checker implements Comparator<Player> {

        @Override
        public int compare(Player p1, Player p2) {
            int scoreCompare = Integer.compare(p2.score, p1.score);
            if (scoreCompare == 0) {
                return p1.name.compareTo(p2.name);
            }
            return scoreCompare;
        }
    }
}