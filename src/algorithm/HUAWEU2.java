package algorithm;

import java.util.List;

class ListNode1 {
    int val;
    ListNode1 next;

    public ListNode1(int i) {
        val = i;
        next = null;
    }
}

public class HUAWEU2 {
    public static ListNode1 mergeList(ListNode1 l1, ListNode1 l2) {
        ListNode1 p1 = l1, p2 = l2;
        ListNode1 temp = new ListNode1(-1);
        ListNode1 worker = temp;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                temp.next = p1;
                p1 = p1.next;
            } else {
                temp.next = p2;
                p2 = p2.next;
            }
            worker = worker.next;
        }
        if (p1 != null) {
            worker.next = p1;
        }
        if (p2 != null) {
            worker.next = p2;
        }
        return temp.next;
    }

    public static void merge(ListNode1 root1, ListNode1 root2, ListNode1 re) {
        if (root1 != null && root2 != null) {
            if (root1.val < root2.val) {
                re.next = root1;
                merge(root1.next, root2, re.next);
            } else {
                re.next = root2;
                merge(root1, root2.next, re.next);
            }

        } else {
            if (root1 != null) {
                re.next = root1;
            }
            if (root2 != null) {
                re.next = root2;
            }
        }
    }

    public static void main(String[] args) {

    }
}
