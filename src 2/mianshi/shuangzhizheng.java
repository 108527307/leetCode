package mianshi;

public class shuangzhizheng {
    public static void main(String[] argc) {
        int[] a = new int[]{2, 4, 5, 3, 5, 3, 2, 5, 6, 3, 2, 5, 8, 6, 9, 5};
        int left = 0, right = a.length - 1;
        while (left < right) {
            while ((a[left] %2) != 0 && left < right) left++;
            while ((a[right] %2) == 0 && left < right) right--;
            if(left<right)
            a[left] = a[left] + a[right] - (a[right] = a[left]);
        }
        int uu=0;
    }
}
