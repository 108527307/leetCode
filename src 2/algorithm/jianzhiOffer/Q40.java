package algorithm.jianzhiOffer;

public class Q40 {
    //第一种大根堆

    /**
     * 首先将前k个元素生成一个大根堆，然后对后面的元素进行处理，将堆顶和每个元素进行比较，若比堆顶小，则将其替换给堆顶。然后进行向上进行整理。
     * 这样，整理完了之后这个大根堆就存放着前k小个的元素了。
     * 关于大根对的建立和调整函数的理解看注释。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers(int[] arr, int k) {
        int len = arr.length;
        if (len == 0) return arr;
        if (k == len) return arr;
        if (k == 0) return new int[0];
        int[] heap = new int[k];
        //大根堆就是一个完全二叉树的序列化存储,存放在数组中，heap[0]为堆顶，heap[heap.length-1]为堆低元素，
        // 且根据完全二叉树的序列化特点，满足：
        //                 heap[i]的双亲结点为heap[(i-1)/2],其左右孩子分别为heap[i*2+1]、heap[i*2+2]
        //首先塞入前k个元素，然后进行建堆
        for (int i = 0; i < k; i++)
            heap[i] = arr[i];
        buildHeap(heap);
        //对后续元素进行扫描
        for (int i = k; i < len; i++) {
            if (arr[i] < heap[0]) {//若比堆中的最大元素还小，说明此元素肯定属于前k小
                heap[0] = arr[i];
                heapify(heap, 0);
            }
        }
        return heap;
    }

    void buildHeap(int[] heap) {
        //首先建堆时，需要从叶节点向上进行调整，所以设最后一个元素为foot，找到foot的双亲结点，然后不断向上进行调整。
        int foot = heap.length - 1;
        int start = (foot - 1) >> 1;
        while (start >= 0)
            heapify(heap, start--);
    }

    /**
     * 堆的调整操作，其实就是将当前结点c和他的左右孩子进行比较，若是大根堆则将左右孩子和c中的最大值和c进行交换，若c本身就是最大值则不需要操作。
     * 若是小根堆则相反，取最小值。
     * @param num
     * @param c
     */
    void heapify(int[] num, int c) {
        int len = num.length;
        if (c >= len) return;
        //计算它的左右孩子下标
        int left = (c << 1) + 1, right = (c + 1) << 1;
        int max = c;
        if (left < len && num[left] > num[max])
            max = left;
        if (right < len && num[right] > num[max])
            max = right;
        if (max != c) {//若c不是较大值，则进行交换，将较大值放到c的位置，然后沿着孩子将交换下来的较小值继续向下比较。
            swap(num, max, c);
            heapify(num, max);
        }
    }

    /**
     * 交换函数，比较抽象，熟悉运算符顺序的可以看到右边首先从左向右进行计算：
     *   1 先将num[i]+num[j]计算出来，假设等于a,注意此时nums[j]还没有进行赋值操作
     *   2 然后计算括号里面的赋值操作，然后得出b ,b的值就是nums[i];
     *   3 最后将a-b，其实就是原来未赋值的num[j]
     * @param num
     * @param i
     * @param j
     */
    void swap(int num[], int i, int j) {
        num[i] = num[i] + num[j] - (num[j] = num[i]);
    }

    /**
     * 第二种方法，我是看了解答发现的，是比较简单和高效率的方法，但是若题目堆arr[i]的值没有限制，则不推荐使用这种方法。
     * 因为题目说arr[i]在0到10000，因此可以建立一个数组int[] nums=new int[10001];用来存放arr中各元素出现次数。
     * 然后扫描arr数组，以arr元素为下标，在nums中对应的位置+1；
     * 最后对nums进行从前往后扫描，即可得到前k小个元素。
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers2(int []arr,int k){
        int[] nums=new int[10001];
        for(int i:arr){
            nums[i]++;
        }
        int count=0;
        int re[]=new int[k];
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=0){
                for(int j=1;j<=nums[i];j++) {
                    if (count>=k) break;
                    re[count++] = i;
                }
                if(count>=k) break;
            }
        }
        return re;
    }

    /**
     * 第三种方法，比较传统，就是使用排序效率较高的快排，且因为本题只要寻找前k小的元素，因此在和选出的中轴比较时，只需要从前向后进行调整
     *
     * @param arr
     * @param k
     * @return
     */
    public int[] getLeastNumbers3(int []arr,int k){
        int len=arr.length;
        if (len == 0) return arr;
        if (k == len) return arr;
        if (k == 0) return new int[0];
        int re[]=new int[k];
        partition(arr,0,arr.length-1,k);
        for (int i=0;i<k;i++)
            re[i]=arr[i];
        return re;
    }

    void partition(int nums[],int start,int end,int k){
        int pivot=nums[end];//每次将最后一个元素作为中轴
        int counter=start;//counter用来分隔，左边为比中轴小的，右边为比中轴大的。
        for(int i=start;i<end;i++){
            if(nums[i]<pivot){//若比中轴小则进行交换
               nums[counter]=nums[counter]+nums[i]-(nums[i]=nums[counter]);
               counter++;
            }
        }//最后将中轴和counter位置进行交换，这样counter前面都是比中轴小于的值
        nums[counter]=nums[end]+nums[counter]-(nums[end]=nums[counter]);
        if(counter==k-1) return;//若正好比中轴小的元素正好是k-1个，说明中轴即此时的nums[0-counter]就是前k小的元素，直接结束递归
        if(counter<k-1) partition(nums,counter+1,end,k);//若counter比k-1小则说明还有前k小元素还在counter后面，则进入counter后面寻找
        else partition(nums,start,counter-1,k);//若counter比k-1大，则说明前k小元素都在counter前面，则进入前面进行寻找
    }
    double pow(int x,int n){
        if(n==1) return x;
        double s=pow(x,n/2);
        return s*s;
    }
    public static void main(String[] argc){
        System.out.println(new Q40().pow(3,Integer.MAX_VALUE));
    }
}
