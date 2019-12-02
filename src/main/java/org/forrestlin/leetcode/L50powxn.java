package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: Pow(x, n)
 * @author: forrestlin
 * @create: 2019-12-02 14:33
 */
public class L50powxn {


    /**
     * * 这里使用二分法 x的2n次幂=x的n次幂*x的n次幂 按照这种思路，相乘的次数将由n变为log(n)
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n < 0 ? 1 / res : res;
    }

}
