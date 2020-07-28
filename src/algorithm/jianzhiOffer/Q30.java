package algorithm.jianzhiOffer;

import java.util.Stack;

public class Q30 {
    /** initialize your data structure here. */
    Stack<Integer> s1,s2;
    public Q30() {
        s1=new Stack<>();
        s2=new Stack<>();
    }

    public void push(int x) {
        s1.push(x);
        if(s2.isEmpty()||x<=s2.peek())
            s2.push(x);
        else s2.push(s2.peek());
    }

    public void pop() {
        s2.pop();
        s1.pop();
    }

    public int top() {
        return s1.peek();
    }

    public int min() {
        return s2.peek();
    }
    public static void main(String[] args){

    }
}
