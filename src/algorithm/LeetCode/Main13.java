package algorithm.LeetCode;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class Main13 {
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] st = sc.nextLine().split(" ");
        int n = Integer.parseInt(st[0]), m = Integer.parseInt(st[1]);
        List<Set<String>> list = new ArrayList<>();
        boolean[] visited = new boolean[100001];
        List<String> temp = new ArrayList<>();
        int index = 0;
        for (int i = 0; i < m; i++) {
            String[] ss = sc.nextLine().split(" ");
            Set<String> set = new HashSet<>();
            for (int j = 1; j < ss.length; j++) {
                if (ss[j].equals("0")) index = i;
                set.add(ss[j]);
            }
            list.add(set);

        }
        dfs(list, index, visited);
        System.out.println(count);

    }

    public static void dfs(List<Set<String>> list, int index, boolean[] vi) {
        Set<String> set = list.get(index);
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            int ii = Integer.parseInt((String) iterator.next());
            if (!vi[ii]) {
                count++;
                vi[ii] = true;
                for (int k = 0; k < list.size(); k++) {
                    if (list.get(k).contains(ii + "")) {
                        dfs(list, k, vi);
                    }
                }
            }
        }
    }

}