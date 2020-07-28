package algorithm.LeetCode;

class Pair {
    public int first, second;

    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class stoneGame_887 {
    /**
     * 亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。
     * <p>
     * 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。
     * <p>
     * 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
     * <p>
     * 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。
     */
    //使用dp解答
    //piles.length=odd  alice 先手
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        Pair[][] dp = new Pair[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j)
                    dp[i][j] = new Pair(piles[i], 0);//填入basecase（只有一堆石头）
                else
                    dp[i][j] = new Pair(0, 0);//初始化

            }

        for (int l = 2; l <= n; l++)
            for (int i = 0; i < n - 1; i++) {
                int j = i + l - 1;//当前末尾石头堆index
                if (j == n)
                    break;
                int left = piles[i] + dp[i + 1][j].second;
                int right = piles[j] + dp[i][j - 1].second;
                if (left >= right) {
                    dp[i][j].first = left;
                    dp[i][j].second = dp[i + 1][j].first;
                } else {
                    dp[i][j].first = right;
                    dp[i][j].second = dp[i][j - 1].first;

                }
            }
        return dp[0][n - 1].first > dp[0][n - 1].second;

    }

    public static void main(String[] argc) {
        System.out.print(new stoneGame_887().stoneGame(new int[]{5, 4}));
    }

}
