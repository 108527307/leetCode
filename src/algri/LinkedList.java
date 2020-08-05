package algri;

import com.sun.javafx.collections.ListListenerHelper;

class Node {
    int val;
    Node pre;
    Node next;

    public Node(int x) {
        this.val = x;
        pre = null;
        next = null;
    }
}

public class LinkedList {
    public static boolean isLoop(Node root) {
        Node fast = root, slow = root;
        while (fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = new Node(6);
        Node n7 = new Node(7);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;
        n7.next = n3;
        System.out.println(isLoop(n1));


    }
}
