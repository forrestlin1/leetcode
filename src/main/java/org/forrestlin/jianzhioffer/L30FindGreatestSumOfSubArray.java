package org.forrestlin.jianzhioffer;

/*
 * 给一个数组，返回它的最大连续子序列的和
 * */
public class L30FindGreatestSumOfSubArray {

    public static void main(String[] args) {
        L30FindGreatestSumOfSubArray test = new L30FindGreatestSumOfSubArray();
        System.out.println(test.FindGreatestSumOfSubArray(new int[]{-2, -8, -1, -5, -9}));
    }

    /*
     * 动态规划
     * DP[i] = DP[i-1]>0?DP[i-1]+A[i]:A[i]
     *
     *
     * */
    public int FindGreatestSumOfSubArray(int[] array) {
        if (array.length == 1) {
            return array[0];
        }
        int res = 0;
        int max = Integer.MIN_VALUE;
        for (int i : array) {
            if (res > 0) {
                res = res + i;
            } else {
                res = i;
            }

            max = Math.max(res, max);
        }

        return max;

    }
}
