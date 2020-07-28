package algorithm.LeetCode;

public class Jump_Game_2 {
    /**
     * @return int
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 25/4/2019 7:49 PM
     * @desc: 45 跳跃游戏2 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     */
    public int jump(int[] nums) {
        int len = nums.length, i = 0, level = 0, curMaxIndex = 0;//level 表示当前的层数，即跳跃步数，curMaxIndex表示当前层的所能到达的最大下标
        if (len <= 1) return 0;
        while (i <= curMaxIndex) {
            int furMaxIndex = curMaxIndex;//表示下一层所能到达的最大下标，首先初始化为当前层的最大下标，循环结束后将下一层在更新到当前层，这样表示向下一层搜索。
            for (; i <= curMaxIndex; i++) {//对当前层的节点进行搜索，对每个节点进行判断不断更新下一层所能到达的最大下标
                furMaxIndex = Math.max(furMaxIndex, nums[i] + i);
                if (furMaxIndex >= len - 1) return level + 1;//如果下一层的最大下标超过或者等于最后最后一个元素下标，则表示已经到达最后一个元素可以进行返回
            }
            level++;
            curMaxIndex = furMaxIndex;
        }
        return -1;
    }


    public static void main(String argc[]) {
        System.out.print(new Jump_Game_2().jump(new int[]{2, 3, 1, 1, 4}));
    }
}
