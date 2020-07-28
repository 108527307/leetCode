package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Triangle_120 {
    public Integer memo[][];

    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        memo = new Integer[triangle.size()][triangle.size()];
        return mini(0, 0, triangle, triangle.size());
    }


    public int mini(int i, int j, List<List<Integer>> triangle, int len) {
        if (memo[i][j] != null)
            return memo[i][j];
        if (i == len - 1)
            return triangle.get(i).get(j);
        int temp1 = mini(i + 1, j, triangle, len);
        int temp2 = mini(i + 1, j + 1, triangle, len);
        memo[i][j] = Math.min(temp1, temp2) + triangle.get(i).get(j);
        return memo[i][j];
    }

    public int dps(List<List<Integer>> triangle) {
        if (triangle.size() == 0)
            return 0;
        int[][] dp = new int[triangle.size()][triangle.size()];
        dp[0][0] = triangle.get(0).get(0);
        for (int i = 1; i < triangle.size(); i++)
            for (int j = 0; j <= i; j++) {
                if (j == 0)
                    dp[i][0] = dp[i - 1][0] + triangle.get(i).get(0);
                else if (j == i)
                    dp[i][j] = dp[i - 1][j - 1] + triangle.get(i).get(j);
                else
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i - 1][j - 1]) + triangle.get(i).get(j);
            }
        int min = dp[triangle.size()-1][0];
        for (int k : dp[triangle.size()-1])
            min = min > k ? k : min;
        return min;
    }


    public static void main(String[] argc) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l1 = new ArrayList<Integer>(Arrays.asList(new Integer[]{2}));
        List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(new Integer[]{3, 4}));
        List<Integer> l3 = new ArrayList<Integer>(Arrays.asList(new Integer[]{6, 5, 7}));
        List<Integer> l4 = new ArrayList<Integer>(Arrays.asList(new Integer[]{4, 1, 8, 3}));
        List<Integer> l5 = new ArrayList<Integer>(Arrays.asList(new Integer[]{2}));
        list.add(l1);
        list.add(l2);
        list.add(l3);
        list.add(l4);
        System.out.print(new Triangle_120().dps(list));
    }
}
