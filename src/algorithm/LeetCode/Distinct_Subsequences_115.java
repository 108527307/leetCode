package algorithm.LeetCode;

public class Distinct_Subsequences_115 {
    public int numDistinct(String s, String t) {
        return distinct(s, 0, t, 0);
    }

    /**
     * 方法一 递归，从s中取出t
     */
    public int distinct(String s, int s_start, String t, int t_start) {
        if (t.length() == t_start)//t为空串
            return 1;
        if (s.length() == s_start)//s为空串
            return 0;
        int count = 0;
        if (s.charAt(s_start) == t.charAt(t_start)) {//当当前比较的两个字符相同时，则有两种选择，取或者不取，
            count = distinct(s, s_start + 1, t, t_start + 1) + distinct(s, s_start + 1, t, t_start);
        } else
            count = distinct(s, s_start + 1, t, t_start);//当不同时只能不取
        return count;
    }

    /***
     * 方法二，动态规划，相对递归，减少了压栈的过程，直接进行出栈计算的过程
     * */
    public int dp(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for (int i = 0; i <= s.length(); i++)
            dp[i][t.length()] = 1;
        for (int i=s.length()-1;i>=0;i--)
            for (int j=t.length()-1;j>=0;j--){
            if (s.charAt(i)==t.charAt(j))
                dp[i][j]=dp[i+1][j+1]+dp[i+1][j];
            else
                dp[i][j]=dp[i+1][j];
            }

            return dp[0][0];
    }
    public static void main(String[] argc){
        System.out.print(new Distinct_Subsequences_115().dp("rabbbit","rabbit"));
    }
}
