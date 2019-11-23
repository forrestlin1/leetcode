package org.forrestlin.leetcode;

import java.util.Collections;

/**
 * @program: leetcode
 * @description: 回文数字
 * @author: forrestlin
 * @create: 2019-11-22 15:40
 */
public class L9palindromeNumber {

    public static void main(String[] args) {
        L9palindromeNumber test = new L9palindromeNumber();
        System.out.println(test.isPalindrome(1231));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        String xs = String.valueOf(x);
        int l = xs.length();
        for (int i = 0; i < l / 2; i++) {
            if (xs.charAt(i) != xs.charAt(l - i - 1)) {
                return false;
            }
        }

        return true;

    }
}
