// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

class child {
    public int num;
    public int index;

    public child(int x, int y) {
        num = x;
        index = y;
    }
}

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.nextLine());
        int[][] nums = new int[N][2];
        int i = 0;
        PriorityQueue<child> priorityQueue1 = new PriorityQueue<child>(N, (o1, o2) -> {
            if (o1.num == o2.num) return o1.index - o2.index;
            return o2.num - o1.num;
        });
        PriorityQueue<child> priorityQueue2 = new PriorityQueue<child>(N, (o1, o2) -> {
            if (o1.num == o2.num) return o1.index - o2.index;
            return o2.num - o1.num;
        });
        int k = 0;
        while (k++ < N) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String[] str = in.nextLine().split(" ");
            if (str[1].equals("1"))
                priorityQueue1.add(new child(Integer.parseInt(str[0]), i));
            else priorityQueue2.add(new child(Integer.parseInt(str[0]), i));
            i++;
        }
        int sum1 = 0, sum2 = 0, sum3 = 0, sum4 = 0, count1 = 0, count2 = 0;
        int[] childs1 = new int[3], childs2 = new int[3];
        for (int j = 0; j <= 2; j++) {
            if (priorityQueue1.size() > 0) {
                child temp1 = priorityQueue1.poll();
                sum1 += temp1.num;
                count1++;
                childs1[j] = temp1.index;
            }
            if (priorityQueue2.size() > 0) {
                child temp2 = priorityQueue2.poll();
                sum2 += temp2.num;
                count2++;
                childs2[j] = temp2.index;
            }
        }
        if (sum1 > sum2) {
            if (count1 < 3) {
                System.out.println("null");
                return;
            }
            Arrays.sort(childs1);
            Arrays.stream(childs1).forEach(o1 -> System.out.print(o1 + 1 + " "));
            System.out.println();
            System.out.println(1);
            System.out.println(sum1);

        } else {
            if (count2 < 3) {
                System.out.println("null");
                return;
            }
            Arrays.sort(childs2);
            Arrays.stream(childs2).forEach(o1 -> System.out.print(o1 + 1 + " "));
            System.out.println();
            System.out.println(2);
            System.out.println(sum2);
        }
    }
}