package algorithm;

import java.util.*;

public class Main25 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int T = sc.nextInt();
        for (int i = 0; i < T; ++i) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] ee = new int[n][n];
            boolean[] visited = new boolean[n];
            for (int j = 0; j < m; ++j) {
                int node1 = sc.nextInt() - 1;
                int node2 = sc.nextInt() - 1;
                int price = sc.nextInt();
                if (price <= k) {
                    if (node1 != node2) {
                        ee[node1][node2] = 1;
                        ee[node2][node1] = 1;
                    }
                }
            }
            visited[0] = true;
            dfs(0, visited, ee);
            for (int f = 0; f < visited.length; f++) {
                if (!visited[f]) {
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }
    }

    public static void dfs(int i, boolean[] visited, int[][] edges){
        visited[i] = true;
        for(int j = 0; j < visited.length; ++j){
            if(edges[i][j]==1 && !visited[j]){
                dfs(j, visited, edges);
            }
        }
    }

}