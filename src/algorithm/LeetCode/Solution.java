package algorithm.LeetCode;

import java.util.*;

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> r = new ArrayList();
        if (digits.equals("")) return r;
        String[][] c = {
                {"a", "b", "c"},
                {"d", "e", "f"},
                {"g", "h", "i"},
                {"j", "k", "l"},
                {"m", "n", "o"},
                {"p", "q", "r", "s"},
                {"t", "u", "v"},
                {"w", "x", "y", "z"}
        };
        r.add("");
        for (int i = 0; i < digits.length(); i++) {
            List<String> m = new ArrayList();
            int a = digits.charAt(i);
            int n = a - 50;//使用acii码值进行转换，转换为相应数字对应子母集的行下标
            for (int j = 0; j < c[n].length; j++) {
                //
                for (String s : r) {
                    m.add(s + c[n][j]);
                }
            }
            r = m;
        }
        return r;
    }

    //33. 搜索旋转排序数组
// 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
//( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
//    搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
//    你可以假设数组中不存在重复的元素。
//    你的算法时间复杂度必须是 O(log n) 级别。
    public int binary(int left, int right, int[] nums, int target) {
        if (left > right)
            return -1;
        int mid = (left + right) / 2;
        if (target == nums[mid])
            return mid;
        if (nums[mid] > target) {
            return binary(left, mid - 1, nums, target);
        } else {
            return binary(mid + 1, right, nums, target);
        }
    }

    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length == 0)
            return -1;
        if (length == 1 && nums[0] == target)
            return target;
        int left = 0, right = length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target)
                return mid;
            if (nums[left] == target)
                return left;
            if (nums[right] == target)
                return right;
            if (nums[0] < nums[mid]) {//左半边有序
                if (target < nums[mid] && target >= nums[left])
                    right = mid - 1;
//                    return binary(left, mid-1, nums, target);
                else
                    left = mid + 1;
            } else {//右半边有序
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
//                    return binary(mid + 1, right, nums, target);
                else
                    right = mid - 1;
            }
        }

        return -1;
    }

    /**
     * @return int[]
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 30/3/2019 4:21 PM
     * @desc: 34. 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 你的算法时间复杂度必须是 O(log n) 级别。
     * <p>
     * 如果数组中不存在目标值，返回 [-1, -1]。
     */
    public int[] searchTange(int[] nums, int target) {
        if (nums.length <= 0)
            return new int[]{-1, -1};
        return binary2(0, nums.length - 1, nums, target);
    }

    public int[] binary2(int left, int right, int[] num, int target) {
        if (left > right) {
            return new int[]{-1, -1};
        }
        int mid = (right + left) / 2;
        if (target == num[mid]) {
            int j = mid, k = mid;
            while (j >= 0 && num[mid] == num[j]) j--;
            while (k < num.length && num[mid] == num[k]) k++;
            return new int[]{j + 1, k - 1};
        } else if (target < num[mid])
            return binary2(left, mid - 1, num, target);
        else
            return binary2(mid + 1, right, num, target);
    }

    /**
     * @return int
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 30/3/2019 5:00 PM
     * @desc: 35. 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     */
    public int searchInsert(int[] nums, int target) {
        if (target > nums[nums.length - 1])
            return nums.length;
        return searchBin(0, nums.length, nums, target);
    }

    public int searchBin(int left, int right, int nums[], int target) {
        if (left > right) {
            return left;
        }
        int mid = (left + right) / 2;
        if (target == nums[mid]) {
            return mid;
        } else if (target < nums[mid])
            return searchBin(left, mid - 1, nums, target);
        else
            return searchBin(mid + 1, right, nums, target);
    }

    /**
     * @return boolean
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 30/3/2019 5:33 PM
     * @desc:36. 判断一个 9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     */
    public boolean isvalidSudoku(char[][] board) {
        int[][] vals1 = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}};
        int[][] vals2 = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}};
        int[][] vals3 = {{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}};
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                if ((board[i][j] != '.' && vals1[board[i][j] - '0' - 1][1] >= 1) || (board[j][i] != '.' && vals2[board[j][i] - '0' - 1][1] >= 1)) {
                    return false;
                } else {
                    if (board[i][j] != '.')
                        vals1[board[i][j] - '0' - 1][1]++;
                    if (board[j][i] != '.')
                        vals2[board[j][i] - '0' - 1][1]++;
                }

            }
            vals1 = new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}};
            vals2 = new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}};


        }
        for (int i = 0; i <= 6; i += 3) {
            for (int j = 0; j <= 6; j += 3) {

                for (int start = i; start < i + 3; start++) {
                    for (int end = j; end < j + 3; end++) {
                        if ((board[start][end] != '.' && vals3[board[start][end] - '0' - 1][1] >= 1)) {
                            return false;
                        } else {
                            if (board[start][end] != '.')
                                vals3[board[start][end] - '0' - 1][1]++;
                        }
                    }
                }
                vals3 = new int[][]{{1, 0}, {2, 0}, {3, 0}, {4, 0}, {5, 0}, {6, 0}, {7, 0}, {8, 0}, {9, 0}};
            }
        }

        return true;

    }



    public static void main(String argc[]) {

        char[][] temp = {
                {'.', '.', '.', '.', '5', '.', '.', '3', '.'},
                {'.', '4', '.', '1', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        System.out.print((new Solution().isvalidSudoku(temp)));
    }
}