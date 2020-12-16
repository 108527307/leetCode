package algorithm;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.HashMap;
import java.util.Scanner;

public class PDD {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        int i = 0;
        HashMap<String, Integer> map = new HashMap();
        map.put("0444444400", 0);
        map.put("0232222400", 1);
        map.put("0462222600", 2);
        map.put("0422424400", 3);
        map.put("0234472200", 4);
        map.put("0262524400", 5);
        map.put("0422544400", 6);
        map.put("0662222200", 7);
        map.put("0444444400", 8);
        map.put("0444522400", 9);
        while (i++ < T) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int N = Integer.parseInt(in.nextLine());
            int k = N / 10;
            int[] temp = new int[N];
            String zero = "";
            for (int f = 0; f < N; f++) {

                String[] str = in.nextLine().split(" ");
                int count = 0;
                for (int j = 0; j < str.length; j += k)
                    if (str[j].equals("1")) count++;
                if (f == 4 * k) {
                    for (int j = 0; j < str.length; j += k) 
                        zero += str[j];
                }
                temp[f] = count;
            }
            String re = "";
            for (int u = 0; u < N; u += k)
                re += temp[u];
            if (re.equals("0444444400")) {
                if (zero.equals("0011001100")) {
                    System.out.println(0);
                } else System.out.println(8);
            } else System.out.println(map.get(re));

        }
    }
}