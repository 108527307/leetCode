package algorithm.LeetCode;

public class pow_50 {
    /**
     * @return double
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 16/5/2019 1:32 PM
     * @desc:50 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
     */
    //分治法的非递归，首先用一个变量存储结果，然后从n开始向下不断除以二，用i来记录，当i为偶数时便将x平方，为奇数时则将此时的x和结果相乘（相当于暂时存储一下奇次幂时的底数，因为下次迭代i
    // 又要整除除以二，会丢失此结果，最后迭代完成之后判断一下x的正负对计算结果进行倒数操作)）
    public double myPow1(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

    // 分治法  递归，首先从n不断除以2 到0，然后开始回溯，当n是偶数时返回上次递归结果的平方，奇数时返回结果的平方还要✖️一个x（多出来的)
    public double myPow2(double x, int n) {
        if (n == 0) return 1;//结束时
        double half = myPow2(x, n / 2);
        if (n % 2 == 0) return half * half;
        if (n > 0) return half * half * x;
        return half * half / x;
    }

    public static void main(String[] argc) {
        System.out.println(new pow_50().myPow2(2, 10));
    }
}
