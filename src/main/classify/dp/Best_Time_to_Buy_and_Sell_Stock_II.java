package main.classify.dp;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        int profix = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i-1]) {
                profix += prices[i] - prices[i-1];
            }
        }
        return profix;
    }

}
