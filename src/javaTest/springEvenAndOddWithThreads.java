package javaTest;

import java.util.concurrent.Semaphore;

/**
 * @author chy
 * @return
 * @creed: Talk is cheap,show me the code
 * @date 24/4/2020 8:40 PM
 * @desc:
 */
public class springEvenAndOddWithThreads {
    static  int i = 0;
    static Object k=new Object();

    static volatile boolean even=true;
    static volatile int p=0;
    public static void main(String[] argc) {
        //int i = 0;

        Thread a = new Thread(() -> {
            while (i < 100) {
                synchronized (k) {
                    if((i&1)!=0) continue;
                    System.out.println(i++ + "偶数");
                    k.notify();
                    try {
                        k.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread b = new Thread(() -> {
            while (i < 100) {
                synchronized (k) {
                    if((i&1)==0) continue;
                    System.out.println(i++ + "奇数");
                    k.notify();
                    try {
                        k.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
//        a.start();
//        b.start();
        //偶数
        new Thread(()->{
               while(true){
                   while (!even){};
                   if(p>100) break;
                   System.out.println("偶数:"+p++);
                   //odd=true;
                   even=false;
               }
        }).start();
        new Thread(()->{
            while (true){
                while (even){};
                if(p>100) break;
                System.out.println("奇数:"+p++);
                even=true;
            }
        }).start();

    }
}
