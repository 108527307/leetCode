package algorithm.jianzhiOffer;

/**
 * 统计二进制数中1的个数 有三种方法
 */
public class Q15 {
    public int hammingWeight1(int n) {
        return Integer.bitCount(n);//java的Integer中又一个计数函数，能返回该int型变量二进制形式中的1个数

    }

    public int hammingWeight2(int n) {
        //&操作就是二进制形式下两个数都为1的位保留，其他都为0，
        // 所以n每次和（n-1）进行&操作便可以少一个1，这样直到==0，便可以统计1的个数,只适用于正数
        int count = 0;
        while (n != 0) {
            count++;
            n = n & (n - 1);

        }
        return count;

    }
    public int hammingWeight3(int n) {
        int count = 0;
        while (n != 0) {
            if((n&1)!=0){//正数右移的过程中，先判断最右边一位是否是1，如果是就count++，然后右移，这样便可以统计1的个数
                //但是负数由于右移过程中是最左边补1，所以不适用于负数
                count++;
            }
            n =n>>1;

        }
        return count;

    }



    public static void main(String argc[]) {
        System.out.print(new Q15().hammingWeight2(-14));

    }
}
