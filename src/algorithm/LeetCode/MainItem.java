package algorithm.LeetCode;

public class MainItem {
    public static int mainNum(int[] nums) {
        if (nums.length == 0) return -1;
        int count = 1;
        int mainNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (mainNum == nums[i]) count++;
            else {
                count--;

            }
            if (count < 0) mainNum = nums[i];
        }
        return mainNum;
    }

    public static void main(String[] args) {
        System.out.println(mainNum(new int[]{1, 1, 1, 1, 1, 1, 3, 5, 6, 1, 1, 1, 1, 3, 6, 7, 4, 7, 8, 4}));
    }
}
