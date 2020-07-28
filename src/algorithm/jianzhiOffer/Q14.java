package algorithm.jianzhiOffer;

import java.math.BigInteger;

/**
 * 割绳子1
 * 一般想到的都是动态规划 从长为n的绳子中割出m段，m和n都大于1，
 * 首先思考动态规划递推关系，设f(n)为长度为n的绳子的最大乘积
 * 那我们考虑f(n)是从前一次切割中产生的，假设前一次切割的位置
 * 是i（1<=i<=n），那么前一次切割便产生了(i)和(n-i)两段，那么便有了
 * f(n)=max(f(i)*f(n-i)))，最后一次切割肯定是选的能产生最大乘积的
 * 两段，但是我们不能确定i因此只能进行循环搜索，找出最大的方案，同时
 * 可以缩减i的搜索范围[1,2/n]，只需要搜索一般即可。
 * <p>
 * 然后开始考虑初始化问题，分为两部分（n<4）和（n>=4),小于4的部分其实最优解是不切割，但是题目要求要切割，因此直接返回即可
 * 大于等于4的部分计算时针对f(1)f(2)f(3)直接初始化为123，因为这才是最优解，换句话来说就是大于等于4的绳子当子段切割到长度
 * 为123时便不再切割，这样才是最优解
 */
public class Q14 {
    public int cuttingRope(int n) {
        BigInteger maxRe[] = new BigInteger[n + 1];
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        maxRe[2] = new BigInteger("2");
        maxRe[3] = new BigInteger("3");
        maxRe[1] = new BigInteger("1");
        for (int i = 4; i <= n; i++) {
            BigInteger max = new BigInteger("0");
            for (int j = 1; j <= i / 2; j++) {
                max = max.max(maxRe[j].multiply(maxRe[i - j]));
                //max = Math.max(max, (maxRe[j]* maxRe[i - j]));
            }
            maxRe[i] = max;
        }
        return maxRe[n].mod(new BigInteger("1000000007")).intValue();
    }

    public int cuttingRope2(int n) {
        if (n < 2) return 0;
        if (n == 2) return 1;
        if (n == 3) return 2;
        int timesOf3 = n / 3;
        if (n % 3 == 1) {
            timesOf3--;
            return ((int) Math.pow(3, timesOf3) * 4) % 1000000007;
        }
        return (int) Math.pow(3, timesOf3) % 1000000007;

    }

    public int cutRope3(int n) {
        if (n < 2) return 0;

        if (n == 2) return 1;

        if (n == 3) return 2;

        int timesOf3 = n / 3;

        if (n - timesOf3 * 3 == 1) {
            timesOf3 = 1;
        }

        int timesOf2 = (n - (timesOf3 * 3)) / 2;

        return (int) (Math.pow(3, timesOf3) * Math.pow((2), timesOf2))%1000000007;
    }

    public static void main(String argcp[]) {
        System.out.println(Integer.bitCount(15));
        System.out.println(new Q14().cutRope3(120));
    }
}
