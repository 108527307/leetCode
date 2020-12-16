package algorithm;// 本题为考试多行输入输出规范示例，无需提交，不计分。
import java.util.*;

public class dianxin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        Stack<Integer> s1=new Stack(),s2=new Stack();
        int i=0;
        while(i++<n){
            String[] str=sc.nextLine().split(" ");
            if(str[0].equals("push")){
                int num=Integer.parseInt(str[1]);
                if(!s2.isEmpty()&&s2.peek()<num){
                    s2.add(s2.peek());
                }else
                    s2.add(num);

                s1.add(num);

            }else if(str[0].equals("getMin")){
                System.out.println(s2.peek());
            }else if(str[0].equals("top")){
                System.out.println(s1.peek());
            }else{
                s1.pop();
                s2.pop();
            }
        }
    }
}