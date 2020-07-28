package algorithm.LeetCode;

public class N_Queens_52 {
    /**
     * @return int
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 19/5/2019 2:47 PM
     * @desc: 51 n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * <p>
     * <p>
     * 上图为 8 皇后问题的一种解法。
     * <p>
     * 给定一个整数 n，返回 n 皇后不同的解决方案的数量。
     */
    public int totalNQueens(int n) {
        int[] x = new int[n+1];
        int k = 1, counts = 0;
        while (k > 0) {
            x[k]++;
            while (x[k] <= n && !verify(x, k))
                x[k]++;
            if (x[k] <= n) {
                if (k == n)
                    counts++;
                else {
                    k++;
                    x[k] = 0;
                }
            } else
                k--;
        }
        return counts;
    }

    public boolean verify(int[] x, int k) {
        for (int i = 1; i < k; i++) {
            if (x[i] == x[k] || Math.abs(x[i] - x[k]) == Math.abs(i - k))
                return false;
        }
        return true;
    }

    public static void main(String[] argc) {
        System.out.print(new N_Queens_52().totalNQueens(4));
    }
}
