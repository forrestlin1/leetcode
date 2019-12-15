package org.forrestlin.leetcode;

/**
 * 买卖股票的最佳时机 II
 */
public class L122bestTimeToBuyAndSellStockII {

    /*
     *贪心，只要判断后一天比前一天大，就买入卖出
     * */
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i <= prices.length - 1; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}
