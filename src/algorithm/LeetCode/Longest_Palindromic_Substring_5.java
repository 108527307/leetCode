package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Longest_Palindromic_Substring_5 {
/**
 * 次题之前是用python，结果他娘的看不懂了，我也是醉了，重新思考了一下，现在记一下思路
 * 最长回文子串
 *
 * 核心：dp[i][j]表示子串从i到j是否是回文
 * 递推公式：dp[i][j]=true if s[i]==s[j]&&dp[i+1][j-1]==true
 * 表示s[i:j]是否是回文串依赖于他的子串s[i+1:j-1]是否为回文串并且首尾两个新加的字母是否相同
 * 循环：这里有两个变量，i和j，但是直接进行两层循环，效率很低。这里定义一个变量gap为每次扫描的子串的长度
 * 通过从较短的长度到较长的长度的遍历，实现模拟了递归的后半段的计算过程，也就是分治法的过程。
 * 首先计算较短的子序列，然后根据这些较短的子序列是否回文，判断出较长序列是否回文。
 *
 * */
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean[s.length()][s.length()];
        if (s.length() == 0)
            return "";

        int longest = 0;
        List<String> longestP = new ArrayList();
        for (int gap = 1; gap <= s.length(); gap++) {
            for (int i = 0; i <= s.length() - gap; i++) {
                int j = i + gap - 1;
                if (gap == 1)
                    dp[i][j] = true;
                else if (gap == 2)
                    dp[i][j] = (s.charAt(i) == s.charAt(j)) ? true : false;
                else {
                    if (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]) {
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                if (dp[i][j] && gap > longest) {
                    longest = j - i + 1;
                    longestP.clear();
                    longestP.add(s.substring(i, j + 1));
                }
            }
        }
        return longestP.get(0);
    }

}
