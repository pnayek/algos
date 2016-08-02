package dp;

public class BestTimeToBuyAndSellStock {
	/*
	 * Say you have an array for which the
	 * ith element is the price of a given stock on day i.
	 * If you were only permitted to complete at most one transaction
	 * (ie, buy one and sell one share of the stock),
	 * design an algorithm to find the maximum profit.
	 * Leetcode #121, Easy
	 */
	public int maxProfit(int[] prices) {
        if (prices.length <= 1) return 0;
        int[] change = new int[prices.length - 1];
        for (int i = 0; i < prices.length - 1; i++) {
            change[i] = prices[i + 1] - prices[i];
        }
        // find the maximum sum sub array in change
        int max = 0;
        int i = 0;
        int sum = 0;
        while (i < change.length) {
            sum += change[i++];
            sum = sum < 0 ? 0 : sum;
            max = sum > max ? sum : max;
        }
        return max;
    }
	
}
