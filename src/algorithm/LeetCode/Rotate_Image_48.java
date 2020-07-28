package algorithm.LeetCode;

public class Rotate_Image_48 {
    /**
     * @return void
     * @author chy
     * @creed: Talk is cheap,show me the code
     * @date 8/5/2019 10:09 AM
     * @desc: 48. 给定一个 n × n 的二维矩阵表示一个图像。
     * <p>
     * 将图像顺时针旋转 90 度。
     * <p>
     * 说明：
     * <p>
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     */
    public void rotate(int[][] matrix) {
        int size = matrix[0].length;
        if (size <= 1)
            return;
        for (int k = 0; k < size / 2; k++) {
            int[] temp = matrix[k];
            matrix[k] = matrix[size - k - 1];
            matrix[size - k - 1] = temp;
        }
        for (int i = 0; i < size; i++)
            for (int j = 0; j < size; j++) {
                if (j <= i)
                    continue;
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }

    }

    public static void displayMatrix(int[][] matrix) {
        for (int[] temp : matrix) {
            for (int i : temp)
                System.out.print(i);
            System.out.println();
        }

    }

    public static void main(String[] argc) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] temp = matrix[0];
        displayMatrix(matrix);
        new Rotate_Image_48().rotate(matrix);
        displayMatrix(matrix);

    }
}
