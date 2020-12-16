package algorithm;

import java.util.*;

public class Main24 {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int T = sc.nextInt();
        int r = 0;
        for (int e = 0; e < T; e++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int k = sc.nextInt();
            int[][] es = new int[n][n];
            boolean[] vi = new boolean[n];
            for (int j = 0; j < m; ++j) {
                int node1 = sc.nextInt() - 1;
                int node2 = sc.nextInt() - 1;
                int price = sc.nextInt();
                if (price <= k) {
                    if (node1 != node2) {
                        es[node1][node2] = 1;
                        es[node2][node1] = 1;
                    }
                }
            }
            vi[0] = true;
            dfs(0, vi, es);
            for (int i = 0; i < vi.length; ++i) {
                if (!vi[i]) {
                    System.out.println("No");
                    return;
                }
            }
            System.out.println("Yes");
        }
    }


    public static void dfs(int i, boolean[] vi, int[][] es) {
        vi[i] = true;
        for (int j = 0; j < vi.length; ++j) {
            if (es[i][j] == 1 && !vi[j]) {
                dfs(j, vi, es);
            }
        }
    }

}