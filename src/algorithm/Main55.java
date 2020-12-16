package algorithm;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main55 {
    static class dis {
        public int a = 0, b = 0;

        public dis(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    public static PriorityQueue<dis> priorityQueue1 = new PriorityQueue<dis>(Comparator.comparingInt(o -> o.b));
    public static PriorityQueue<dis> priorityQueue2 = new PriorityQueue<dis>(Comparator.comparingInt(o -> o.a));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        int i = 0;
        int counta = 0, countb = 0, sum = 0;
        while (i++ < n) {
            String s[] = in.nextLine().split(" ");
            int A = Integer.parseInt(s[0]), B = Integer.parseInt(s[1]);
            dis temp = new dis(A, B);
            if (A < B) {
                priorityQueue1.add(temp);
                sum += A;
                counta++;
            } else {
                priorityQueue2.add(temp);
                sum += B;
                countb++;
            }
        }
        if (Math.abs(counta - countb) > 1) {
            if (counta > countb) {
                for (int f = 1; f <= counta - countb - 1; f++) {
                    dis t = priorityQueue1.poll();
                    sum -= t.a;
                    sum += t.b;
                }
            } else {
                for (int f = 1; f <= countb - counta - 1; f++) {
                    dis t = priorityQueue2.poll();
                    sum -= t.b;
                    sum += t.a;
                }
            }
            System.out.println(sum);
        } else {
            System.out.println(sum);
        }

    }
}