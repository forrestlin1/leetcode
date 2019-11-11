package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 数值的整数次方
 * @author: forrestlin
 * @create: 2019-11-11 16:55
 */
public class L12Power {

    public double Power(double base, int exponent) {
        if (base == 0) {
            return 0D;
        }
        if (exponent == 0) {
            return 1D;
        }
        double res = 1;
        int power = Math.abs(exponent);
        while (power > 0) {
            res *= base;
            power--;
        }
        if (exponent > 0) {

            return res;
        } else {
            return 1 / res;

        }
    }
}
