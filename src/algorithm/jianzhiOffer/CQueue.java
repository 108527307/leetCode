package algorithm.jianzhiOffer;

import java.util.Stack;

public class CQueue {
    Stack<Integer> s1;
    Stack<Integer> s2;

    public CQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();

    }

    public void appendTail(int value) {
        this.s1.push(value);
    }

    public int deleteHead() {
        if (this.s1.isEmpty())
            return -1;
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        int re = s2.pop();
        while (!s2.isEmpty())
            s1.push(s2.pop());
        int q=2%(1000000007);
        return re;
    }

}
