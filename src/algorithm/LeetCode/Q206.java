package algorithm.LeetCode;

import java.util.Stack;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class Q206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        Stack<Integer> s = new Stack<>();
        while (head != null) {
            s.push(head.val);
            head = head.next;
        }
        ListNode re = new ListNode(s.pop());
        ListNode reslut = re;
        while (!s.isEmpty()) {
            ListNode t = new ListNode(s.pop());
            re.next = t;
            re = re.next;
        }
        return re;
    }

    //反转链表头插法
    public ListNode reverseList2(ListNode head) {
        if (head == null) return null;
        ListNode result = new ListNode(0);
        ListNode tmp = null;
        while (head != null) {
            tmp = head.next;
            head.next = result.next;
            result.next = head;
            head = tmp;
        }
        return result.next;

    }
    public static void main(String[] argc){
        String a="dasd";
        System.out.println(a.indexOf('d'));
    }
}
