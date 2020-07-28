//import java.util.ArrayList;
//import java.util.List;
//
//public class Insert_Interval_57 {
//    /**
//     * @return int[][]
//     * @author chy
//     * @creed: Talk is cheap,show me the code
//     * @date 31/5/2019 10:27 AM
//     * @desc:
//     */
//    public int[][] insert(int[][] intervals, int[] newInterval) {
//        List<int[]> res = new ArrayList();
//        int length = intervals.length;
//        int i = 0;
//        if (length == 0)
//            return new int[0][0];
//        if (newInterval[1] < intervals[0][0]) {
//            res.add(newInterval);
//            for (int[] item : intervals)
//                res.add(item);
//            return (int[][]) res.toArray();
//        }
//        if (newInterval[0] > intervals[length - 1][1]) {
//            for (int[] item : intervals)
//                res.add(item);
//            res.add(newInterval);
//            return (int[][]) res.toArray();
//        }
//        while (i < length && newInterval[0] > intervals[i][1]) {
//            i++;
//        }
//        int left = Math.min(intervals[i][0], newInterval[0]);
//        int j = i;
//        if (intervals[i][0] > newInterval[1]) {
//            for (int k = 0; k < i; k++)
//                res.add(intervals[k]);
//            res.add(newInterval);
//            for (int o = i; o < length; o++)
//                res.add(intervals[o]);
//            return (int[][]) res.toArray();
//        }
//        int right = newInterval[1];
//        while (i < length && newInterval[1] >= intervals[i][0]) {
//            right = Math.max(right, intervals[i][1]);
//            i++;
//        }
//        for (int f = 0; f < j; f++)
//            res.add(intervals[f]);
//        res.add(new int[]{left, right});
//        for (int g = i; g < length; g++)
//            res.add(intervals[g]);
//        Object[] b = res.toArray();
//
//    }
//
//    public static void main(String[] argc) {
//        int[][] res = new Insert_Interval_57().insert(new int[][]{{1, 3}, {6, 9}}, new int[]{2, 5});
//        return;
//    }
//}
