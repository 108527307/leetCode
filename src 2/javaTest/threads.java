package javaTest;

import java.util.concurrent.*;

public class threads {
    static   int a=50;
    static class thread1 extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    static class thread2 implements Callable {
        @Override
        public Object call() throws Exception {
            return 1;
        }
    }
    static class thread3 implements Runnable{
        @Override
        public void run() {
            System.out.println(a--);
        }
    }
    //线程池
    static void threadPool(){
        ExecutorService threadPoolExecutor1=new ThreadPoolExecutor(5,10,2,TimeUnit.SECONDS,new ArrayBlockingQueue<Runnable>(10));
        ExecutorService executorService=Executors.newCachedThreadPool();
        for(int i=0;i<100;i++)
            threadPoolExecutor1.submit(new thread3());

    }
    public static void main(String[] argc) {
//        thread2 t2 = new thread2();
//        FutureTask<Integer> f = new FutureTask<Integer>(t2);
//        f.run();
//        try {
//            System.out.println(f.get());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (ExecutionException e) {
//            e.printStackTrace();
//        }
         threadPool();

    }
}

