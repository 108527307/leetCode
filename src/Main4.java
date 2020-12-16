// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.PriorityQueue;
import java.util.Scanner;

class box {
    public int w, v;
    public float wv;

    public box(int w, int v, float wv) {
        this.w = w;
        this.v = v;
        this.wv = wv;
    }
}

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int K = Integer.parseInt(in.nextLine()), N = Integer.parseInt(in.nextLine());
        String[] Ws = in.nextLine().split(" "), Vs = in.nextLine().split(" ");
        //int[] wvs = new int[N];
        PriorityQueue<box> priorityQueue = new PriorityQueue<box>(N, (o1, o2) -> {
            if (o1.wv == o2.wv) return o2.w - o1.w;
            else return (o2.wv - o1.wv) > 0 ? 1 : -1;
        });
        for (int i = 0; i < N; i++) {
            int w = Integer.parseInt(Ws[i]), v = Integer.parseInt(Vs[i]);
            priorityQueue.add(new box(w, v, v * 1.0f / w));
        }
        int sum = 0;
        while (priorityQueue.size() > 0) {
            if (K <= 0) break;
            box temp = priorityQueue.poll();
            if (temp.w <= K) {
                sum += temp.v;
                K -= temp.w;
            }
        }
        System.out.println(sum);
    }
}