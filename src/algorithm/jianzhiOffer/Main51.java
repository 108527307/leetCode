package algorithm.jianzhiOffer;//package algorithm.jianzhiOffer;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.Scanner;

public class Main51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int i = 0;
        while (i < T) {
            i++;
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
            String[] numss = sc.nextLine().split(" ");
            String[] xifens = sc.nextLine().split(" ");
            int[] nums = new int[numss.length];
            int[] xifen = new int[xifens.length];
            for (int u = 0; u < numss.length; u++)
                nums[u] = Integer.parseInt(numss[u]);
            for (int u = 0; u < xifens.length; u++)
                xifen[u] = Integer.parseInt(xifens[u]);

            Arrays.sort(nums);
            Arrays.sort(xifen);
            int[] re = new int[n];
            int index = xifen.length - 1;
            for (int f = nums.length - 1; f >= 0;f-- ) {
                int k = index;
                while (k >= 0 && xifen[k] >= (nums[f])) k--;
                index=k;
                re[f] = xifen.length - k - 1;

            }

            for (int d : re)
                System.out.println(d + " ");

        }
    }
}