package algorithm;

import java.util.Arrays;
import java.util.Stack;

public class RGB {
    public RGB(int n, String s) {
        String[] cs = s.split("");
        //int[] color = new int[n];//初始为0，表示红色。1表示蓝色，2表示绿色
        int pre[] = new int[n];
        Arrays.fill(pre,-1);

        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int i=1;
        while (!stack.isEmpty() && i < n) {
            if(cs[i].equals(")")){
                    pre[i]=stack.pop();
            }else{
                stack.push(i);
            }
            i++;
        }
        int []dp=new int[n];
        dp[0]=3;
        for(int k=1;k<n;k++){
            if (pre[k]==-1){
                dp[k]=dp[k]+2;
            }else{
                
            }
        }

    }

    public void tu(int[] c, int color, int index) {
        c[index] = color;
    }

    public static void main(String[] argc) {

    }
}
