package javaTest;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {
    private static BlockingQueue<String> queue=new ArrayBlockingQueue<String>(5);
    private static class Producer extends Thread{
        Producer(String x){
            Thread.currentThread().setName(x);
        }
        @Override
        public void run() {
            try{
                synchronized (queue) {
                    queue.put("商品" + Thread.currentThread().getName());
                    System.out.println("商品" + Thread.currentThread().getName() + "已被生产出");
                    System.out.println("queue 当前有" + queue.size() + "个商品");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                //System.out.println("生产者"+Thread.currentThread().getName());
            }
        }
    }
    private static class Consumer extends Thread{
        @Override
        public void run() {
            try{
                synchronized (queue) {
                    System.out.println(queue.take() + "被消耗");
                    System.out.println("queue 当前有" + queue.size() + "个商品");
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                //System.out.println("consume..");
            }
        }
    }
    public static void main(String[] argc){
            for(int i=0;i<2;i++)
                new Producer(i+"").start();
            for(int i=0;i<3;i++)
                new Consumer().start();
            for(int i=2;i<10;i++)
                new Producer(i+"").start();
            for(int i=0;i<5;i++)
                new Consumer().start();

    }

}
