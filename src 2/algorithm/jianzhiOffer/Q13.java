package algorithm.jianzhiOffer;
/**
 * dfs 首先深度搜索的结束条件便是碰到边界或者碰到已经访问过的或者不符合条件的
 *     在计算是否符合条件时是计算下标数位之和来进行的，所以遍历时我们只需要进行下和右两个方向便可以遍历完所有格子
 * */
public class Q13 {
    int n, m, k;
    boolean board[][];

    public int movingCount(int m, int n, int k) {
        if (m == 0 || n == 0)
            return 0;
        this.k = k;
        this.m = m;
        this.n = n;
        this.board = new boolean[m][n];//每个单元两个值，为true表示走过且符合条件，false表示未走过或者走过但是不符合条件
        return sub(0, 0);
    }

    int sub(int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j])
            return 0;


        int ti = i, tj = j;
        System.out.println(i + "," + j);
        boolean v = (ti % 10 + ti / 10 + tj % 10 + tj / 10) <= k; //判断是否符合条件，因为此处i和j都是小于等于100的，因此可以直接缩减为两步即可
        if (!v) {
            return 0;
        }
        board[i][j] = true;
        int re = 1;
        re += sub(i + 1, j);
        re += sub(i, j + 1);
        return re;
    }


    public static void main(String argc[]) {
        System.out.print(new Q13().movingCount(41, 29, 16));
    }
}
