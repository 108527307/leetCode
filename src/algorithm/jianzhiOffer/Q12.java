package algorithm.jianzhiOffer;
/**
 * 矩阵中搜寻路径，一般方法都是dfs，首先找到第一个字母的位置，然后从该字母开始进行上下左右四个方向上的尝试判断即可
 *
 * dfs停止的边界条件便是碰到矩阵的边界或者碰到已经访问过的格子或者和条件不符合
 *
 * 此题可以直接用给定的矩阵用作记录已经走过的路径。
 * */
public class Q12 {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0)
            return false;
        if (board[0].length == 0) return false;
//        if(board.length*board[0].length<word.length())
//            return false;
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++) {
                if (word.charAt(0) == board[i][j]) {

                    return sub(board, word, -1, i, j, 0);

                }
            }
        return false;
    }

    boolean sub(char[][] board, String word, int preStep, int i, int j, int index) {
        if (index > word.length() - 1) {
            //System.out.println(' ');
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1||board[i][j] == '/'||board[i][j] != word.charAt(index))
            return false;
        char tmp = board[i][j];
        board[i][j] = '/';
        if (sub(board, word, 0, i - 1, j, index + 1)) return true;
        if (sub(board, word, 1, i + 1, j, index + 1)) return true;
        if (sub(board, word, 3, i, j + 1, index + 1)) return true;
        if (sub(board, word, 2, i, j - 1, index + 1)) return true;
        board[i][j] = tmp;
        return false;
    }

    public static void main(String argc[]) {
        char[][] board = new char[][]{{'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}, {'a', 'a', 'a', 'a'}};
        char[][] board1 = new char[][]{{'a', 'b', 'c', 'e'}, {'s', 'f', 'c', 's'}, {'a', 'd', 'e', 'e'}};
        String word = "abcced";
        //System.out.println(new Q12().exist(board1, word));
        System.out.println(4^4);
    }
}
