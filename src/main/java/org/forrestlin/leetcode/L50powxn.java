package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: Pow(x, n)
 * @author: forrestlin
 * @create: 2019-12-02 14:33
 */
public class L50powxn {

    public static void main(String[] args) {
        L50powxn test = new L50powxn();
        System.out.println(test.myPow_bd(2d, 11));
    }

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


    //递归方式更好理解
    public double myPow_bd(double x, int n) {

        if (n > 0) {
            return pow(x, n);
        } else {
            return 1 / pow(x, -n);
        }
    }

    public double pow(double x, int n) {
        if (n == 0) {
            return 1d;
        }

        double half = pow(x, n / 2);
        if (n % 2 == 0) {
            return half * half;
        } else {
            return half * half * x;
        }

    }
}
