package algorithm.LeetCode;

public class Unique_Paths_62 {

    public int uniquePaths(int m, int n) {
        //递归办法 时间太长
        // return dis(0, 0, m - 1, n - 1);
        return dp(m, n);
    }

    public int dis(int i, int j, int m, int n) {
//        System.out.println("(" + i + "," + j + ")");
        if (i == m)
            return 1;
        if (j == n)
            return 1;

        return dis(i + 1, j, m, n) + dis(i, j + 1, m, n);
    }
//动态规划，题目很典型，为了编程方便，我们计算从终点mn到出发点00的方式数，dp[i][j]表示点（i,j）到（0,0）的方法数
    //对于dp[i][j]，很显然，它等于它上面的点的方法数加上它左边点的方法数。
    public int dp(int m, int n) {
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = 1;
        for (int i = 0; i < n; i++)
            dp[0][i] = 1;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        return dp[m - 1][n - 1];
    }

    public static void main(String argc[]) {
        System.out.print(new Unique_Paths_62().uniquePaths(7, 3));
    }
}
