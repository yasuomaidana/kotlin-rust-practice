package org.example;

public class BestTimeBuySellStock {
    public static void main(String[] args) {
        BestTimeBuySellStock bestTimeBuySellStock = new BestTimeBuySellStock();
        int[] prices = {2, 1, 4};
        System.out.println(bestTimeBuySellStock.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {
        int left = 0;
        int right = left + 1;
        int maxProfit = 0;
        while (right < prices.length) {
            int profit = prices[right] - prices[left];
            if (profit > maxProfit) {
                maxProfit = profit;
            }
            if (prices[left] > prices[right]) {
                left++;
                if (left == right) {
                    right++;
                }
                continue;
            }
            right++;
        }
        return maxProfit;
    }
}
