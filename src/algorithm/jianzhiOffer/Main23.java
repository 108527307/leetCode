package algorithm.jianzhiOffer;// 本题为考试多行输入输出规范示例，无需提交，不计分。

import java.util.Scanner;

public class Main23 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int S = sc.nextInt();
        int E = sc.nextInt();
        boolean flag = true;
        if (S > E) {
            flag = false;
            int t = S;
            S = E;
            E = t;
        }
        int ans = 0, x;
        if (S == E) {
            System.out.println(0);
            System.out.println(1);
            System.out.println(S);
            return;
        }
        if (E%S==0){
            System.out.println(0);
            System.out.println(2);
            if (flag){
                System.out.println(S+" "+E);
            }else
                System.out.println(E+" "+S);
            return;
        }
            int min = Math.min(E % S, Math.abs(E % S - S));
        int m = Integer.MAX_VALUE;
        for (int i=S+1;i<2*S;i++){
            if (E%i==0){

            }
        }
    }
}