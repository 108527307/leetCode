package java;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LRUImplementedByLinkedHashMap<K, V> extends LinkedHashMap<K, V> {
    //LRUImplementedByLinkedHashMap 最近最久未使用 置换算法
    //一般采用hashmap和链表的方式进行实现 LinkedHashMap 进行实现 LinkedHashMap本身就是可以作为队列进行使用的
    //LinkedHashMap底层是用hashMap加双链表实现
    private final int maxCapacity;//最大容量
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;//装在因子，hashmapsize和表长比值
    private final Lock lock = new ReentrantLock();

    public LRUImplementedByLinkedHashMap(int maxCapacity) {
        super(maxCapacity, DEFAULT_LOAD_FACTOR);
        this.maxCapacity = maxCapacity;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        return size() > maxCapacity;//当size超多最大允许的容量时
    }

    @Override
    public boolean containsKey(Object key) {
        try {
            lock.lock();
            return super.containsKey(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V get(Object key) {
        try {
            lock.lock();
            return super.get(key);
        } finally {
            lock.unlock();
        }
    }

    @Override
    public V put(K key, V value) {
        try {
            lock.lock();
            return super.put(key, value);
        } finally {
            lock.unlock();
        }
    }

    public int size() {
        try {
            lock.lock();
            return super.size();
        } finally {
            lock.unlock();
        }
    }

    public void clear() {
        try {
            lock.lock();
            super.clear();
        } finally {
            lock.unlock();
        }
    }

    public Collection<Map.Entry<K, V>> getAll() {
        try {
            lock.lock();
            return new ArrayList<Map.Entry<K, V>>(super.entrySet());
        } finally {
            lock.unlock();
        }
    }
}
