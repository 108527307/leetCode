//import java.util.concurrent.locks.ReentrantReadWriteLock;
//
//public class Service {
//
//    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
//
//    public void read() {
//        try {
//            try {
//                lock.readLock().lock();
//                System.out.println("获取读锁" + Thread.currentThread().getName()
//                        + " " +System.currentTimeMillis());
//                Thread.sleep(10000);
//            } finally {
//                lock.readLock().unlock();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public void write() {
//        try {
//            try {
//                lock.writeLock().lock();
//                System.out.println("获取写锁" + Thread.currentThread().getName()
//                        + " " +System.currentTimeMillis());
//                Thread.sleep(10000);
//            } finally {
//                lock.writeLock().unlock();
//            }
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//    public static void main(String[] args)throws InterruptedException {
//        Service service = new Service();
//        ThreadA a = new ThreadA(service);
//        a.setName("A");
//        a.start();
//        Thread.sleep(1000);
//        ThreadB b = new ThreadB(service);
//        b.setName("B");
//        b.start();
//    }
//}
//
//
