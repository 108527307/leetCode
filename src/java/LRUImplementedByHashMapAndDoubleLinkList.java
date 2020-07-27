package java;

import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Node {
    int val;
    int key;
    Node pre, next;

    public Node(int key, int val) {
        this.val = val;
    }
}

public class LRUImplementedByHashMapAndDoubleLinkList {
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();
    Node head = null, end = null;
    private Lock lock = new ReentrantLock();

    public LRUImplementedByHashMapAndDoubleLinkList(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        try {
            lock.lock();
            if (map.containsKey(key)) {
                Node n = map.get(key);
                remove(n);
                setHead(n);
                return n.val;
            }
        } finally {
            lock.unlock();
        }
        return -1;
    }

    public void remove(Node n) {
        try {
            lock.lock();
            if (n.pre != null) {
                n.pre.next = n.next;
            } else {
                head = n.next;
            }
            if (n.next != null) {
                n.next.pre = n.pre;
            } else {
                end = n.pre;
            }

        } finally {
            lock.unlock();
        }
    }

    public void setHead(Node n) {
        try {
            lock.lock();
            n.next = head;
            n.pre = null;
            if (head != null)
                head.pre = n;
            head = n;
            if (end == null)
                end = n;
        } finally {
            lock.unlock();
        }
    }

    public void set(int key, int val) {
        try {
            lock.lock();
            if (map.containsKey(key)) {
                Node old = map.get(key);
                old.val = val;
                remove(old);
                setHead(old);
            } else {
                Node created = new Node(key, val);
                if (map.size() >= capacity) {
                    map.remove(end.key);
                    remove(end);
                    setHead(created);
                } else
                    setHead(created);
                map.put(key, created);
            }

        } finally {
            lock.unlock();
        }

    }
}
