package algorithm.jianzhiOffer;

import java.util.*;

public class Main10 {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // n个人
        int m = sc.nextInt(); // m个团队
        if (m == 0) {
            System.out.print(1);
            return;
        }
        Map<Integer, ArrayList<Integer>> map = new HashMap<>();
        List<ArrayList<Integer>> groups = new ArrayList<>();
        Set<Integer> notNotifiedSet = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            map.put(i, new ArrayList<>());
            if (i != 0)
                notNotifiedSet.add(i);
        }
        for (int i = 0; i < m; ++i) {
            ArrayList<Integer> cur = new ArrayList<>();
            int x = sc.nextInt();
            for (int j = 0; j < x; ++j) {
                int no = sc.nextInt();
                cur.add(no);
                ArrayList<Integer> nogs = map.get(no);
                nogs.add(i);
                map.put(no, nogs);
            }
            groups.add(cur);
        }
        Set<Integer> set = new HashSet<>();
        Deque<Integer> stack = new LinkedList<>();
        stack.addFirst(0);
        while (!stack.isEmpty()) {
            int cur = stack.removeFirst();
            ArrayList<Integer> curGroupNums = map.get(cur);
            for (Integer ii : curGroupNums) {
                ArrayList<Integer> curGroupMembers = groups.get(ii);
                for (Integer iii : curGroupMembers) {
                    set.add(iii);
                    if (notNotifiedSet.contains(iii)) {
                        stack.addFirst(iii);
                        notNotifiedSet.remove(iii);
                    }
                }
            }
        }
        System.out.print(set.size());
    }

}