//// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//
//import java.util.*;
//
//class ss {
//    public String s;
//    public int i;
//
//    public ss(String s, int i) {
//        this.s = s;
//        this.i = i;
//    }
//}
//
//public class Main5 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String s[] = in.nextLine().split(" ");
//        int N = Integer.parseInt(s[0]), K = Integer.parseInt(s[1]);
//        HashMap<String, Integer> map = new HashMap<>();
//        List<String> list = new ArrayList<>();
//        int i = 0;
//        while (i < N) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
//            String temp = in.nextLine();
//            if (map.containsKey(temp)) {
//                map.put(temp, map.get(temp) + 1);
//            } else {
//                list.add(temp);
//                map.put(temp, 1);
//            }
//            i++;
//        }
//        PriorityQueue<Integer> priorityQueue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
//        priorityQueue.
//        PriorityQueue<ss> priorityQueue1 = new PriorityQueue<ss>(N, (o1, o2) -> {
//            if (o1.i == o2.i) {
//                return o1.s.compareTo(o2.s);
//            } else return o1.i - o2.i;
//        });
//        PriorityQueue<ss> priorityQueue2 = new PriorityQueue<ss>(N, (o1, o2) -> {
//            if (o1.i == o2.i) {
//                return o1.s.compareTo(o2.s);
//            } else return o2.i - o1.i;
//        });
//        for (int j = 0; j < list.size(); j++) {
//            priorityQueue1.add(new ss(list.get(j), map.get(list.get(j))));
//            priorityQueue2.add(new ss(list.get(j), map.get(list.get(j))));
//        }
//        for (int p = 0; p < K; p++) {
//            ss temp = priorityQueue2.poll();
//            System.out.println(temp.s + " " + temp.i);
//        }
//        for (int p = 0; p < K; p++) {
//            ss temp = priorityQueue1.poll();
//            System.out.println(temp.s + " " + temp.i);
//        }
//
//    }
//}