package algorithm;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.sql.Time;
import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class p {
    public String id;
    public List<String> ids;

    public p(String x, List<String> list) {
        id = x;
        ids = list;
    }
}

public class Main27 {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(10,20,10, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(10),new ThreadPoolExecutor.AbortPolicy());

        Scanner sc = new Scanner(System.in);
        String[] nan = sc.nextLine().split(" ");
        String[] nv = sc.nextLine().split(" ");
        PriorityQueue<p> ps = new PriorityQueue<p>(Comparator.comparingInt(o -> o.ids.size()));
        int n = Integer.parseInt(sc.nextLine());
        Set<String> vi = new HashSet<>();
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] ids = sc.nextLine().split(" ");
            if (map.containsKey(ids[0])) {
                List temp = map.get(ids[0]);
                temp.add(ids[1]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(ids[1]);
                map.put(ids[0], list);
            }

            if (map.containsKey(ids[1])) {
                List temp = map.get(ids[1]);
                temp.add(ids[0]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(ids[0]);
                map.put(ids[1], list);
            }
        }
        for (String i : nan) {
            p pp = new p(i, map.get(i));
            ps.add(pp);
        }
        for (String i : nv) {
            p pp = new p(i, map.get(i));
            ps.add(pp);
        }
        int count = 0;
        while (!ps.isEmpty()) {
            p temp = ps.peek();
            if (vi.contains(temp.id)) continue;
            vi.add(temp.id);
            int min = Integer.MAX_VALUE;
            String minIndex = "";
            for (int i = 0; i < temp.ids.size(); i++) {
                String ss = temp.ids.get(i);
                if (map.get(ss).size() < min && !vi.contains(ss)) {
                    min = map.get(ss).size();
                    minIndex = ss;
                }
            }
            if (min != Integer.MAX_VALUE) {
                //vi.remove(temp.id);
                count++;
                ps.poll();
                System.out.println(temp.id + "-" + minIndex);
                vi.add(minIndex);
            } else {
                vi.remove(temp.id);
            }

        }
        System.out.println(count+Math.random()%1);
    }
}