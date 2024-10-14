package top_150_interview;

public class h_Best_time_Buy_and_Sell_Stock_II {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) profit += prices[i+1] - prices[i];
        }
        return profit;
    }
}
