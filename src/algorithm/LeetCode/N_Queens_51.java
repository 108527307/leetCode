package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class N_Queens_51 {
    /**
     * @return java.util.List<java.util.List<java.lang.String>>
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 18/5/2019 11:28 AM
     * @desc: 51 上图为 8 皇后问题的一种解法。
     * <p>
     * 给定一个整数 n，返回所有不同的 n 皇后问题的解决方案。
     * <p>
     * 每一种解法包含一个明确的 n 皇后问题的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     */
    public List<List<String>> solveNQueens(int n) {
        int[] x = new int[n + 1];

        List<List<String>> results = new ArrayList<>();
        int k = 1;//从第一个皇后开始进行选择
        while (k > 0) {
            x[k] += 1;//首先先初始化第k个皇后所选择的行（有两种情况，第一个是前一个皇后选好了，则这个皇后初始化为1，另外一种情况就是后面第k+1个皇后摆放失败，回溯回来，则将选择下一行）
            while (x[k] <= n && !verify(x, k))//x[k]<=n表示选择还是有选择的，若x[k]>n了则表示第k个皇后摆放失败
                x[k] += 1;
            if (x[k] <= n) {
                if (k == n)//表示n个皇后都已摆放完成，则输出结果矩阵
                {
                    results.add(array2list(x, n));
                } else {
                    k++;
                    x[k] = 0;//这个操作是防止 在回溯到上一个皇后之后重新选择好再进入第k个皇后时存在上次遗留的初始值导致循环不完全 结果出错
                }
            } else //表示摆放失败 进行回溯
                k--;
        }
        return results;
    }

    /*
    * 验证第k个皇后与前面k-1个是否有冲突
    * */
    public boolean verify(int[] x, int k) {
        for (int i = 1; i < k; i++) {
            if (x[i] == x[k] || Math.abs(x[i] - x[k]) == Math.abs(i - k))
                return false;
        }
        return true;
    }

    /*
    * 将用来计数的一维数组转化为列表
    * */
    public List<String> array2list(int[] x, int n) {
        List<String> res = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            String temp = "";
            for (int j = 1; j <= n; j++) {
                if (x[i] == j)
                    temp += 'Q';
                else
                    temp += '.';
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] argc) {
        List<List<String>> e = new N_Queens_51().solveNQueens(4);
        for (List<String> i : e) {
            for (String item : i)
                System.out.println(item);
            System.out.println();
        }
    }
}
