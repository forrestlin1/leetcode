package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: x的平方根
 * @author: forrestlin
 * @create: 2019-12-04 14:29
 */
public class L69sqrtx {

    public static void main(String[] args) {
        L69sqrtx test = new L69sqrtx();
        System.out.println(test.mySqrt(8));
    }

    /**
     * 二分搜索，注意数据类型
     */
    public int mySqrt(int x) {

        long low = 1;
        long high = x / 2 + 1;
        long target = x;

        while (low <= high) {
            long middle = low + ((high - low) >> 1);

            if (target < middle * middle) {

                high = middle - 1;
            } else if (target > middle * middle) {
                low = middle + 1;
            } else {
                return (int) middle;
            }

        }
        System.out.println(low);
        System.out.println(high);
        return (int) high;

    }

}
