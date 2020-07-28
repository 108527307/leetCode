package javaTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.Semaphore;

public class providerAndConsumer {
    static  private final Queue<String> queue=new LinkedList<>();
    static private Semaphore premit=new Semaphore(10);//控制queue中同时最多10个商品
    static private Semaphore remain=new Semaphore(0);//表示当前的商品数
    static class Provider extends Thread{
        Provider(){

        }
        @Override
        public void run() {
            try {
                while(true) {
                    Thread.sleep(100);
                    premit.acquire();//请求进行生产
                    queue.add("商品");
                    System.out.println("生产完");
                    remain.release();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class Consumer extends Thread{
        @Override
        public void run() {
            try{
                while(true) {
                    Thread.sleep(500);
                    remain.acquire();//请求商品
                    queue.poll();
                    System.out.println("消费了一个商品");
                    premit.release();
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] argc){
        providerAndConsumer.Provider provider= new Provider();
        providerAndConsumer.Consumer consumer=new Consumer();
        int i=0;

            provider.start();
            consumer.start();


    }
}
