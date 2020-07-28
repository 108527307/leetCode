package algorithm.LeetCode;

public class Interleaving_String_97 {
    /**
     * 本题是字符串题目一般都使用dp解决
     * dp[i][j]表示A的前i个字符和B的前j个字符是否能交错形成C的前i+j个字符
     * 则递推关系可以表示为dp[i][j]=(dp[i-1][j]&&A[i-1]==C[i+j-1])||(dp[i][j-1]&&B[j-1]==C[i+j-1])
     */
    public boolean isInterleave(String s1, String s2, String s3) {
        int lenA = s1.length();
        int lenB = s2.length();
        int lenC = s3.length();
        if (lenA + lenB != lenC)
            return false;
        boolean[][] dp = new boolean[lenA + 1][lenB + 1];
        dp[0][0] = true;
        for (int i = 1; i <= lenA; i++)
            dp[i][0] = dp[i - 1][0] && s1.charAt(i - 1) == s3.charAt(i - 1);
        for (int j = 1; j <= lenB; j++)
            dp[0][j] = dp[0][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
        for (int i = 1; i <= lenA; i++)
            for (int j = 1; j <= lenB; j++) {
                dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));

            }
        return dp[lenA][lenB];

    }

    public static void main(String[] argc) {
        System.out.print(new Interleaving_String_97().isInterleave("", "", "aadbbcbcac"));
    }
}
