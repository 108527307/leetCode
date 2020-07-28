package algorithm.jianzhiOffer;

import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Q35 {
    /**
     * 使用hash的非递归方式，首先复制节点，并放入hash表。然后在逐个链接next和random
     *
     * @param head
     * @return
     */
    public Node copyRandomList(Node head) {
        if (head == null) return head;
        Map<Node, Node> nodes = new HashMap<>();
        //复制节点
        for (Node cur = head; cur != null; cur = cur.next) {
            nodes.put(cur, new Node(cur.val));
        }
        //安上next和random
        for (Node cur = head; cur != null; cur = cur.next) {
            Node newNode = nodes.get(cur);
            newNode.next = map.get(cur.next);
            newNode.random = map.get(cur.random);
        }

        return map.get(head);
    }

    Map<Node, Node> map = new HashMap<>();

    /**
     * 使用hash的递归方式。
     * 同样的，这里分成了next和random两个递归分支。
     * 递归出口就是hash中已经发现了复制好的节点或者head==null
     * 递归式就是若没有复制好，则进行复制，复制时分别递归进入head的next和random进行复制。
     *
     * @param head
     * @return
     */
    public Node copyRandomList1(Node head) {
        if (head == null) return null;
        if (map.containsKey(head)) return map.get(head);
        Node newNode = new Node(head.val);
        map.put(head, newNode);
        newNode.next = copyRandomList1(head.next);
        newNode.random = copyRandomList1(head.random);
        return newNode;
    }

    /**
     * 不使用hash来存放新节点的方式，其实就是换了一个存放新节点的方式。
     * hash因为他键值对的存取好处，可以快速定位到每个老节点对应的新节点。
     * 若不使用hash，那该如何绑定新老节点呢，我们可以通过将新节点放在老节点后面的方式来进行绑定。
     *
     * @param head
     * @return
     */
    public Node copyRandomList3(Node head) {
        if (head == null) return null;
        //将复制的节点放在原来每个节点后面
        for (Node cur = head, copy = null; cur != null; cur = cur.next.next) {
            copy = new Node(cur.val);
            copy.next = cur.next;
            cur.next = copy;
        }

        for (Node cur = head; cur != null; cur = cur.next.next) {
            if(cur.random==null) continue;
            cur.next.random = cur.random.next;
        }
        Node copyHead = head.next;
        Node cur = head;
        Node curCopy = head.next;
        while (cur != null) {
            cur.next = cur.next.next;
            cur = cur.next;
            if (curCopy.next != null) {
                curCopy.next = curCopy.next.next;
                curCopy = curCopy.next;
            }
        }
        //cur=temp;

        return copyHead;
    }
}
