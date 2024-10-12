package top_150_interview;

public class g_Best_time_Buy_and_Sell_Stock {
    public int maxProfitV1(int[] prices) {
        int res = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i+1; j < prices.length; j++) {
                if (prices[j] - prices[i] > res) {
                    res = prices[j] - prices[i];
                }
            }
        }

        return res;
    }

    public static int maxProfitV2(int[] prices) {
        int len = prices.length;
        return maxProfit2(prices, 0, len - 1);
    }

    public static int maxProfit2(int[] prices, int start, int end) {
        if (start >= end) return 0;

        int min = prices[start], max = prices[start];
        int minIdx = start, maxIdx = start;
        for (int i = start; i <= end; i++) {
            if (min > prices[i]) {
                min = prices[i];
                minIdx = i;
            }
            if (max <= prices[i]) {
                max = prices[i];
                maxIdx = i;
            }
        }

        if (minIdx < maxIdx) {
            return max - min;
        } else {
            return Math.max(Math.max(maxProfit2(prices, start, maxIdx), maxProfit2(prices, maxIdx + 1, minIdx - 1))
                    , maxProfit2(prices, minIdx, end));
        }
    }

    public static void main(String[] args) {
        int[] prices = {3, 9, 6, 5, 4, 2, 1, 7, 8};
        System.out.println(maxProfitV2(prices));
    }
}
