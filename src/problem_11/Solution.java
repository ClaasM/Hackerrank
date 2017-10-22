package problem_11;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        int num_trips = in.nextInt();
        for (int i = 0; i < num_trips; i++) {

            int money = in.nextInt();
            int num_flavors = in.nextInt();
            int flavorByCost[] = new int[money + 1];
            Arrays.fill(flavorByCost, -1);

            for (int j = 0; j < num_flavors; j++) {
                int next = in.nextInt();
                if (next > money) continue; // We can't afford it anyways

                if (flavorByCost[money - next] != -1) {
                    // There is an option that complements this one such that the entire money is spent
                    int complementaryFlavorID = flavorByCost[money - next] + 1;
                    int thisFlavorID = j + 1;

                    if (complementaryFlavorID > thisFlavorID) {
                        System.out.println(thisFlavorID + " " + complementaryFlavorID);
                    } else {
                        System.out.println(complementaryFlavorID + " " + thisFlavorID);
                    }

                }
                flavorByCost[next] = j;
            }
        }
    }
}
