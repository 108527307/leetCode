package algorithm.LeetCode;

public class Decode_Ways_91 {
    //动态规划方法

    /**
     * dp[i]表示读取到i位时的方法总数，本题和爬楼梯很相似，但是比爬楼梯多了几个限制条件
     * 1。 当s[i]为0时，则对于dp[i]的计算就需要考虑s[i-1]是否合法，当s[i-1]为1或2时才合法能够解码，为0时则直接返回0，表示不能解码，其他数字时
     * 则说明这一步也不能解码，因为0不能单独解码,若之前的s[i-1]合法，则dp[i]=dp[i-1]+dp[i-2]
     * 2.  当s[i]不为0时，只需要讨论s[i-1]s[i]是否小于等于26，若符合则dp[i]=dp[i-1]+dp[i-2],不符合的话dp[i]=dp[i-1]
     * <p>
     * 然后，在初始化dp数组的时候也要注意对dp[0]dp[1]dp[2]先进行判断
     */
    public int numDecodings(String s) {
        int[] dp = new int[s.length()];
        if (s.equals("") || s.charAt(0) == '0')
            return 0;
        dp[0] = 1;
        if (s.length() > 1) {
            if (s.charAt(1) == '0') {
                if (Integer.valueOf(s.substring(0, 2)) <= 26)
                    dp[1] = 1;//这边s[0]s[1]只能两个字符一起解码
                else
                    return 0;//表示不能解码，例如30
            } else {
                if (Integer.valueOf(s.substring(0, 2)) <= 26)
                    dp[1] = 2;
                else
                    dp[1] = 1;
            }
        } else return 1;
        for (int i = 2; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (s.charAt(i - 1) == '0')
                    return 0;//两个0连在一起肯定不能解码
                if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
                    dp[i] =  dp[i - 2];//这边两个字符要一起解码
                else
                    return 0;

            } else {
                if (s.charAt(i - 1) == '0')
                    dp[i] = dp[i - 1];//前一位为0，则s[i]只能单独解码
                else {
                    if (Integer.valueOf(s.substring(i - 1, i + 1)) <= 26)
                        dp[i] = dp[i - 1] + dp[i - 2];
                    else
                        dp[i] = dp[i - 1];
                }
            }
        }
        return dp[s.length()-1];

    }
    public static void main(String[] argc){
        System.out.print(new Decode_Ways_91().numDecodings("110"));
    }
}
