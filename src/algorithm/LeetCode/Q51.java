package algorithm.LeetCode;

public class Q51 {
    public int count = 0;

    public int reversePairs(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return this.count;
    }

    public void merge(int[] nums, int start, int end, int mid) {
        int i = start, j = mid + 1;
        int[] temp = new int[end - start + 1];
        int index = 0;
        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                this.count += mid - i + 1;//这一步很关键，在对左右两个有序序列进行比较时，可以发现，left[i]和right[j]进行的比较，如果
                //left[i]比right[j]要大，那么说明left中i后面的也比j大，所以这一步需要加上的是mid-i+1，left中这么多都是大于right[j]的
                temp[index++] = nums[j++];
            }
        }
        while (j <= end)
            temp[index++] = nums[j++];
        while (i <= mid)
            temp[index++] = nums[i++];
        for (int f = 0; f < index; f++)
            nums[start + f] = temp[f];

    }

    public void mergeSort(int[] nums, int start, int end) {
        if (start >= end) return;
        int mid = (start + end) >> 1;
        mergeSort(nums, start, mid);
        mergeSort(nums, mid + 1, end);
        merge(nums, start, end, mid);
    }

    public static void main(String[] argc) {
        System.out.println(new Q51().reversePairs(new int[]{7, 5, 6, 4}));
    }
}
