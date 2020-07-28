package javaTest;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.concurrent.*;

public class Lru<K, V> extends LinkedHashMap<K, V> {
    private static int MAX_ENTRIES = 3;//最大缓存

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > MAX_ENTRIES;//当当前数据量大于max是，进行remove最近最久未使用数据
    }

    Lru() {
        super(MAX_ENTRIES, 0.75f, true);//初始化linkedhashMap，输入lru此时的最长缓存长度、负载因子（hash表中元素个数/hash表长度），acessOrder（true为lru，默认false）

    }



    public static void main(String[] argc) {
        ExecutorService pool = Executors.newCachedThreadPool();
        CountDownLatch latch = new CountDownLatch(100);
        for (int i = 0; i < 100; i++) {
            pool.execute(new countDownLatchExample(latch));
        }


    }
}
class countDownLatchExample implements Runnable {
    private CountDownLatch latch;

    countDownLatchExample(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            synchronized (latch) {
                latch.countDown();

                System.out.println("thread numbers:" + latch.getCount());
            }
                latch.await();
                System.out.println("concurrency thread:" + (100 - latch.getCount()));

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}