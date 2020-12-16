// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;


public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String mn[] = in.nextLine().split(",");
        int M = Integer.parseInt(mn[0]), N = Integer.parseInt(mn[1]);
        String[][] nums = new String[M][N];
        int i = 0;
        while (i < M) {
            nums[i++] = in.nextLine().split("");
        }
        System.out.println(bfs(nums));

    }

    public static int bfs(String[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0)
            return 0;
        int result = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j].equals("S")) {
                    result++;
                    infect(i, j, grid);
                }
            }
        return result;
    }

    public static void infect(int i, int j, String[][] grid) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || !grid[i][j].equals("S"))
            return;
        grid[i][j] = "K";
        infect(i + 1, j, grid);
        infect(i, j + 1, grid);
        infect(i - 1, j, grid);
        infect(i, j - 1, grid);

    }
}