package org.forrestlin.leetcode;

import java.util.List;

/*
 * 打家劫舍
 * */
public class L198HouseRobber {


    /*
     *动态规划，类似走楼梯
     * DP[i] = max(DP[i-1],DP[i-2]+nums[i])
     * 自上向下，递归，比较慢
     *
     * */
    public int rob(int[] nums) {
        return doRob(nums, nums.length - 1);
    }


    public int doRob(int[] nums, int lastIndex) {
        if (lastIndex == 0) {
            return nums[0];
        }

        int sum1 = doRob(nums, lastIndex - 1);
        int sum2 = doRob(nums, lastIndex - 2) + nums[lastIndex];
        return Math.max(sum1, sum2);
    }

    /*
     * 动态规划后自底向上迭代
     * DP[i+2] = max(DP[i+1],DP[i]+nums[i+2])
     * */
    public int rob1(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        //DP[0]
        int sum1 = nums[0];
        //DP[1]
        int sum2 = Math.max(sum1, nums[1]);

        for (int i = 2; i < nums.length; i++) {
            int tmp = sum1;
            //DP[2]
            sum1 = Math.max(sum2, sum1);
            //DP[3]----DP[n-1]
            sum2 = Math.max(tmp + nums[i], sum1);
        }

        return Math.max(sum1, sum2);
    }

}
