package algorithm;

import algorithm.jianzhiOffer.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class Unique {
    //找数组中只出现一次的数，异或
    public int find(int[] nums) {
        if (nums.length == 0) return -1;
        if (nums.length == 1) return nums[0];
        for (int i = 1; i < nums.length; i++) {
            nums[0] ^= nums[i];
        }
        return nums[0];
    }

    //abcde 变 badce
    public ListNode ff(ListNode t) {
        ListNode pre = new ListNode(0);
        swap(t, pre);
        return pre.next;
    }

    public void swap(ListNode t, ListNode pre) {
        if (t == null || t.next == null) return;
        pre.next = t.next;
        t.next = t.next.next;
        pre.next.next = t;
        pre = t;
        t = t.next;
        swap(t, pre);
    }

    public int[] largeNum(int[] nums) {
        if (nums.length == 0) return new int[0];
        Stack<Integer> s = new Stack<>();
        int[] re = new int[nums.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Arrays.fill(re, -1);
        s.add(nums[0]);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= s.peek()) {
                s.add(nums[i]);
            } else {
                while (!s.isEmpty() && s.peek() < nums[i]) {
                    map.put(s.pop(), nums[i]);
                }
                s.add(nums[i]);

            }
        }
        for (int i = 0; i < nums.length; i++) {
            re[i] = map.getOrDefault(nums[i], -1);
        }
        return re;
    }

    public static void main(String[] args) {
//        ListNode a = new ListNode(1);
//        ListNode b = new ListNode(2);
//        ListNode c = new ListNode(3);
//        ListNode d = new ListNode(4);
//        ListNode e = new ListNode(5);
//        a.next = b;
//        b.next = c;
//        c.next = d;
//        d.next = e;
//        ListNode re = new Unique().ff(a);
//        while (re != null) {
//            System.out.println(re.val);
//            re = re.next;
//        }
        int[] re = new Unique().largeNum(new int[]{1, 3, 2, 4, 9, 5, 6});
        for (int i : re) {
            System.out.println(i);
        }

        //  System.out.println(new Unique().find(new int[]{-1, 22, 33, 22, 33, 4, 4, 5, 5}));
    }
}
