package algorithm.LeetCode;

//动态规划和62题一样的思路，但是在更新每个dp的时候判断一下是否为障碍物，如果是，则这个dp就是0，初始化的时候也是要注意碰到障碍物，则后面的都要初始化为0
public class Unique_Paths_II_63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return dp(obstacleGrid);
    }

    public int dp(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (a[i][0] != 1)
                dp[i][0] = 1;
            else
                break;
        }
        for (int j = 0; j < n; j++) {
            if (a[0][j] != 1)
                dp[0][j] = 1;
            else
                break;
        }
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (a[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        return dp[m - 1][n - 1];

    }

    public static void main(String argc[]) {
        System.out.print(new Unique_Paths_II_63().uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }
}



