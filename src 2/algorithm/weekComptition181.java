package algorithm;

public class weekComptition181 {
    public int[] createTargetArray(int[] nums, int[] index) {
        int target[] = new int[nums.length];
        for (int i = 0; i < index.length; i++) {
            target[index[i]] = nums[i];
        }
        return target;
    }

    public boolean hasValidPath(int[][] grid) {
        return dfs(grid, 0, 0, -1);

    }

    public boolean dfs(int[][] grid, int row, int col, int pre) {
        if (row == grid.length - 1 && col == grid[0].length - 1) {
            if(pre==-1) return true;
            switch (grid[row][col]) {
                case 4:return false;
                case 5:
                    if(pre==2||pre==1) return true; break;
                case 1:
                    if (pre == 2) return true;
                    break;
                case 2:
                    if (pre == 1) return true;
                    break;
                case 3:
                    if (pre == 2) return true;
                    break;
                case 6:
                    if (pre == 1) return true;
                    break;
            }
            return false;
        }
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length) return false;
        int temp = grid[row][col];
        grid[row][col] = -1;
        boolean re = false;
        switch (temp) {
            case -1:
                return false;
            case 1:
                re = dfs(grid, row, col - 1, 4) || dfs(grid, row, col + 1, 2);
                break;
            case 2:
                re = dfs(grid, row - 1, col, 3) || dfs(grid, row + 1, col, 1);
                break;
            case 3:
                re = dfs(grid, row, col - 1, 4) || dfs(grid, row + 1, col, 1);
                break;
            case 4:
                re = dfs(grid, row, col + 1, 2) || dfs(grid, row + 1, col, 1);
                break;
            case 5:
                re = dfs(grid, row, col - 1, 4) || dfs(grid, row - 1, col, 3);
                break;
            case 6:
                re = dfs(grid, row - 1, col, 3) || dfs(grid, row, col + 1, 2);
                break;

        }
        grid[row][col] = temp;
        return re;
    }

    public static void main(String[] argc) {
        weekComptition181 e = new weekComptition181();
        System.out.println(e.hasValidPath(new int[][]{{3,4,3,4},{2,2,2,2},{6,5,6,5}}));
        //e.createTargetArray(new int[]{0, 1, 2, 3, 4}, new int[]{0, 1, 2, 2, 1});
    }
}
