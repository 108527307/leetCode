package algorithm;

public class xuanzhuan {

    public static int rotatedBinarySearch(int[] array, int target){
        int start = 0, end = array.length-1;
        while(start<=end)
        {
            int mid = start + (end-start)/2;
            if(array[mid]==target){
                return mid;
            }
            //情况A：旋转点在中位数右侧
            if(array[mid]>=array[start])
            {
                //最左侧元素 <= 查找目标 < 中位数
                if(array[mid]>target && array[start]<=target){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            //情况B：旋转点在中位数左侧，或与中位数重合
            else {
                //中位数 < 查找目标 <= 最右侧元素
                if(array[mid]<target && target<=array[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = new int[]{9,10,11,12,13,1,3,4,5,8};
        System.out.println(rotatedBinarySearch(array, 12));
    }


}
