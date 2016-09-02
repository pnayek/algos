package dp;

public class BestTimeToBuyAndSellStockCooldown {
    /*
     * Say you have an array for which the ith element is the price of a given stock on day i.
     * Design an algorithm to find the maximum profit. You may complete as many transactions
     * as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
     * 
     * You may not engage in multiple transactions at the same time
     * (ie, you must sell the stock before you buy again).
     * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
     * 
     * Example:
     * prices = [1, 2, 3, 0, 2]
     * maxProfit = 3
     * transactions = [buy, sell, cooldown, buy, sell]
     * 
     * Leetcode #309, Medium
     */
	
	// O(n), O(n)
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0) return 0;
        int[] cache = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            cache[i] = cache[i + 1]; // max profit if you do not buy at i
            
            // max profit if you buy at i, sell at k
            for (int k = i + 1; k < n; k++) {
                if (prices[k] <= prices[i]) continue;
                int profit1 = prices[k] - prices[i];
                int profit2 = k + 2 < n ? cache[k + 2] : 0;
                int profit = profit1 + profit2;
                cache[i] = profit > cache[i] ? profit : cache[i];
            }
        }
        return cache[0];
    }
    
    private int[] cache;
    
    private int maxProfit(int[] prices, int i) {
        if (i >= prices.length - 1) return 0;
        if (cache[i] >= 0) return cache[i];
        
        int max = 0; // max profit
        
        // Case 1: buy at i, sell at k
        for (int k = i + 1; k <= prices.length - 1; k++) {
            if (prices[k] <= prices[i]) continue;
            int profit1 = prices[k] - prices[i];
            int profit2 = maxProfit(prices, k + 2);
            int profit = profit1 + profit2;
            max = profit > max ? profit : max;
        }
        
        // Case 2: do not buy at i
        int profit = maxProfit(prices, i + 1);
        
        cache[i] = profit > max ? profit : max;
        return cache[i];
    }
    
    // O(n), O(n)
    public int maxProfitRecursive(int[] prices) {
        int n = prices.length;
        cache = new int[n];
        for (int i = 0; i < n; i++) {
            cache[i] = -1;
        }
        return maxProfit(prices, 0);
    }
}
