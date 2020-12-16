package algorithm.jianzhiOffer;

import java.util.*;

public class Main33 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int T = Integer.parseInt(sc.nextLine());
        int e = 0;
        while (e++ < T) {
            String[] strs = sc.nextLine().split(" ");
            int n = Integer.parseInt(strs[0]), m = Integer.parseInt(strs[1]), k = Integer.parseInt(strs[2]);
            int[][] edges = new int[n][n];
            boolean[] visited = new boolean[n];
            int j = 0;
            while (j++ < m) {
                String[] str = sc.nextLine().split(" ");
                int node1 = Integer.parseInt(str[0]) - 1, node2 = Integer.parseInt(str[1]) - 1, price = Integer.parseInt(str[2]);
                if (price <= k) {
                    if (node1 != node2) {
                        edges[node1][node2] = 1;
                        edges[node2][node1] = 1;
                    }
                }
            }
            visited[0] = true;
            dfs(0, visited, edges);
            for (int i = 0; i < visited.length; ++i) {
                if (!visited[i]) {
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }
    }


    public static void dfs(int i, boolean[] visited, int[][] edges) {

        visited[i] = true;

        //visit(i);

        for (int j = 0; j < visited.length; ++j) {
            if (edges[i][j] == 1 && !visited[j]) {
                dfs(j, visited, edges);
            }
        }
    }

}