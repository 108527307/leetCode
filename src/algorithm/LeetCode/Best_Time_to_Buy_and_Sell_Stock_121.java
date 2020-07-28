package algorithm.LeetCode;

public class Best_Time_to_Buy_and_Sell_Stock_121 {
    //简单题 不解释了
    public int maxProfit(int[] prices) {
        int count=0;
        int i=0;
        int j=i+1;
        while(i<prices.length-1&&j<=prices.length-1){
            if(prices[j]-prices[i]<0){
                i++;
                j=i+1;

                continue;
            }
            if(prices[j]-prices[i]>count){
                count=prices[j]-prices[i];

            }
            j++;

        }
        return count;
    }
}
