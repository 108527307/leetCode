package javaTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class singletonObj {

    private static volatile singletonObj c;
    //private static Lock lock = new ReentrantLock();

    private singletonObj() {
    }

    public static singletonObj getInstance() {


        if (c == null) {
            synchronized (singletonObj.class) {
                //lock.lock();
                //try {
                if (c == null) c = new singletonObj();
                // } finally {
                // lock.unlock();
                // }


            }

        }
        return c;

    }

    public int connect(int m, int n) {
        // write code here
        int sum = 1;

        for (int i = 2; i <= n; i++) {
            // sum+=c(m,i);
        }
        return c(m, n);
    }

    public static int c(int m, int n) {
        if (m == 0 || n == 1) return 1;
        if (n > m) return c(m, m);
        else return c(m, n - 1) + c(m - n, n);
    }

    public static void main(String[] args) {
        System.out.println(c(5,3));
    }
}
