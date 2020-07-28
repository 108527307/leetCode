package algorithm.LeetCode;

public class Unique_Binary_Search_Trees_96 {
    /**
     * 本题可不断分解为左右子树的种数相乘，
     * 首先设G(n)表示序列长度为n的序列能组成的不同二叉树搜索树的个数
     * F(i,n)表示序列中第i个数为根时不同二叉搜索树的个数
     * 可知F(i,n)=G(i-1)*G(n-i) 第i为根时，他的种类数就是它左子树种类数和右子树种类数的积
     * 因此G(n)=求和 i=1~n（F(i,n)）
     */
    public int numTrees(int n) {
        int G[] = new int[n + 1];

        G[0] = 1;
        G[1] = 1;
        for (int nn = 2; nn <= n; nn++)
            for (int i = 1; i <= nn; i++)
                G[nn] += G[i - 1] * G[nn - i];
        return G[n];
    }

    public static void main(String[] argc) {
        System.out.print(new Unique_Binary_Search_Trees_96().numTrees(3));
    }
}
