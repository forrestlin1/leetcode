package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 左旋转字符串
 * @author: forrestlin
 * @create: 2019-11-18 18:00
 */
public class L43LeftRotateString {

    public static void main(String[] args) {
        L43LeftRotateString test = new L43LeftRotateString();
        System.out.println(test.LeftRotateString("abc", 10));
    }

    public String LeftRotateString(String str, int n) {
        if (null == str || str.length() <= 1) {
            return str;
        }
        int change = n % str.length();
        return str.substring(change) + str.substring(0, change);
    }
}
