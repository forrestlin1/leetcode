package org.forrestlin.leetcode2;

import java.util.Arrays;

/*
 * 最长上升子序列
 * */
public class L300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        L300LongestIncreasingSubsequence test = new L300LongestIncreasingSubsequence();
        System.out.println(test.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }

    /**
     * 动态规划 定义dp[i]为以i为最长子序列结尾的子序列长度，
     * <p>则 dp[i] = max(dp[i], dp[j] + 1) for j in [0, i)
     */
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }

}
