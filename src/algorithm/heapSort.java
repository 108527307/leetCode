package algorithm;

import java.util.Arrays;

public class heapSort {
    private int[] heap;
    private int size;

    private void swap(int i, int j) {
        heap[i] = heap[i] + heap[j] - (heap[j] = heap[i]);
    }

    public int getFirstVal() {
        return size > 0 ? heap[0] : 0;
    }

    public void setFirstVal(int val) {
        heap[0] = val;
    }

    public int del() {
        return size > 0 ? heap[--size] : 0;
    }

    //结点调整函数，每个结点都需要和它的两个子节点进行比较，根据需要进行交换，将最小的或者最大的放到上面
    public void heapify(int i, boolean isMin) {
        int leftVal = (i << 1) + 1 < size ? heap[(i << 1) + 1] : isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        int rightVal = (i << 1) + 2 < size ? heap[(i << 1) + 2] : isMin ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        if (isMin) {
            if (leftVal <= rightVal && leftVal < heap[i]) {
                swap(i, (i << 1) + 1);
                heapify((i << 1) + 1, true);
            } else if (rightVal <= leftVal && rightVal < heap[i]) {
                swap(i, (i << 1) + 2);
                heapify((i << 1) + 2, true);
            }
        } else {
            if (leftVal >= rightVal && leftVal > heap[i]) {
                swap(i, (i << 1) + 1);
                heapify((i << 1) + 1, false);
            } else if (rightVal >= leftVal && rightVal > heap[i]) {
                swap(i, (i << 1) + 2);
                heapify((i << 1) + 2, false);
            }
        }

    }

    public void buildHeap(int[] array, boolean isMin) {
        this.size = array.length;
        this.heap = array;
        for (int i = (size >> 1) - 1; i >= 0; i--) {//从最后一个非叶结点开始向上进行调整
            heapify(i, isMin);
        }
    }

    public int[] heapSort(int[] array, boolean isAsc) {
        buildHeap(array, isAsc);//首先建堆
        int[] result = new int[array.length];
        for (int i = 0; i < array.length; i++) {//对array进行排序，每次取堆顶，然后进行将对顶设置为最后的叶子结点，然后从对顶开始进行一次重新调整
            result[i] = getFirstVal();
            setFirstVal(del());
            heapify(0, isAsc);
        }
        return result;
    }

    public static void main(String[] args) {
        //Arrays.asList(new heapSort().heapSort(new int[]{2, 3, 5, 2, 2, 5, 3, 1, 3, 5, 3, 2, 4}, true)).stream().forEach(s -> System.out.println(s));
        //System.out.println();
        for (int i : new heapSort().heapSort(new int[]{2, 3, 5, 2, 2, 5, 3, 1, 3, 5, 3, 2, 4}, false)
        ) {
            System.out.println(i);

        }
    }
}
