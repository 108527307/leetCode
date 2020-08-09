package algorithm.LeetCode;

import java.util.HashMap;
import java.util.Map;

public class twoNums {
    public static int[] getTwoNums(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        if (nums.length == 0) return null;
        for (int i = 0; i < nums.length; i++)
            map.put(nums[i], i);
        for (int i = 0; i < nums.length; i++) {
            int complex = target - nums[i];
            if (map.containsKey(complex) && map.get(complex) != i) {
                return new int[]{nums[i], complex};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(getTwoNums(new int[]{1, 2, 3, 4, 5, 6, 3, 2, 4}, 6)[1]);
    }
}
