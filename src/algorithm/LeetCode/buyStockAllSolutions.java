package algorithm.LeetCode;

public class buyStockAllSolutions {
    //标准模板，限制交易次数为k,因为每次交易需要至少2天来完成，因此若k>n/2时，说明此时即使每天都在交易也达不到k此，可视为无次数限制
    public int maxProfit(int[] prices, int k) {
        if (prices.length == 0)
            return 0;
        if (k > prices.length / 2)
            return maxProfit_inf(prices);
        int dp[][][] = new int[prices.length + 1][k + 1][2];
        for (int i = 0; i <= prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i - 1]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i - 1]);
            }
        }
        return dp[prices.length][k][0];
    }

    //交易包含冷冻期1天状态,内存压缩版
    public int maxProfit_coolDown(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;//dp[i-2][0]
        for (int i = 0; i < prices.length; i++) {
            int temp = dp_i_0;//用来保存i-1天的未持股状态，若当天发生买入操作，则在下次交易时需要用此股价

            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);//第i天状态为不持股
            dp_i_1 = Math.max(dp_pre_0 - prices[i], dp_i_1);//第i天状态为持股，此时若是买入操作，则需要比较的是i-2天的未持股状态（i-1天被冻结）
            dp_pre_0 = temp;
            System.out.print(dp_i_1);

        }
        System.out.println();
        return dp_i_0;
    }

    //交易期冷冻完整版,限制交易次数
    public int maxProfit_coolDown1(int k, int[] prices) {
        if (k == 0 || prices.length == 0)
            return 0;
        int dp[][][] = new int[prices.length + 1][k + 1][2];

        for (int i = 0; i <= prices.length; i++) {
            for (int j = k; j >= 1; j--) {
                if (i == 0) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = Integer.MIN_VALUE;
                    continue;
                }
                if (i == 1) {
                    dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                    dp[i][j][1] = -prices[0];
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 2][j - 1][0] - prices[i]);
            }

        }
        return dp[prices.length][k][0];
    }

    //交易期冷冻完整版，不限制交易次数
    public int maxProfit_inf_coolDown(int[] prices) {

        if (prices.length == 0)
            return 0;
        int dp[][] = new int[prices.length + 1][2];

        for (int i = 0; i <= prices.length; i++) {

            if (i == 0) {
                dp[i][0] = 0;
                dp[i][1] = Integer.MIN_VALUE;
                continue;
            }
            if (i == 1) {
                dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
                dp[i][1] = -prices[0];
                continue;
            }
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 2][0] - prices[i - 1]);
        }

        return dp[prices.length][0];
    }

    //当交易的次数不限制时,压缩版
    public int maxProfit_inf(int[] prices) {
        if (prices.length == 0)
            return 0;
        int dp_i_0 = 0;
        int dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }

    //交易带着手续费，次数不限
    public int maxProfit_inf_fee(int[] prices, int fee) {
        if (prices.length == 0)
            return 0;
        int dp_i_0 = 0;
        int dp_i_1 = -999999999;//不能设置为整型最小，减完fee后可能会下溢出
        for (int i = 0; i < prices.length; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i] - fee);
            dp_i_1 = Math.max(dp_i_1, dp_i_0 - prices[i]);
        }
        return dp_i_0;
    }

    public static void main(String argc[]) {


       // System.out.print(new buyStockAllSolutions().maxProfit_inf_coolDown(new int[]{2, 1, 4}));
        System.out.print(new buyStockAllSolutions().maxProfit_inf_fee(new int[]{1, 3, 2, 8, 4, 9}, 2));
        // System.out.print(new Best_Time_to_Buy_and_Sell_Stock_121().maxProfit(new int[]{3,3,5,0,0,3,1,4}));
    }
}
