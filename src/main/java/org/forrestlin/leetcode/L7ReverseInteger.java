package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 整数反转
 * @author: forrestlin
 * @create: 2019-11-22 15:07
 */
public class L7ReverseInteger {

    public int reverse(int x) {
        long temp = 0;
        while (x != 0) {
            int pop = x % 10;
            temp = temp * 10 + pop;
            if (temp > Integer.MAX_VALUE || temp < Integer.MIN_VALUE) {
                return 0;
            }

            x = x / 10;

        }
        return (int) temp;

    }

}
