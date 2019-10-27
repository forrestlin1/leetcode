package org.forrestlin.leetcode;

/*
* 乘积最大子序列
* */
public class L152MaximumProductSubarray {

    public static void main(String[] args) {
        L152MaximumProductSubarray test = new L152MaximumProductSubarray();
        System.out.println(test.maxProduct(new int[]{-2, 3, -4}));
    }


    /*
    * 动态规划，定义DP[i]为以i为结束点的序列的最大子序列乘积
    * 考虑num[i]可能大于0也可能小于0,故还要记录一个最小子序列乘积
    * DP[i+1] =max(DP[i]*num,num)
    * */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE, imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tmp = imax;
                imax = imin;
                imin = tmp;
            }
            imax = Math.max(imax * nums[i], nums[i]);
            imin = Math.min(imin * nums[i], nums[i]);

            max = Math.max(max, imax);
        }
        return max;

    }
}
