package org.forrestlin.leetcode3;

/*
 * 最佳买卖股票时机含冷冻期
 * */
public class L309BestTimeToBuyAndSellStockWithCooldown {

    /*
     * 动态规划， 两个状态，第i天持有股票和第i天不持有股票，递推公式分别是：
     *D[i][1] = max( d[i-1][1] , d[i-2][0] - prices[i])
     *D[i][0] = max(d[i-1][0], d[i-1][1] + prices[i])
     *
     * 股票问题通用解：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/solution/yi-ge-fang-fa-tuan-mie-6-dao-gu-piao-wen-ti-by-lab/
     * */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0; // 代表 dp[i-2][0]
        for (int i = 0; i < n; i++) {
            int temp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = temp;
        }
        return dp_i_0;
    }


}
