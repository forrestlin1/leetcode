package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 加一
 * @author: forrestlin
 * @create: 2019-12-03 19:57
 */
public class L66plusOne {


    /**
     * 题解中的解法，有两个点需要关注
     * */
    public int[] plusOne1(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i] % 10;
            //这里判断取余10不等于0，则说明加1完成了，如果取余10后等于0,则说明要进位，下一位继续加1
            if (digits[i] != 0) return digits;
        }
        //这里应对的是9999...的情况，加1后直接new一个，在前面补上1就行了
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }


    //我的解法，有待改进
    public int[] plusOne(int[] digits) {
        int ahead = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] + ahead > 9) {
                ahead = 1;
                digits[i] = digits[i] + ahead - 10;
            } else {
                digits[i] = digits[i] + ahead;
                ahead = 0;
            }
        }
        if (ahead == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for (int i = 0; i < digits.length; i++) {
                res[i + 1] = digits[i];
            }
            return res;
        }
        return digits;
    }

}
