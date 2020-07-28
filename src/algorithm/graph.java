package algorithm;

public class graph {



    /**
     * 狄杰斯特拉
     * @param m
     * @param source
     */
    public static void dis(int[][] m, int source) {
        int shortest[] = new int[m.length];//最短路径长度
        boolean visited[] = new boolean[m.length];//s点集
        String[] path = new String[m.length];//输出最短路径

        //初始化输出路径
        for (int i = 0; i < m.length; i++)
            path[i] = new String(source + "->" + i);

        shortest[source] = 0;
        visited[source] = true;

        for (int i = 1; i < m.length; i++) {
            int min = Integer.MAX_VALUE;
            int index = -1;
            //找出source的邻接点中最近的点index
            for (int j = 0; j < m.length; j++) {
                if (!visited[j] && m[source][j] < min) {
                    min = m[source][j];
                    index = j;
                }
            }
            shortest[index] = min;//更新最短路径
            visited[index] = true;

            //更新从index到其他结点（没有访问过的）的的距离
            for (int k = 0; k < m.length; k++) {
                if (!visited[k] && m[index][k] != Integer.MAX_VALUE && min + m[index][k] < m[source][k]) {
                    m[source][k] = min + m[index][k];//这里就直接将m[source]作为了保存source到所有点的路径长度临时存储表
                    path[k] = path[index] + "->" + k;
                }
            }
        }
        return;
    }
}
