package algorithm;

import java.util.*;

public class HUAWEI {
    public static int moveToMakeZigzag(int[] nums) {
        int even = moveToMakeZigzagEven(nums);
        int odd = moveToMakeZigzagOdd(nums);
        return Math.min(even, odd);
    }

    public static int moveToMakeZigzagEven(int[] nums) {
        int count = 0;
        int temp = 0;

        for (int i = 1; i < nums.length; i += 2) {
            if (i == nums.length - 1 && nums.length % 2 == 0) {
                temp = nums[i - 1];
            } else {
                temp = Math.min(nums[i - 1], nums[i + 1]);
            }
            if (nums[i] > temp) {
                count += (nums[i] - temp + 1);
            }
        }
        return count;
      // Map<String> map=new HashMap<>();
    }

    public static int moveToMakeZigzagOdd(int[] nums) {
        int count = 0;
        int temp = 0;

        for (int i = 0; i < nums.length; i += 2) {
            if (i == 0) temp = nums[i + 1];
            else if (i == nums.length - 1 && nums.length % 2 != 0) {
                temp = nums[i - 1];
            } else {
                temp = Math.min(nums[i - 1], nums[i + 1]);
            }
            if (nums[i] > temp) {
                count += (nums[i] - temp + 1);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] test = {9, 6, 1, 6, 1};
        System.out.println(moveToMakeZigzag(test));
    }
}
