package algorithm;

import java.util.concurrent.*;

public class ThreadPool {
    ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 2, TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(5), (Runnable r) -> {

        System.out.println("线程" + r.hashCode() + "创建");
        Thread th = new Thread(r, "thread" + r.hashCode());
        return th;

    }, new ThreadPoolExecutor.CallerRunsPolicy()) {
        @Override
        protected void beforeExecute(Thread t, Runnable r) {
           // log.info("准备执行：" + ((ThreadDocPrintLog) r).getDocPrintLogDO().getDocName());

        }


    };

    class thread extends Thread {
        @Override
        public void run() {
            super.run();
        }
    }

    class runa implements Runnable {
        @Override
        public void run() {

        }
    }

    class task implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            return null;
        }
    }

    public static void main(String[] args) {

    }
}
