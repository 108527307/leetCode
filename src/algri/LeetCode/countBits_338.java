package algorithm.LeetCode;//给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
/**
 * 找规律，dp思想，找出dp[i]与dp[i+1]之间的关系，dp[i]表示binary(i)中的1的个数
 * 这一题可以发现：
 *    当i为奇数：则dp[i]=dp[i-1]+1,i中1的个数为前面偶数中1的个数加1
 *    当i为偶数：则dp[i]=dp[i/2],i中1的个数=dp[i/2]
 *
 *    进一步观察发现，当i为奇数时，dp[i]=dp[i/2]+1,因此两种情况可以合起来写，另外对于奇数偶数的判断可使用i&1==1来进行判断,判断的同时直接加上更加简洁。
 * */


public class countBits_338 {
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        ans[0] = 0;
        for (int i = 1; i <= num; i++)
            ans[i]=ans[i>>1]+(i&1);

        return ans;
    }

    public static void main(String[] argc) {
        int[] a = new countBits_338().countBits(10);
        int as = 1;
    }
}
