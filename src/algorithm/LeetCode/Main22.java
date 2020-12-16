package algorithm.LeetCode;

import java.util.*;


public class Main22 {
    static class Nod {
        public String str;
        public List<Nod> list;

        public Nod(String x) {
            str = x;
            list = new ArrayList<>();
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        Queue<Nod> queue = new LinkedList<>();
        List<Nod> roots = new ArrayList<>();
        for (int i = 0; i < strs[0].length(); i++) {
            Nod r = new Nod(strs[0].charAt(i) + "");
            queue.add(r);
            roots.add(r);
        }
        List<Nod> list = new ArrayList<>();
        Nod root = queue.peek();
        Nod tt;
        for (int i = 1; i < strs.length; i++) {
            String temp = strs[i];

            for (int j = 0; j < temp.length(); j++) {
                list.add(new Nod(temp.charAt(j) + ""));
            }
            while (!queue.isEmpty()) {
                tt = queue.poll();
                tt.list.addAll(list);
            }
            queue.addAll(list);
            list.clear();
        }
        for (Nod f : roots)
            dfs(f, "");

    }

    public static void dfs(Nod root, String s) {
        if (root == null) return;
        if (root.list.size() == 0) {
            boolean flag = false;
            s += root.str;
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                if (set.contains(s.charAt(i))) {
                    flag = true;
                    break;
                } else set.add(s.charAt(i));
            }

            if (flag) System.out.println(s + "--circular dependency");
            else System.out.println(s);
        } else
            for (int i = 0; i < root.list.size(); i++) {
                dfs(root.list.get(i), s + root.str);
            }
    }
}

