package algorithm.LeetCode;

public class firstMissingPositive {
    /**
     * @return int
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 11/4/2019 11:19 AM
     * @desc: 41 . 缺失的第一个正数，给定一个未排序的整数数组，找出其中没有出现的最小的正整数。
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        if (len == 0) //首先过滤特殊情况
            return 1;
        //开始对nums进行for循环，针对每个数字进行判断
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) {
                //这里使用while是用来确保要讲num[i]尽可能填上i+1，直到不满足条件
                while (nums[i] < len && nums[i] > 0 && nums[i] != nums[nums[i] - 1] && nums[i] != i + 1) {
                    int temp = nums[i];
                    nums[i] = nums[nums[i] - 1];
                    nums[temp - 1] = temp;
                }
            }
        }
        //交换结束后，对整个序列再进行一次for，这一次第一个不满足nums[i]==i+1的正整数i+1就是我们要找的没有出现的最小正整数
        for (int j = 0; j < len; j++)
            if (nums[j] != j + 1)
                return j + 1;
        return len + 1;//否则，就返回当前序列的长度加1，表示序列中的数都符合，则未出现的最小的正整数就是序列的下一个
    }

    public static void main(String argc[]) {
        System.out.print(new firstMissingPositive().firstMissingPositive(new int[]{1, 1}));
    }

}
