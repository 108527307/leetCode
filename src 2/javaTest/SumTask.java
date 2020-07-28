package javaTest;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;
import java.util.concurrent.RecursiveTask;

public class SumTask extends RecursiveTask<Integer> {
    private int left, right, threshold;
    private static final int segmentation = 3;
    private int[] src;

    SumTask(int left, int right, int[] src) {
        this.left = left;
        this.right = right;
        this.src = src;
        this.threshold = this.src.length / segmentation;
    }

    @Override
    protected Integer compute() {
        if ((right - left) < threshold) {//如果
            int count = 0;
            System.out.println("from left:" + this.left + ";to right:" + this.right);
            for (int i = left; i < right; i++)
                count += src[i];
            return count;
        } else {
            int mid = (left + right) / 2;
            SumTask left = new SumTask(this.left, mid, src);
            SumTask right = new SumTask(mid + 1, this.right, src);
            invokeAll(left, right);
            return left.join() + right.join();
        }
    }

    public static void main(String[] argc) {
        int[] array = new int[]{342, 4, 23142, 341413, 4, 2, 45, 34, 52, 3, 41, 42, 34, 2, 34, 1};
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        SumTask sumTask = new SumTask(0, array.length - 1, array);
        long start = System.currentTimeMillis();
        int sum = 0;
        for (int i : array)
            sum += i;
        long normalEnd = System.currentTimeMillis();
        Future f=forkJoinPool.submit(sumTask);

        long conCurrentEnd = System.currentTimeMillis();
        System.out.println((normalEnd - start) + ":" + (conCurrentEnd - normalEnd));
    }
}
