package org.forrestlin.leetcode;

import java.util.Arrays;

/*
 * 零钱兑换
 * */
public class L322CoinChange {

    /*
     * 与L279题完全平方数很像
     *
     * 动态规划
     * DP[i]=Math.min(DP[i],DP[i-c]+1)
     * 此处的c需要通过迭代确定
     * */
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        //这里赋值上最大值，下面好做比较
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }
        //这里需要考虑找不到硬币组合的情况，那么dp[amount]还是等于赋值的初始值amount+1
        return dp[amount] > amount ? -1 : dp[amount];

    }
}
