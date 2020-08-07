package algorithm.jianzhiOffer;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class Q59 {
    ListNode max_list;
    int[] queue;

    int start, end;

    public Q59() {
        start = end = 0;
        queue = new int[10001];
        max_list = new ListNode(-1);
    }

    public int max_value() {
        if (end == start) return -1;
        return max_list.next.val;
    }

    public void push_back(int value) {

        if (start == end) max_list.next = new ListNode(value);
        else {
            ListNode tmp = max_list;
            while (tmp.next != null && tmp.next.val >= value) {
                tmp = tmp.next;
            }
            ListNode newNode = new ListNode(value);
            newNode.next = tmp.next;
            tmp.next = newNode;
        }
        queue[++end] = value;

    }

    public int pop_front() {
        if (end == start) return -1;
        ListNode tmp = max_list;
        while (tmp.next.val != queue[start + 1]) tmp = tmp.next;
        tmp.next = tmp.next.next;
        return queue[++start];

    }

    public void test() throws Exception {
        Q59 q = new Q59();
        String names[] = new String[]{"max_value", "pop_front", "max_value", "push_back", "max_value", "pop_front", "max_value", "pop_front", "push_back", "pop_front", "pop_front", "pop_front", "push_back", "pop_front", "max_value", "pop_front", "max_value", "push_back", "push_back", "max_value", "push_back", "max_value", "max_value", "max_value", "push_back", "pop_front", "max_value", "push_back", "max_value", "max_value", "max_value", "pop_front", "push_back", "push_back", "push_back", "push_back", "pop_front", "pop_front", "max_value", "pop_front", "pop_front", "max_value", "push_back", "push_back", "pop_front", "push_back", "push_back", "push_back", "push_back", "pop_front", "max_value", "push_back", "max_value", "max_value", "pop_front", "max_value", "max_value", "max_value", "push_back", "pop_front", "push_back", "pop_front", "max_value", "max_value", "max_value", "push_back", "pop_front", "push_back", "push_back", "push_back", "pop_front", "max_value", "pop_front", "max_value", "max_value", "max_value", "pop_front", "push_back", "pop_front", "push_back", "push_back", "pop_front", "push_back", "pop_front", "push_back", "pop_front", "pop_front", "push_back", "pop_front", "pop_front", "pop_front", "push_back", "push_back", "max_value", "push_back", "pop_front", "push_back", "push_back", "pop_front"};
        Method max_value = Q59.class.getDeclaredMethod("max_value", null);
        Method pop_front = Q59.class.getDeclaredMethod("pop_front", null);
        Method push_back = Q59.class.getDeclaredMethod("push_back", int.class);
        int[] aa = new int[]{46, 868, 525, 123, 646, 229, 871, 285, 45, 140, 837, 545, 561, 237, 633, 98, 806, 717, 186, 268, 29, 866, 239, 3, 850, 310, 674, 770, 525, 425, 720, 373, 411, 831, 765, 701};
        int i = 0;
        for (String name : names) {

            if (name.equals("max_value")) {
                System.out.print((int) max_value.invoke(q) + ",");
            }
            if (name.equals("pop_front")) {
                System.out.print((int) pop_front.invoke(q) + ",");
            }
            if (name.equals("push_back")) {
                push_back.invoke(q, aa[i++]);
                System.out.print("null" + ",");
            }

        }
        int a = 0;
    }

    public static void main(String[] argc) throws Exception {
        int[] a=new int[]{11,42,4};


        new Q59().test();

    }
}
