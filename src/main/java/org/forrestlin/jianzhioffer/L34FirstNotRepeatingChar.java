package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 第一个只出现一次的字符
 * @author: forrestlin
 * @create: 2019-11-18 10:20
 */
public class L34FirstNotRepeatingChar {

    public int FirstNotRepeatingChar(String str) {
        if (null == str || "".equals(str)) {
            return -1;
        }

        int[] count = new int[256];

        for (char c : str.toCharArray()) {
            count[c]++;
        }

        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                return i;
            }
        }

        return 0;
    }

}
