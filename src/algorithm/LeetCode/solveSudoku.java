package algorithm.LeetCode;

public class solveSudoku {
    /*
    *37. 编写一个程序，通过已填充的空格来解决数独问题。

一个数独的解法需遵循如下规则：

数字 1-9 在每一行只能出现一次。
数字 1-9 在每一列只能出现一次。
数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
    * */


    public void solveSudoku(char[][] board) {
        boolean[][] l = new boolean[9][9]; //记录第i行是否已经包含j+1字符
        boolean[][] c = new boolean[9][9]; //记录第i列是否已经包含j+1字符
        boolean[][] s = new boolean[9][9]; //记录第i个九宫格是否已经包含j+1字符
        //开始初始化三个二维矩阵都为true
        for (int line = 0; line < 9; line++)
            for (int col = 0; col < 9; col++) {
                if ('.' == board[line][col])
                    continue;
                l[line][board[line][col] - '1'] = true;//表示第line行中是否已经包含board[line][col]
                c[col][board[line][col] - '1'] = true;
                s[line / 3 * 3 + col / 3][board[line][col] - '1'] = true;
            }
        solve(board, 0, l, c, s);

    }


    public boolean solve(char[][] board, int position, boolean[][] l, boolean[][] c, boolean[][] s) {
        int index = position;
        //找到空位,index为行排列的下标，因此通过index定位到某个元素时，行数时index/9,列号为index%9
        for (; index < 81 && '.' != board[index / 9][index % 9]; index++) ;
        if (index < 81) {
            int line = index / 9, col = index % 9;

            for (int i = 1; i < 10; i++) {
                //判断当前lcs中是否有重复，即判断填入i后是否缝合数独的条件
                if (l[line][i - 1] || c[col][i - 1] || s[line / 3 * 3 + col / 3][i - 1])
                    continue;
                //递归
                board[line][col] = (char) ('0' + i);//将i填入数独
                l[line][i - 1] = true;
                c[col][i - 1] = true;
                s[line / 3 * 3 + col / 3][i - 1] = true;
                //进入下一层选择数字，如果子层的数字都是合适的，则这一层也返回合适,否则则将当前层的操作回退
                if (solve(board, index + 1, l, c, s))
                    return true;
                //回溯
                board[line][col] = '.';
                l[line][i - 1] = false;
                c[col][i - 1] = false;
                s[line / 3 * 3 + col / 3][i - 1] = false;
            }
            return false;
        }
        return true;
    }

    public static void main(String argc[]) {
        char[][] temp = {
                {'.', '4', '.', '.', '5', '.', '.', '3', '.'},
                {'.', '4', '.', '1', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '3', '.', '.', '1'},
                {'8', '.', '.', '.', '.', '.', '.', '2', '.'},
                {'.', '.', '2', '.', '7', '.', '.', '.', '.'},
                {'.', '1', '5', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '2', '.', '.', '.'},
                {'.', '2', '.', '9', '.', '.', '.', '.', '.'},
                {'.', '.', '4', '.', '.', '.', '.', '.', '.'}
        };
        new solveSudoku().solveSudoku(temp);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++)
                System.out.print(temp[i][j]);
            System.out.println("");
        }
//        System.out.print(temp);

    }
}
