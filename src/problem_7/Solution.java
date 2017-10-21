package problem_7;

import java.util.*;

public class Solution {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];

        for (int coins_i = 0; coins_i < m; coins_i++) {
            coins[coins_i] = in.nextInt();
        }

        int[] waysToMakeChange = new int[n + 1];
        Arrays.fill(waysToMakeChange, 0);
        waysToMakeChange[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = coins[i]; j <= n; j++) {
                waysToMakeChange[j] += waysToMakeChange[j - coins[i]];
            }
        }

        System.out.println(countWays(coins,m,n));
    }

    static long countWays(int S[], int m, int n) {
        //Time complexity of this function: O(mn)
        //Space Complexity of this function: O(n)

        // table[i] will be storing the number of solutions
        // for value i. We need n+1 rows as the table is
        // constructed in bottom up manner using the base
        // case (n = 0)
        long[] table = new long[n + 1];

        // Initialize all table values as 0
        Arrays.fill(table, 0);   //O(n)

        // Base case (If given value is 0)
        table[0] = 1;

        // Pick all coins one by one and update the table[]
        // values after the index greater than or equal to
        // the value of the picked coin
        for (int i = 0; i < m; i++)
            for (int j = S[i]; j <= n; j++)
                table[j] += table[j - S[i]];

        return table[n];
    }

}

