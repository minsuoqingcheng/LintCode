package main.LeetCode.easy_1.question121;

public class Best_Time_to_Buy_and_Sell_Stock {

    public int maxProfit(int[] prices) {
        int minPoint = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPoint) {
                minPoint = prices[i];
            } else if (prices[i] - minPoint > maxProfit) {
                maxProfit = prices[i] - minPoint;
            }
        }
        return maxProfit;
    }

}
