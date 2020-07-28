package algorithm.LeetCode;

public class Jump_Game {
    /**
     * @return boolean
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 22/4/2019 9:56 PM
     * @desc: 55 跳跃游戏 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个位置。
     */
    public boolean canJump(int[] nums) {
        if (nums.length == 1)
            return true;
        int len = nums.length;
        return partition2(nums, 0, len, 0);
//        return pa(nums);

    }

    /**
     * @return boolean
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 22/4/2019 11:39 PM
     * @desc: index 是当前扫描的元素下标 length是nums的长度
     */
    public boolean partition(int[] nums, int index, int length) {
        if (index >= length - 1)//若当前扫描的元素已经是最后一个则直接返回true，若index>length-1 则说明在上一层递归中扫描到的某个元素其大小已经能够覆盖到最后的元素，说明可行。
            return true;
        if (nums[index] == 0)//若当前元素为0，直接pass，前进不了了
            return false;
        for (int i = nums[index]; i > 0; i--)//对0-nums[index]的步长进行扫描递归
            if (partition(nums, index + i, length))
                return true;
        return false;
    }

    public boolean partition2(int[] nums, int index, int length, int sum) {
        return true;
    }

    /*
     *
      * @return boolean
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 22/4/2019 11:45 PM
     * @desc:
     */
    public boolean pa(int[] nums) {
        int tempVal = 1;//初始化步长存储器为1
        for (int i = 0; i < nums.length - 1; i++) {//i的上限是倒数第二个元素
            tempVal = tempVal - 1 > nums[i] ? tempVal - 1 : nums[i];//每向前走一步都进行判断，是否进行接力
            if (tempVal == 0)//当步数耗完之后，则gameover，到不了最后
                return false;
        }
        return true;
    }

    public static void main(String argc[]) {
        System.out.print(new Jump_Game().canJump(new int[]{3, 2, 1, 0, 4}));
    }
}
