package algorithm.LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Spiral_Matrix_54 {
    /**
     * @return java.util.List<java.lang.Integer>
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 27/5/2019 8:31 PM
     * @desc: 54 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new ArrayList<>();
        int Sr = 0, Sc = 0, Ec = matrix[0].length - 1, Er = matrix.length - 1;
        List<Integer> res = new ArrayList<>();

        while (Sc <= Ec && Sr <= Er) {
            int row = Sr, col = Sc;
            for (; col <= Ec; col++)
                res.add(matrix[row][col]);
            if (Sr == Er)
                break;
            for (col = Ec, row = Sr + 1; row <= Er; row++)
                res.add(matrix[row][col]);
            if (Sc == Ec)
                break;
            for (row = Er, col = Ec - 1; col >= Sc; col--)
                res.add(matrix[row][col]);
            for (col = Sc, row = Er - 1; row >= Sr + 1; row--)
                res.add(matrix[row][col]);
            Sc++;
            Sr++;
            Ec--;
            Er--;
        }
        return res;
    }

    public static void main(String[] argc) {
        List<Integer> res = new Spiral_Matrix_54().spiralOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}});
        return;
    }
}
