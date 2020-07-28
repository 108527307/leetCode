package algorithm.LeetCode;

public class Maximum_subarray_53 {
    /**
     * @return int
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 24/5/2019 10:19 AM
     * @desc: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * 示例:
     * <p>
     * 输入: [-2,1,-3,4,-1,2,1,-5,4],
     * 输出: 6
     * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
     * 进阶:
     * <p>
     * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
     */
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int tempSum = 0;
        for (int i : nums) {
            if (tempSum > 0) {//当临时子序列的和小于0时，则作废，从i重新开始计算，否则则持续增长子序列
                tempSum += i;

            } else
                tempSum = i;
            //对当前的子序列进行判断是否超过历史最长子序列长度。
            res = res > tempSum ? res : tempSum;
        }
        return res;
    }
/**
 *
  * @return int
 * @author chy
 * @creed: Talk is cheap,show me the code
 * @date 28/5/2019 9:13 AM
 * @desc: 动态规划
 */
    public int maxSubArray2(int[] nums) {
        int sum = nums[0];
        int sumPre = nums[0];
        for (int i : nums) {
            if (sumPre > 0)
                sumPre += i;
            else
                sumPre = i;
            sum = sum > sumPre ? sum : sumPre;
        }
        return sum;
    }

    public static void main(String[] argc) {
        System.out.print(new Maximum_subarray_53().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
