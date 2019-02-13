package main.LeetCode.easy_1.question122;

public class Best_Time_to_Buy_and_Sell_Stock_II {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int i = 0;
        int maxProfit = 0;
        int vally = prices[0];
        int peek = prices[0];
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i+1]) {
                i++;
            }
            vally = prices[i];
            while (i < prices.length - 1 && prices[i] <= prices[i+1]) {
                i++;
            }
            peek = prices[i];
            maxProfit += peek - vally;
        }
        return maxProfit;
    }

}
