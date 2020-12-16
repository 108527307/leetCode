package algorithm;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main30 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] nm = in.nextLine().split(" ");
        int N = Integer.parseInt(nm[0]), M = Integer.parseInt(nm[1]);
        String[] nums = in.nextLine().split(" ");
        while (M-- > 0) {
            nums = xi(nums, N);
        }
        int i = 0;
    }

    public static String[] xi(String[] nums, int N) {
        int mid = N / 2 - 1;
        int i = 0, k = 0;
        String[] temp = new String[N];
        while (i <= mid) {
            temp[k++] = nums[mid + i + 1];
            temp[k++] = nums[i++];
        }
        if (N % 2 != 0) temp[k] = nums[N - 1];
        return temp;
    }
}