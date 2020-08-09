package algorithm;

import java.util.Stack;

public class StackWithMin {
    int size = 0;
    Stack<Integer> s;
    Stack<Integer> min;

    StackWithMin() {
        s = new Stack<>();
        min = new Stack<>();
    }

    public void push(int x) {
        s.push(x);
        if (size == 0) {
            min.push(x);
        } else {
            if (min.peek() > x)
                min.push(x);
            else min.push(min.peek());
        }
        size++;
    }

    public int pop() {
        if (size-- == 0) return -1;
        min.pop();
        return s.pop();
    }

    public int min() {
        return size == 0 ? -1 : min.peek();
    }

    public static void main(String[] args) {
        StackWithMin stackWithMin = new StackWithMin();
        stackWithMin.push(0);
        stackWithMin.push(3);
        stackWithMin.push(1);
        stackWithMin.push(0);
        stackWithMin.push(4);
        stackWithMin.push(9);
        System.out.println(stackWithMin.min());


    }
}
