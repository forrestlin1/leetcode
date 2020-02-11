package org.forrestlin.leetcode2;

/**
 * @program: leetcode
 * @description: 除自身以外数组的乘积
 * @author: forrestlin
 * @create: 2019-11-05 17:26
 */
public class L238ProductOfArrayExceptSelf {

    public int[] productExceptSelf(int[] nums) {
        if (null == nums || nums.length == 0) {
            return new int[0];
        }

        int k = 1;
        int[] res = new int[nums.length];
        //计算第i个元素左边所有数字的乘积
        for (int i = 0; i < nums.length; i++) {
            res[i] = k;
            k = k * nums[i];
        }
        k = 1;
        //计算第i个元素右边所有数字的乘积，并乘以res[i]
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = res[i] * k;
            k = nums[i] * k;
        }

        return res;

    }
}
