package org.forrestlin.leetcode;

/**
 * 阶乘后的0
 */
public class L172factorialTrailingZeroes {

    //https://leetcode-cn.com/problems/factorial-trailing-zeroes/solution/xiang-xi-tong-su-de-si-lu-fen-xi-by-windliang-3/
    //本质上是寻找阶乘表达式中有多少个5
    public int trailingZeroes(int n) {
        int count = 0;
        while (n > 0) {
            count += n / 5;
            n = n / 5;
        }
        return count;
    }

}
