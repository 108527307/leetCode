//package algorithm.jianzhiOffer;// 本题为考试多行输入输出规范示例，无需提交，不计分。
//
//import com.sun.xml.internal.xsom.impl.scd.Step;
//
//import java.util.*;
//
//public class Main26 {
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        String str = sc.nextLine();
//        Stack<String> s = new Stack<>();
//        for (int j = 0; j < str.length(); j++) {
//            char temp=str.charAt()
//        }
//        int i = 0;
//        Set<String> set = new HashSet<>();
//        Map<String, List<Integer>> map = new HashMap<>();
//        for (int j = 0; j < str.length(); j++) {
//            if (str.charAt(j) == 'a' || str.charAt(j) == 'b' || str.charAt(j) == 'c' || str.charAt(j) == 'x' || str.charAt(j) == 'y' || str.charAt(j) == 'z') {
//
//                if (map.containsKey(str.charAt(j))) {
//                    List<Integer> t = map.get(str.charAt(j));
//                    t.add(j);
//                } else {
//                    set.add(str.charAt(j) + "");
//                    List<Integer> t = new ArrayList<>();
//                    map.put(str.charAt(j) + "", t);
//                }
//            }
//        }
//        Iterator iterator = set.iterator();
//        while (iterator.hasNext()) {
//            List<Integer> list = map.getOrDefault(iterator.next(), new ArrayList<>());
//            if (list.size() % 2 == 0) continue;
//            else {
//
//            }
//        }
//    }
//}