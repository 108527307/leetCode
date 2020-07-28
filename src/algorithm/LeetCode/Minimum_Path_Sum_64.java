package algorithm.LeetCode;

public class Minimum_Path_Sum_64 {
    public int minPathSum(int[][] grid) {
        return dp(grid);
    }

    public int dp(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int dp[][] = new int[m][n];
        dp[0][0] = a[0][0];
        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + a[i][0];
        for (int i = 1; i < n; i++)
            dp[0][i] = dp[0][i - 1] + a[0][i];
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                int up = dp[i - 1][j];
                int left = dp[i][j - 1];
                dp[i][j] = a[i][j];
                dp[i][j] += (up < left) ? up : left;
            }
        return dp[m - 1][n - 1];

    }

    public static void main(String[] argc) {
        System.out.print(new Minimum_Path_Sum_64().minPathSum(new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}}));
    }
}
