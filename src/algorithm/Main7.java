//package algorithm;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
//
//import java.util.*;
//
//class Nod {
//    public int index, val;
//
//    public Nod(int i, int val) {
//        index = i;
//        this.val = val;
//    }
//}
//
//public class Main7 {
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = Integer.parseInt(in.nextLine());
//        String[] vals1 = in.nextLine().split(" ");
//        int m = Integer.parseInt(in.nextLine());
//        String[] vals2 = in.nextLine().split(" ");
//        HashMap<Integer, Integer> map = new HashMap<>();
//        Set<Integer> s=new HashSet<>();
//        for (int i = 0; i < n; i++) {
//            int temp = Integer.parseInt(vals1[i]);
//            s.add(temp);
//            if (map.containsKey(temp)) {
//
//                map.put(temp, map.get(temp) + 1);
//            } else map.put(temp, 1);
//        }
//        for (int i = 0; i < m; i++) {
//            int temp = Integer.parseInt(vals2[i]);
//            s.add(temp);
//            if (map.containsKey(temp)) {
//
//                map.put(temp, map.get(temp) + 1);
//            } else map.put(temp, 1);
//        }
//        Iterator iterator=s.iterator();
//        while (iterator.hasNext()){
//            if (map.get(iterator.next())>1){
//                System.out.print();
//            }
//        }
//
//    }
//}