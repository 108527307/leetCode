package javaTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class singletonObj {

    private static volatile singletonObj c;
    private static Lock lock = new ReentrantLock();

    private singletonObj() {
    }

    public static singletonObj getInstance() {
        if (c == null) {
            //synchronized (singletonObj.class){
            lock.lock();
            try {
                if (c == null) c = new singletonObj();
            } finally {
                lock.unlock();
            }


        }
        return c;
    }
}
