package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Merge_Intervals_56 {
    /**
     * @return int[][]
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 29/5/2019 12:57 PM
     * @desc: 56 给出一个区间的集合，请合并所有重叠的区间
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0)
            return new int[][]{};
        //首先 按照 每个区间的start进行排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> res = new ArrayList<>();
        int i = 1;
        //开始扫描窗口为2的扫描
        for (i = 1; i < intervals.length; i++) {
            int[] pre = intervals[i - 1];
            int[] now = intervals[i];
            if (pre[1] >= now[0]) {
                now[1] = now[1] > pre[1] ? now[1] : pre[1];
                now[0] = pre[0];
            } else {
                res.add(intervals[i - 1]);
            }
        }
        res.add(intervals[i - 1]);

        int[][] result = new int[res.size()][2];

        for (int j = 0; j < result.length; j++) {
            result[j] = res.get(j);
        }
        return result;
    }

    public static void main(String[] argc) {
        int[][] res = new Merge_Intervals_56().merge(new int[][]{{1, 4}, {4, 6}});
        return;
    }
}
