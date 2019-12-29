package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 */
public class L13romanToInteger {

    /**
     * 。首先建立一个HashMap来映射符号和值，然后对字符串从左到右来，如果当前字符代表的值不小于其右边，就加上该值；否则就减去该值。以此类推到最左边的数，最终得到的结果即是答案
     */
    public int romanToInt(String s) {
        Map<Character, Integer> vau = new HashMap<>();
        vau.put('I', 1);
        vau.put('V', 5);
        vau.put('X', 10);
        vau.put('L', 50);
        vau.put('C', 100);
        vau.put('D', 500);
        vau.put('M', 1000);
        int res = 0;
        for (int i = s.length() - 1; i >= 0; i--) {

            if (i < s.length() - 1 && vau.get(s.charAt(i)) < vau.get(s.charAt(i + 1))) {
                res -= vau.get(s.charAt(i));
            } else {
                res += vau.get(s.charAt(i));
            }

        }

        return res;


    }

    /**
     * 高效率的方式，不用map
     */
    public int romanToInt1(String s) {
        if (null == s || s.length() == 0) {
            return 0;
        }

        int res = 0;
        int pre = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            int cur = getNum(s.charAt(i));
            if (cur >= pre) {
                res += cur;
            } else {
                res -= cur;
            }
            pre = cur;
        }
        return res;
    }

    private int getNum(char c) {
        int res = 0;
        switch (c) {
            case 'I':
                res = 1;
                break;
            case 'V':
                res = 5;
                break;
            case 'X':
                res = 10;
                break;
            case 'L':
                res = 50;
                break;
            case 'C':
                res = 100;
                break;
            case 'D':
                res = 500;
                break;
            case 'M':
                res = 1000;
                break;
            default:
                res = -1;
        }
        return res;
    }

}
