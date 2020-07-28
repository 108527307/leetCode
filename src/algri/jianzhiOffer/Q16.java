package algorithm.jianzhiOffer;
/**
 * 复写pow函数，且x在正负100之内，指数也为整数，首先直观的想到第一种方法暴力循环相乘即可，只要注意指数负数的时候变为除法
 *
 * 第二种也是能够想到的递归，这种由类似相同子问题构成的大问题，都可以由递归解决
 * 假设求pow(x,n) ：1 当n为偶数时，递归关系为pow(x,n)=pow(x,n/2)*pow(x,n/2)
 *                 2 当n为奇数时，递归关系为pow(x,n)=pow(x,n/2)*pow(x,n/2)*x
 *  注意每次递归调用pow(x,n/2)*pow(x,n/2)函数，因为子问题相同，只需要调用一次pow即可
 *  然后递归出口要注意： 1 当n==0时 直接返回1
 *                    2 当n<0时 返回1/x
 *                    3 当n>0时 返回x
 *
 * */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * {@author}
 * @see Q59#max_value()
 * @see "as"
 */
public class Q16 {
    public double myPow(double x, int n) {
        double re = 1;
        if (n > 0) {
            int i = 0;
            while (i < n) {
                re *= x;
                i++;
            }
        } else if (n == 0) return 1;
        else {
            int i = 0;
            while (i > n) {
                re /= x;
                i--;
            }
        }
        return re;
    }


    double myPow2(double x, int n) {
        if (n == 0) return 1;
        if (n == 1)
            return x;
        if (n == -1)
            return 1 / x;
        double d = 1;
        if (n % 2 != 0) {
            if (n > 0)
                d = x;
            else d = 1 / x;
        }
        double r = myPow2(x, n / 2);
        return r * r * d;
    }



    public static void main(String argc[]) {
        HashMap<Integer,Integer> map=new HashMap<>();

        int a=map.getOrDefault(0,0);
List<Integer> d=new ArrayList<>();
d.add(2);

//        String a=new Q32_l().fuck;
//        System.out.println(new Q16().myPow2(34.00515, -3));
//        System.out.println(Math.pow(34.00515, -3));
    }
}
