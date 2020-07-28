package algorithm.LeetCode;

public class Climbing_Stairs_70 {

    public int climbStairs(int n) {
//        return dis(0, n) ;
        return dp(n);
    }

    public int dis(int cur, int n) {
        if (cur > n)
            return 0;
        if (cur == n)
            return 1;
        return dis(cur + 1, n) + dis(cur + 2, n);
    }
// a[i] = a[i - 1] + a[i - 2];
    public int dp(int n) {
        if (n <= 2)
            return n;
        int a[] = new int[n + 1];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        for (int i = 3; i <= n; i++) {
            a[i] = a[i - 1] + a[i - 2];
        }
        return a[n];

    }
    public int dp(){
        int dp[]=new int[101];
        dp[0]=0;
        dp[1]=1;
        dp[2]=2;
        dp[3]=3;
        for(int i=4;i<=100;i++)
            dp[i]=dp[i-1]+dp[i-2]+dp[i-3];
        return dp[100];
    }

    public static void main(String[] argc) {
        System.out.println(new Climbing_Stairs_70().dp());
        //System.out.print(new Climbing_Stairs_70().climbStairs(44));
    }
}
