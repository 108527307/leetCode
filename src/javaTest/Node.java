package javaTest;

/**
 * 节点类
 * @author HP
 *
 */
public class Node {
    private Object value;
    private Object key;
    private Node next;

    /**
     * 空节点
     */
    public Node() {
    }

    /**
     * 值为key value的节点
     * @param data
     */
    public Node(Object key,Object value) {
        this.key = key;
        this.value = value;
    }


    //接下来就是一些数据和节点的set，get
    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Object getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

}

