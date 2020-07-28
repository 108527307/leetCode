package javaTest;

import java.util.LinkedList;

public class BlockingQueue<E> {
    private LinkedList<E> list = new LinkedList<>();

    public void put(E e) {
        synchronized (this) {
            list.add(e);
            this.notify();
        }
    }

    public E get() throws InterruptedException {
        synchronized (this) {
            while (list.size() == 0) this.wait();
            return list.removeFirst();
        }
    }

    public static void main(String[] argc) throws InterruptedException {
        BlockingQueue<Integer> q = new BlockingQueue<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(q.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
        new Thread(()->{
            q.put(1);
        }).start();
        new Thread(()->{
            try {
                System.out.println(q.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


    }
}
