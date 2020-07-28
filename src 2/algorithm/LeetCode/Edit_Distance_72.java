package algorithm.LeetCode;

public class Edit_Distance_72 {
    public int minDistance(String word1, String word2) {

//        memo = new int[word1.length()][word2.length()];
//        return dpm(word1, word2, word1.length() - 1, word2.length() - 1);
        return dis(word1, word2);
    }

    //方法一 一般递归
    public int dp(String w1, String w2, int i, int j) {
        if (i == -1)
            return j + 1;//i走完了，j还没有走完，只需要将word2的剩下字符都插入word1，一共有j+1个字符要插
        if (j == -1)
            return i + 1;//j走完了，i没有走完，则只需要将word1剩下的字符都删除，一共有i+1个剩下的字符要删除
        if (w1.charAt(i) == w2.charAt(j))
            return dp(w1, w2, i - 1, j - 1);
        else {
            int del = dp(w1, w2, i - 1, j) + 1;//删除w1[i]
            int add = dp(w1, w2, i, j - 1) + 1;//在w1[i]后面新增一位字母
            int copy = dp(w1, w2, i - 1, j - 1) + 1;//将w2[j]复制到w1[i]后面，这样最后一位字母就相同了
            return Math.min(del, Math.min(add, copy));
        }

    }

    //方法二 备忘录方法,在递归的基础上减少重复子任务
    public int[][] memo;

    public int dpm(String w1, String w2, int i, int j) {
        if (i == -1)
            return j + 1;//i走完了，j还没有走完，只需要将word2的剩下字符都插入word1，一共有j+1个字符要插
        if (j == -1)
            return i + 1;//j走完了，i没有走完，则只需要将word1剩下的字符都删除，一共有i+1个剩下的字符要删除
        if (memo[i][j] != 0)
            return memo[i][j];
        if (w1.charAt(i) == w2.charAt(j)) {
            memo[i][j] = dpm(w1, w2, i - 1, j - 1);
            return memo[i][j];
        } else {
            int del = dpm(w1, w2, i - 1, j) + 1;//删除w1[i]
            int add = dpm(w1, w2, i, j - 1) + 1;//在w1[i]后面新增一位字母
            int copy = dpm(w1, w2, i - 1, j - 1) + 1;//将w2[j]复制到w1[i]后面，这样最后一位字母就相同了
            memo[i][j] = Math.min(del, Math.min(add, copy));
            return memo[i][j];
        }
    }

    //方法三 动态规划dp[i-1][j-1]表示word1的前i位和word2的前j位之间的编辑距离，和递归类似，dp递推式和递归类似有四种情况：
    // 1。 i和j相同（不操作），则他们的距离等于i-1和j-1之间的距离
    // 2。 i和j不同，在i后面插入一个字符，则他们的距离等于i和j-1之间的距离+1
    // 3。 i和j不同，删除i字符，则他们的距离等于i-1和j之间的距离+1
    // 4。 i和j不同，将i字符替换为j字符，则他们的距离等于i-1和j-1之间的距离+1
    public int dis(String w1, String w2) {
        int m = w1.length() + 1, n = w2.length() + 1;
        int dp[][] = new int[m][n];
        for (int i = 0; i < m; i++)
            dp[i][0] = i;
        for (int j = 0; j < n; j++)
            dp[0][j] = j;
        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++) {
                if (w1.charAt(i - 1) == w2.charAt(j - 1))//i和j相同则不操作
                    dp[i][j] = dp[i - 1][j - 1];
                else {
                    int del = dp[i - 1][j] + 1;
                    int add = dp[i][j - 1] + 1;
                    int copy = dp[i - 1][j - 1] + 1;
                    dp[i][j] = Math.min(del, Math.min(add, copy));
                }
            }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] argc) {
        System.out.print(new Edit_Distance_72().minDistance("horse", "ros"));
    }
}
