package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    /**
     * @return java.util.List<java.util.List<java.lang.Integer>>
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 27/4/2019 9:40 AM
     * @desc: 46 全排列 给定一个没有重复数字的序列，返回其所有可能的全排列。
     */
    public List<List<Integer>> permute(int[] nums) {
        int size = nums.length;


        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmp = new ArrayList<>();
        per(nums, 0, size - 1, res, tmp);
        return res;
    }


    public List<Integer> arrayToList(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (Integer i : nums)
            list.add(i);
        return list;

    }

    public void swap(int[] nums, int i, int p) {
        Integer temp = nums[i];
        nums[i] = nums[p];
        nums[p] = temp;
    }

    public void per(int[] nums, int p, int q, List<List<Integer>> res, List<Integer> tmp) {
        if (p == q)
            res.add(arrayToList(nums));
        else {
            for (int i = p; i <= q; i++) {
//                if (!canSwap(nums, p, i))
//                    continue;
                if (tmp.contains((Integer) i))
                    continue;
                tmp.add((Integer) i);
                swap(nums, i, p);
                per(nums, p + 1, q, res, tmp);
                swap(nums, i, p);
                tmp.remove((Integer) i);
            }
        }

    }

    private boolean canSwap(int nums[], int begin, int end) {
        for (int i = begin; i < end; i++) {
            if (nums[i] == nums[end]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String argc[]) {
        List<List<Integer>> res = new Permutations().permute(new int[]{1, 1, 2, 2});
        for (List<Integer> item : res) {
            for (Integer i : item)
                System.out.print(i);
            System.out.println();
        }
    }
}
