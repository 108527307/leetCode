package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Palindrome_Partitioning_131 {
    public List<List<String>> partition(String s) {
        return partitionHelper(s, 0);
    }

    /**
     * 首先，第一种方法：分治法
     * 切割s，从左向右切割，将问题分成左边和右边。每次切割，保证左边是一个回文串，然后将右边的字符串进行递归，
     * 返回对应的回文子字符串序列，然后将左边的回文串添加到右边返回的每种序列当中去，这样最终返回的就是本次
     * 切割点所产生的所有回文子字符串序列，然后将其加入结果列表。
     */
    public List<List<String>> partitionHelper(String s, int start) {
        //首先，递归出口，当切割到末尾时，返回一个空串，这个空串的作用是用来加入左边的回文字符串，也代表一种子序列
        if (s.length() == start) {
            List<String> temp = new ArrayList<>();
            List<List<String>> ans = new ArrayList<>();
            ans.add(temp);
            return ans;
        }
        //切割结果序列存放
        List<List<String>> ans = new ArrayList<>();
        //从左边开始一个字符一个字符的切割
        for (int i = start; i < s.length(); i++) {
            //切割出来两部分左边和右边，左边先判断是否是回文，如果不是则放弃这种可能，否则继续递归切割右边的字符串
            if (isPalindrome(s.substring(start, i + 1))) {
                //保存下左边的子串，用来加在右边返回的回文子串序列中
                String left = s.substring(start, i + 1);
                //开始对右边的部分进行递归分割，并返回所有的回文子串序列种类
                for (List<String> j : partitionHelper(s, i + 1)) {
                    //右边返回的回文子串种类，每一种都加上左边的回文子串，然后加入结果列表
                    j.add(0, left);
                    ans.add(j);
                }
            }
        }
        return ans;
    }

    public boolean isPalindrome(String s) {
        int i = 0;
        int length = s.length();
        while (i <= length / 2) {
            if (s.charAt(i) != s.charAt(length - i-1))
                return false;
            i++;
        }
        return true;
    }

    //分治法优化


}
