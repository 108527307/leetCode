package algorithm;// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;
import java.util.Stack;

public class Main31 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = Integer.parseInt(in.nextLine());
        int i = 0;
        Stack<Character> fuhao = new Stack<>();
        Stack<Integer> num = new Stack<>();
        while (i++ < T) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String str = in.nextLine();
            boolean flag = true;
            char chars[] = str.toCharArray();
            for (int j = 0; j < chars.length; j++) {
                if (chars[j] == '(' || chars[j] == '+' || chars[j] == '-' || chars[j] == '*') {
                    fuhao.add(chars[j]);
                } else if (chars[j] == ')') {
                    if (!fuhao.isEmpty()) {
                        char yunsuan = fuhao.pop();

                        if (fuhao.isEmpty() || fuhao.pop() != '(') {
                            flag = false;
                            break;
                        }
                        if (yunsuan == '+') {
                            num.add(num.pop() + num.pop());
                        } else if (yunsuan == '-') {
                            num.add(-(num.pop() - num.pop()));
                        } else if (yunsuan == '*') {
                            num.add(num.pop() * num.pop());
                        } else {
                            flag = false;
                            break;
                        }
                    } else {
                        flag = false;
                        break;
                    }
                } else if (chars[j] >= 48 && chars[j] <= 57) {
                    int k = j + 1;
                    int te = 0;
                    while (k < chars.length && chars[k] >= 48 && chars[k] <= 57) k++;
                    for (int g = j; g < k; g++) {
                        te = te * 10 + Integer.parseInt(chars[g] + "");
                    }
                    num.add(te);
                    j = k - 1;
                }
            }
            if (flag) {
                if (!fuhao.isEmpty() || num.size() > 1) {
                    System.out.println("invalid");

                } else
                    System.out.println((num.pop() % 10000000 + 10000000) % 10000000);
            } else
                System.out.println("invalid");
        }
    }
}