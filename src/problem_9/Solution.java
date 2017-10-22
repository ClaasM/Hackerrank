package problem_9;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int rows = in.nextInt();
        int columns = in.nextInt();
        boolean grid[][] = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                grid[row][column] = in.nextInt() == 1;
            }
        }

        // We could just unset the respective fields in the grid if performance is that important
        boolean[][] visited = new boolean[rows][columns];
        int maxRegionSize = 0;
        //From every point in the array, start a DFS
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                maxRegionSize = Math.max(DFS(grid, visited, row, column), maxRegionSize);
            }
        }
        System.out.println(maxRegionSize);
    }

    public static int DFS(boolean[][] grid, boolean[][] visited, int row, int column) {
        //Check constraints and whether the point was already visited
        if (row < 0
                || row >= grid.length
                || column < 0
                || column >= grid[0].length
                || visited[row][column]
                || !grid[row][column]) {

            return 0;
        } else {
            visited[row][column] = true;
            return 1
                    + DFS(grid, visited, row - 1, column)
                    + DFS(grid, visited, row + 1, column)
                    + DFS(grid, visited, row, column - 1)
                    + DFS(grid, visited, row, column + 1)
                    + DFS(grid, visited, row + 1, column + 1)
                    + DFS(grid, visited, row + 1, column - 1)
                    + DFS(grid, visited, row - 1, column + 1)
                    + DFS(grid, visited, row - 1, column - 1);
        }
    }
}
