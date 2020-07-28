package algorithm.LeetCode;

public class Maximal_Rectangle_85 {
    public int maximalRectangle(char[][] matrix) {
        return dp1(matrix);
    }

    //方法一 动态规划：基于柱状图贪心优化
    public int dp1(char[][] matrix) {
        int m = matrix.length;
        if (m==0)
            return 0;
        int n = matrix[0].length;
        if (n==0)
            return 0;
        int dp[][] = new int[m][n];
        int maxArea = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0')
                    continue;
                int width = dp[i][j] = j == 0 ? 1 : (dp[i][j - 1] + 1);//第一列初始化为1，其他的宽度为前一个加1
                for (int k = i; k > -1; k--) {
                    width = Math.min(width, dp[k][j]);
                    maxArea = Math.max(maxArea, width * (i - k + 1));

                }
            }
        return maxArea;
    }
    //方法二 动态规划- 每个点的最大高度

    public static void main(String[] argc) {
        System.out.print(new Maximal_Rectangle_85().maximalRectangle(new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}}));
    }
}
