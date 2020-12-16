package algorithm;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class PDD2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] s = in.nextLine().split(" ");
        int N = Integer.parseInt(s[0]), M = Integer.parseInt(s[1]);
        int k = 0;
        int x = 0, y = 0;
        String[][] nums = new String[N][M];

        while (k < N) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] ss = in.nextLine().split("");
            nums[k] = ss;
            for (int i = 0; i < ss.length; i++) {
                if (ss[i].equals("T")) {
                    x = k;
                    y = i;
                }
            }
            k++;
        }
        dfs(nums, x, y, 0);
        Iterator it = sets.iterator();
        while (it.hasNext()) {
            String ss = (String) it.next();
            String[] ww = ss.split(" ");
            int i = set.get(ss);
            p.add(new ee(Integer.parseInt(ww[0]), Integer.parseInt(ww[1]), i));
        }
        if (min==Integer.MAX_VALUE){
            System.out.println(-1);
        }else {
            System.out.println(min);
            while (!p.isEmpty() && p.peek().h == min) {
                System.out.print(p.peek().i + " " + p.poll().j + " ");
            }
        }
    }

    public static HashMap<String, Integer> set = new HashMap<>();
    public static HashSet<String> sets = new HashSet<>();
    public static PriorityQueue<ee> p = new PriorityQueue<ee>((o1, o2) -> {
        if (o1.h == o2.h) {
            if (o1.i == o2.i) {
                return o1.j - o2.j;
            } else return o1.i - o2.i;
        } else return o1.h - o2.h;
    });
    public static int min = Integer.MAX_VALUE;

    static class ee {
        public int i, j, h;

        public ee(int i, int j, int h) {
            this.i = i;
            this.j = j;
            this.h = h;
        }
    }

    public static void dfs(String[][] nums, int i, int j, int count) {
        if (i < 0 || i >= nums.length || j < 0 || j >= nums[0].length) return;
        if (nums[i][j].equals("1") || nums[i][j].equals("W")) return;
        if (nums[i][j].equals("X")) {
            min = min > count  ? count  : min;
            sets.add(i + " " + j);
            if (set.containsKey(i + " " + j)) {
                int s = set.get(i + " " + j);
                set.put(i + " " + j, Math.min(s, count ));
            } else {
                set.put(i + " " + j, count );
            }
            //p.add(new ee(i, j, count + 1));
            return;
        }

        nums[i][j] = "W";
        dfs(nums, i + 1, j, count + 1);
        dfs(nums, i, j + 1, count + 1);
        dfs(nums, i - 1, j, count + 1);
        dfs(nums, i, j - 1, count + 1);
        nums[i][j] = "0";

    }
}