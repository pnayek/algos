package greedy;

public class BestTimeToBuyAndSellStockII {
	/*
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * Design an algorithm to find the maximum profit.
	 * You may complete as many transactions as you like
	 * (ie, buy one and sell one share of the stock multiple times).
	 * However, you may not engage in multiple transactions at the same time
	 * (ie, you must sell the stock before you buy again).
	 * 
	 * Leetcode #122, Medium
	 */
	
	// O(n) time, O(1) space 
	public int maxProfit(int[] prices) {
        int totalProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                totalProfit += prices[i + 1] - prices[i];
            }
        }
        return totalProfit;
    }
	
	// O(n) time, O(n) space
	public int maxProfit2(int[] prices) {
        if (prices.length == 0) return 0;
        int[] changes = new int[prices.length - 1];
        for (int i = 1; i < prices.length; i++) {
            changes[i - 1] = prices[i] - prices[i - 1];
        }
        int sum = 0;
        int totalProfit = 0;
        for (int i = 0; i < changes.length; i++) {
            if (changes[i] < 0) {
                // reset running sum
                totalProfit += sum;
                sum = 0;
            }
            else {
                sum += changes[i];
            }
        }
        totalProfit += sum;
        return totalProfit;
    }
}
