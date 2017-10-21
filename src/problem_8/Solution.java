package problem_8;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num_queries = in.nextInt();
        for (int i = 0; i < num_queries; i++) {
            int num_nodes = in.nextInt();
            int num_edges = in.nextInt();

            List<List<Integer>> edges = new ArrayList<>(num_nodes);
            for (int j = 0; j < num_nodes; j++) {
                edges.add(j, new ArrayList<>());
            }


            for (int j = 0; j < num_edges; j++) {
                int from = in.nextInt() - 1;
                int to = in.nextInt() - 1;
                edges.get(from).add(to);
                edges.get(to).add(from);
            }
            int s = in.nextInt() - 1;

            int[] distances = new int[num_nodes];
            boolean[] visited = new boolean[num_nodes];
            Arrays.fill(distances, 0);
            //Perform BFS
            Queue<Integer> queue = new LinkedList<>();
            queue.add(s);
            while (!queue.isEmpty()) {

                int node = queue.poll();
                if (!visited[node]) {
                    for (int neighbor : edges.get(node)) {
                        if (!visited[neighbor]) {
                            if (distances[neighbor] == 0 || distances[neighbor] > distances[node] + 6) {
                                distances[neighbor] = distances[node] + 6;
                            }
                            queue.add(neighbor);
                        }
                    }
                    // We're done with this node
                    visited[node] = true;
                }
            }

            for (int j = 0; j < num_nodes; j++) {
                if (j != s) {
                    System.out.print((distances[j] != 0 ? distances[j] : -1) + " ");
                }
            }
            System.out.println();
        }
    }
}