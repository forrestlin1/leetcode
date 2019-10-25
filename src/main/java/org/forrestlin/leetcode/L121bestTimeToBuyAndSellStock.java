package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 买卖股票的最佳时机
 * @author: forrestlin
 * @create: 2019-10-23 10:47
 */
public class L121bestTimeToBuyAndSellStock {


    /**
     * 动态规划
     *
     * res =  max(prices[i]-min_val,res)
     */
    public int maxProfit(int[] prices) {

        int min_val = Integer.MAX_VALUE;
        int res = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_val) {
                min_val = prices[i];
            }

            res = Math.max(res, prices[i] - min_val);


        }

        return res;
    }
}
