package javaTest;

public class kuiashou {
    public static void main(String[] argc)
    {
        float i=0.3f;
        System.out.println(i==0.3);
    }
}
class Solution {
    public int[] singleNumbers(int[] nums) {
        int s=0;
        for(int i:nums)
            s^=i;//最后这个s就是那两个不同的数a和b的异或值
        int k=s&(-s);//这个k就是a或b中最低的1的值
        int[] re=new int[2];
        for(int i:nums){
            if((i&k)!=0) re[0]^=i;
            else re[1]^=i;
        }
        return re;

    }
}

