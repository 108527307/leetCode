//package algorithm;
//
//import java.util.*;
//
//public class XIECHEN2 {
//    static class bal {
//        int a, b;
//
//        public bal(int x, int y) {
//            a = x;
//            b = y;
//        }
//    }
//
//    public static void main(String[] args) {
//        Scanner cin = new Scanner(System.in);
//        int count = 0;
//        int re = 0;
//        String a = "abc";
//        String b = "abc";
//        StringBuffer sb=new StringBuffer();
//        Map<String, Integer> map = new HashMap<>();
//        map.put(a, 2);
//        System.out.println(map.get(a));
//        boolean flag = true;
//        PriorityQueue<bal> priorityQueue = new PriorityQueue<bal>((o1, o2) -> (o2.a - o2.b) - (o1.a - o1.b));
//        while (cin.hasNextInt()) {
//            int incomeOfA = cin.nextInt();
//            int incomeOfB = cin.nextInt();
//            bal a = new bal(incomeOfA, incomeOfB);
//            count++;
//            priorityQueue.add(a);
//            if (incomeOfA < 1 || incomeOfA > 1000 || incomeOfB < 1 || incomeOfB > 1000)
//                flag = false;
//        }
//        if (count % 2 != 0 || count >= 100 || !flag) {
//            System.out.println("error");
//        } else {
//            for (int i = 0; i < count / 2; i++) {
//                bal temp = priorityQueue.poll();
//
//                re += temp.a;
//            }
//            for (int i = 0; i < count / 2; i++) {
//                bal temp = priorityQueue.poll();
//                re += temp.b;
//            }
//            System.out.println(re);
//        }
//
//
//    }
//}
