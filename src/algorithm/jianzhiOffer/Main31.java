package algorithm.jianzhiOffer;

import java.util.*;

public class Main31 {
    public static void main(String[] argc) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());

        int i = 0;
        while (i++ < T) {
            String[] str = sc.nextLine().split(" ");
            int n = Integer.parseInt(str[0]), m = Integer.parseInt(str[1]), k = Integer.parseInt(str[2]);
            int j = 0;
            Set<String> a = new HashSet();
            Map<String, List<String>> map = new HashMap<>();
            int sum = 0;
            while (j++ < m) {
                String[] strs = sc.nextLine().split(" ");
                a.add(strs[0]);
                a.add(strs[1]);
                if (map.containsKey(strs[0])) {
                    List<String> list = map.get(strs[0]);
                    list.add(strs[1]);
                    map.put(strs[0], list);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(strs[1]);
                    map.put(strs[0], list);
                }
            }

        }
    }

    public static void dfs(Map<String, List<String>> map, String index) {

    }

}
