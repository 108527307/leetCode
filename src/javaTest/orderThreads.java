package javaTest;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class orderThreads {
    //1. join
    public static void join(){
        final Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务1");
            }
        });
        final Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(100);
                    thread1.join();//调用thread1，1执行完在执行本线程
                    System.out.println("执行任务2");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });
        final Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    Thread.sleep(100);
                    thread2.join();
                    System.out.println("执行任务3");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread3.start();

        thread2.start();
        thread1.start();
    }
    //2 在主线程中调用join
    //3 通过singleThreadPool进行顺序提交
    public static void mainJoin() throws InterruptedException {
        final Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务1");
            }
        });
        final Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {

                    System.out.println("执行任务2");


            }
        });
        final Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务3");

            }
        });
        //2
//        thread1.start();
//        thread1.join();
//        thread2.start();
//        thread2.join();
//        thread3.start();
//        thread3.join();

        //3
        ExecutorService executorService= Executors.newSingleThreadExecutor();
        executorService.submit(thread1);
        executorService.submit(thread2);
        executorService.submit(thread3);
    }
    //4 通过countDownLatch实现
    public static void countDownLatch(){
         CountDownLatch countDownLatch1=new CountDownLatch(1);//表示一个线程结束就可以进行下一个线程
         CountDownLatch countDownLatch2=new CountDownLatch(1);
        final Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                countDownLatch1.countDown();
                System.out.println("执行任务1");
            }
        });
        final Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch1.await();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务2");
                countDownLatch2.countDown();


            }
        });
        final Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    countDownLatch2.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务3");

            }
        });
        thread3.start();
        thread2.start();
        thread1.start();

    }
    public static void main(String[] argc){
        //join();
        try {
           // mainJoin();
            countDownLatch();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
