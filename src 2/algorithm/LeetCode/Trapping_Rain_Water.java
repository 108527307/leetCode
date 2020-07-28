package algorithm.LeetCode;

public class Trapping_Rain_Water {

    /**
     * @return int
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 11/4/2019 10:13 PM
     * @desc:
     */
    public int trap(int[] height) {
        int MaxI = 0, MaxJ = 0, sum = 0, maxIndex = 0;// MaxI,MaxJ用来存储i 和 j 扫描时的最大值，sum用来计数能盛水的数量，maxIndex用来标记序列中的最大值
        for (int k = 0; k < height.length; k++)//首先找出最大值
            if (height[k] > height[maxIndex])
                maxIndex = k;
        int i = 0, j = height.length - 1;
        //开始循环扫描，i从左向右，j从右向左
        while ( i < maxIndex || j > maxIndex) {
            if (height[i] > MaxI)//更新最大值
                MaxI = height[i];
            else
                sum += MaxI - height[i];//当当前的元素比扫描的最大值小时，则说明它们之间的差值就是盛水的数量，因为右边有序列最大值
            if (height[j] > MaxJ)
                MaxJ = height[j];
            else
                sum += MaxJ - height[j];
            if(i < maxIndex)
                i++;
            if(j > maxIndex)
                j--;
        }
        return sum;
    }

    public static void main(String argc[]) {
        System.out.print(new Trapping_Rain_Water().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }
}
