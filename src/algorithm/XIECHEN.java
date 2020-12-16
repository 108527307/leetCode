package algorithm;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class XIECHEN {


    /*请完成下面这个函数，实现题目要求的功能
    当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^
    ******************************开始写代码******************************/
    static int buyCoke(int m, int a, int b, int c, int x) {
        int bal10 = a, bal50 = b, bal100 = c;
        int count = 0;
        for (int i = 0; i < m; i++) {
            int temp100 = x / 100;
            if (x % 100 != 0 && x > 100) temp100++;
            if (temp100 <= bal100) {//100够了，找钱
                bal100 -= temp100;
                count += temp100;
                int temp = temp100 * 100 - x;
                int temp50 = (temp) / 50;
                bal50 += temp50;
                bal10 += (temp - temp50 * 50) / 10;
            } else {//100大钞不够
                temp100 = bal100;
                int temp = x - temp100 * 100;
                count += bal100;
                bal100 = 0;
                int temp50 = (temp) / 50;//用50来补
                if (temp % 50 != 0 && temp > 50) temp50++;
                if (temp50 <= bal50) {//50够补，开始找钱
                    bal50 -= temp50;
                    count += temp50;
                    bal10 += (temp50 * 50 - temp) / 10;
                } else {//50的也不够了
                    temp50 = bal50;
                    count += bal50;
                    bal50 = 0;
                    int temp10 = (x - temp100 * 100 - temp50 * 50) / 10;//需要的10块的张数
                    count += temp10;
                    bal10 -= temp10;
                }


            }

        }
        return count;

    }

    /******************************结束写代码******************************/


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int res;

        int _m;
        _m = Integer.parseInt(in.nextLine().trim());

        int _a;
        _a = Integer.parseInt(in.nextLine().trim());

        int _b;
        _b = Integer.parseInt(in.nextLine().trim());

        int _c;
        _c = Integer.parseInt(in.nextLine().trim());

        int _x;
        _x = Integer.parseInt(in.nextLine().trim());

        res = buyCoke(_m, _a, _b, _c, _x);
        System.out.println(String.valueOf(res));

    }
}
