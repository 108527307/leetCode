package algorithm.LeetCode;

import java.util.HashSet;
import java.util.Set;

public class subarrayBitwiseORs_898 {
    public int subarrayBitwiseORs(int[] A) {
        int n = A.length;

        int[][] dp = new int[n][n];
        Set<Integer> ans = new HashSet<>();
        //这种循环遍历的方式，只取一半，l表示i到j之间的距离，因为是subarray，必须连续，所以采用l由小到大的方式
        for (int l = 1; l <= n; ++l) {
            for (int i = 0; i <= n - l; ++i) {
                int j = i + l - 1;
//                System.out.print(i + "" + j + " ");
                if (l == 1) {//表示subarray只有一个元素，则直接赋值
                    dp[i][j] = A[i];

                } else {
                    //递推公式
                    dp[i][j] = dp[i][j - 1] | A[j];
                    //加入结果集进行去重

                }
                ans.add(dp[i][j]);

            }

        }
        return ans.size();
    }

    public int subarrayBitwiseORs1(int[] A) {
        int n = A.length;
        Set<Integer> ans = new HashSet<>();
        Set<Integer> cur = new HashSet<>();

        for (int a : A) {
            Set<Integer> nxt = new HashSet<>();//下一个循环的dp，用来存放当前或与的值
            nxt.add(a);

            for (int b : cur) {
                nxt.add(a | b);
            }

//            nxt.add(a);
            ans.addAll(cur);
            cur = nxt;
        }


        return ans.size();
    }

    public static void main(String[] argc) {
        System.out.print(new subarrayBitwiseORs_898().subarrayBitwiseORs1(new int[]{1, 2, 4}));
    }
}
