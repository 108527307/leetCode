package algorithm.LeetCode;

import java.util.Map;

public class maxValues {
    public static int maxValue(int[] nums) {
        int[][] dp = new int[nums.length][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        dp[1][0] = Math.max(dp[0][0], dp[0][1]);
        dp[1][1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = Math.max(dp[i - 2][0], dp[i - 2][1]) + nums[i];
        }
        return Math.max(dp[nums.length - 1][0], dp[nums.length - 1][1]);
    }

    public static void main(String[] args) {
        System.out.println(maxValue(new int[]{8, 1, 9, 10, 3, 5}));
    }
}
