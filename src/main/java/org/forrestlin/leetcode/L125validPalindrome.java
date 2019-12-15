package org.forrestlin.leetcode;

/*
 * 验证回文串
 * */
public class L125validPalindrome {

    public static void main(String[] args) {
        L125validPalindrome test = new L125validPalindrome();
        System.out.println(test.isPalindrome("race a car"));
    }

    public boolean isPalindrome(String s) {
        if (null == s || s.length() < 2) {
            return true;
        }
        s = s.toLowerCase();
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            char lowC = s.charAt(low);
            char highC = s.charAt(high);
            if ((lowC >= 'a' && lowC <= 'a') || (lowC >= '0' && lowC <= '9')) {

                if ((highC >= 'a' && highC <= 'a') || (highC >= '0' && highC <= '9')) {

                    if (lowC != highC) {
                        return false;
                    } else {
                        high--;
                        low++;
                    }

                } else {
                    high--;
                }
            } else {
                low++;
            }

        }
        return true;

    }


}
