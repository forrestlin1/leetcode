package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 只出现一次的数字
 * @author: forrestlin
 * @create: 2019-10-23 11:00
 */
public class L136SingleNumber {

    /**
     * 异或
     * a^b^a = b
     */
    public int singleNumber(int[] nums) {

        int res = 0;

        for (int num : nums) {
            res = res ^ num;
        }

        return res;
    }
}
