package algorithm.jianzhiOffer;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.*;
import java.util.stream.Collectors;

public class Main50 {
    public int findMinDifference(List<String> timePoints) {
        timePoints = timePoints.stream().sorted().collect(Collectors.toList());
        Map<String, Integer> map = new HashMap();
        for (int i = 0; i < timePoints.size(); i++) {
            String time = timePoints.get(i);
            String[] hhmm = time.split(":");
            int times = Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
            map.put(time, times);
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < timePoints.size() - 1; i++) {
            int dis1 = map.get(timePoints.get(i - 1)), dis2 = map.get(timePoints.get(i + 1));
            dis1 = map.get(timePoints.get(i)) - dis1;
            dis2 = dis2 - map.get(timePoints.get(i));
            dis1 = Math.min(dis1, dis2);
            min = Math.min(dis1, min);
        }

        min = Math.min(min, map.get(timePoints.get(0)) + 24 * 60 - map.get(timePoints.get(timePoints.size() - 1)));
        return min;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] str = sc.nextLine().trim().split(" ");
        int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]);
        int i = 0;
        Map<String, List<String>> map = new HashMap();
        for (int j = 0; j < n; j++) {
            List<String> list = new ArrayList<>();
            list.add(j + 1 + "");
            map.put(j + 1 + "", list);
        }
        while (i++ < m) {
            String[] strs = sc.nextLine().split(" ");
            if (strs[0].equals("C")) {
                List<String> lista = map.get(strs[1]);
                List<String> listb = map.get(strs[2]);
                listb.addAll(lista);
                lista.clear();
                map.put(strs[1], lista);
                map.put(strs[2], listb);
            } else {
                boolean flag = false;
                int dis = 0;
                for (int f = 1; f <= n; f++) {
                    List<String> temp = map.get(f + "");
                    if (temp.contains(strs[1]) && temp.contains(strs[2])) {
                        flag = true;
                        int a = 0, b = 0;
                        for (int k = 0; k < temp.size(); k++) {
                            if (temp.get(k).equals(strs[1])) a = k;
                            if (temp.get(k).equals(strs[2])) b = k;
                        }
                        dis = Math.abs(a - b) - 1;
                        break;
                    }
                }
                if (flag) {
                    System.out.println(dis);
                } else {
                    System.out.println(-1);
                }
            }
        }
    }
}