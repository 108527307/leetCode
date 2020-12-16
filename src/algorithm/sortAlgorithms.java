package algorithm;

import java.util.Arrays;

public class sortAlgorithms {
    //插入排序
    // 直接插入排序的平均复杂度为O(n²)，最坏时间复杂度：O(n²)，空间复杂度：O(1)，没有分配内存。
    public static void insertSort(int[] data) {
        int temp;
        for (int i = 1; i < data.length; i++) {//取第i个数,插入前边的有序的序列
            temp = data[i];
            int j;
            for (j = i - 1; j >= 0; j--) {//从第i-1的位置上开始比较
                if (data[j] > temp) {//若前面的数大，则往后挪一位
                    data[j + 1] = data[j];
                } else {
                    break;//否则，说明要插入的数比较大
                }
            }
            data[j + 1] = temp;//找到这个位置，插入数据
        }
    }

    //希尔排序
    //希尔排序的平均时间复杂度为O(n²)，空间复杂度O(1) 。
    public static void shellSort(int[] array) {
        int length = array.length;
        for (int i = length / 2; i > 0; i /= 2) {//序列的间隔，一直到间隔为一，这时候就只有一个子序列
            for (int j = i; j < length; j++) {//从i之后每个数字都要进行插入排序，就是插入的序列是各自不同的序列
                int temp = array[j];//里面就是直接插入算法
                int k;
                for (k = j - i; k >= 0; k -= i) {//实现各个数字插入排序到不同的序列中，直到间隔为1的时候，只有一个序列，就是完全的一个直接插入排序
                    if (temp < array[k]) {
                        array[k + i] = array[k];
                    } else {
                        break;
                    }

                }
                array[k + i] = temp;//把数字插入到位置上
            }
        }
        System.out.println(Arrays.toString(array));
    }

    //简单选择
    //：O（n^2）
    public static void selectSort(int[] array) {
        int len = array.length;
        for (int i = 0; i < len; i++) {//确定每次开始的位置

            int min = array[i];//设定开始数字为最小的值最小值
            int flag = i;
            for (int j = i + 1; j < len; j++) {//把最小值存放到min,从开始数字向后一个个和min比较，再把最小值存放到min
                if (min > array[j]) {
                    min = array[j];
                    flag = j;
                }
            }
            if (flag != i) {
                array[flag] = array[i];
                array[i] = min;
            }


        }

    }

    //堆排序
    public static int[] buildMaxHeap(int[] array, int length) {//截取数组从0到length，构建大根堆

        for (int i = (length - 2) / 2; i >= 0; i--) {//从最后一个有子结点的结点开始调整，（减一）一直调节到根节点

            adjustDownToUp(array, i, length);

        }
        return array;
    }

    private static void adjustDownToUp(int[] array, int i, int length) {//i要调整的结点
        int temp = array[i];
        //int j = i*2+1;//取得左孩子
        for (int j = i * 2 + 1; j < length; j = j * 2 + 1) {//从该节点一直调节到叶子结点，因为上层调节改变之后，会影响下层结构，所以一直循环到叶子结点。
            if (j + 1 < length && array[j] < array[j + 1]) {//有又孩子，且右孩子数值更大
                j++;//取更大结点的索引
            }
            if (temp < array[j]) {//根节点比最大的值小
                array[i] = array[j];//调整根节点的值为最大值
                i = j;//把空余的位置给i
                //array[j] = temp;
            }
        }
        array[i] = temp;//找到最后空余的位置，填上向下调整的值

    }

    public static void heapSort(int[] array) {
        int len = array.length;
        int temp;
        for (int i = len; i > 0; i--) {
            array = buildMaxHeap(array, i);
            temp = array[0];
            array[0] = array[i - 1];
            array[i - 1] = temp;
        }
        System.out.println(Arrays.toString(array));

    }

    //冒泡排序
    //冒泡排序的时间复杂度为O(n^2),空间复杂度为O(1),它是一种稳定的排序算法。
    public static void bubbleSort(int[] array) {
        for (int i = 0; i < array.length; i++) {//第i冒泡,一次冒泡，会确定一个最大值
            for (int j = 0; j < array.length - i - 1; j++) {//从头一直到已经确定的位置前，两两比较
                int temp = array[j];
                if (array[j] > array[j + 1]) {
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    //快排
    //快排的时间复杂度达到了 O(n²)，但是在大多数情况下都比平均时间复杂度为 O(n logn) 的排序算法表现要更好。
    public static void quickSort(int[] array, int low, int high) {
        if (low >= high) return;
        int left = low;
        int right = high;
        int pivot = array[left];//设立基准点
        while (left < right) {
            while (left < right && array[right] >= pivot)//从右向左，大数位置不变
                right--;
            array[left] = array[right];//把小数移到左边

            while (left < right && array[left] <= pivot) //从左向右，小数位置不变
                left++;
            array[right] = array[left];//把大数移到右边

        }

        array[left] = pivot;
        quickSort(array, low, left - 1);
        quickSort(array, left + 1, high);

    }

    public static void quickSortTemp(double[] array, double pivot) {
        int left = 0;
        int right = array.length - 1;
        while (left < right) {
            while (left < right && array[right] <= pivot)
                right--;
            array[left] = array[right];

            while (left < right && array[left] >= pivot)
                left++;
            array[right] = array[left];

        }

        array[left] = pivot;

    }

    //归并排序
    //O(nlog2n)
    public static int[] mergeSort(int[] array, int low, int high) {
        if (low < high) {
            int mid = (low + high) / 2;
            mergeSort(array, low, mid);
            mergeSort(array, mid + 1, high);
            merge(array, low, mid, high);//归并
        }
        return array;
    }

    private static void merge(int[] array, int low, int mid, int high) {
        int i = low;//指针，前一个序列的头指针
        int j = mid + 1;//指针，后一个序列的头指针
        int[] temp = new int[high - low + 1];
        int k = 0;
        while (i <= mid && j <= high) {
            if (array[i] < array[j]) {//从头比较两个序列，小的放入临时数组temp
                temp[k++] = array[i++];//前一个序列指针后移一位
            } else {
                temp[k++] = array[j++];//后一个序列指针后移一位
            }

        }
        //最后只会剩下一组序列
        while (i <= mid) {
            temp[k++] = array[i++];//把前一个指针剩余的数字放入临时数组
        }
        while (j <= high) {
            temp[k++] = array[j++];//把后一个指针剩余的数字放入临时数组
        }

        for (int m = 0; m < high - low + 1; m++) {
            array[low + m] = temp[m];
        }

    }

    public static void main(String[] args) {
        double[] a = {4, 3, 5, 3, 6, 4, 89, 9, 8};
        quickSortTemp(a, 6);
        int ae = 0;
    }

}
