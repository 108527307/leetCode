package algorithm;

import java.util.Arrays;

public class Q300 {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) return 0;
        int dp[] = new int[nums.length];
        Arrays.fill(dp, 1);
        int re = 1;
        for (int i = 0; i < dp.length; i++) {

            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = dp[i] < (dp[j] + 1) ? (dp[j] + 1) : (dp[i]);
                }

            }
            re = re > dp[i] ? re : dp[i];
        }
        return re;
    }

    public int lengthOFLIS(int[] nums) {
        if (nums.length <= 1) return nums.length;
        int cell[] = new int[nums.length];
        cell[0] = nums[0];
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (cell[j] < nums[i])
                cell[++j] = nums[i];
            else {
                int l = 0, r = j;
                while (l < r) {
                    int mid = (l + r) >> 1;
                    if (cell[mid] < nums[i]) {
                        l = mid + 1;
                    } else r = mid;
                }
                cell[l] = nums[i];
            }
        }
        return cell.length;
    }
}
