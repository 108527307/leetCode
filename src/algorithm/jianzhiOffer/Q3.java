package algorithm.jianzhiOffer;

public class Q3 {
    public int findRepeatNumber(int[] nums) {
        int len = nums.length;
        int counts[] = new int[len];
        for (int i = 0; i < len; i++) {
            if (counts[nums[i]] == 0)
                counts[nums[i]]++;
            else
                return nums[i];
        }
        return 0;
    }
}
