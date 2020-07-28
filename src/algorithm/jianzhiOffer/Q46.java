package algorithm.jianzhiOffer;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Q46 {
    public int translateNum(int num) {
        String numStr = String.valueOf(num);
        if (numStr.length() == 0) return 0;
        int[] dp = new int[numStr.length()];
        dp[0] = 1;
        if (numStr.length() == 1) return dp[0];
        //System.out.println((int)numStr.charAt(0));
        if (Integer.parseInt(numStr.substring(0, 2)) < 26 && Integer.parseInt(numStr.charAt(0) + "") != 0)
            dp[1] = 2;
        else dp[1] = 1;
        //System.out.println(dp[2]);
        for (int i = 2; i < numStr.length(); i++) {

            if (Integer.parseInt(numStr.substring(i - 1, i + 1)) < 26 && Integer.parseInt(numStr.charAt(i - 1) + "") != 0) {
                dp[i] = dp[i - 1] + dp[i - 2];
            } else dp[i] = dp[i - 1];
        }
        return dp[numStr.length() - 1];
    }

    public int translateNum2(int num) {
        return 0;
    }



}
