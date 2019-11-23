package org.forrestlin.jianzhioffer;

import java.util.regex.Pattern;

/**
 * @program: leetcode
 * @description: 表示数值的字符串
 * @author: forrestlin
 * @create: 2019-11-20 16:16
 */
public class L53isNumeric {

    public boolean isNumeric(char[] str) {


        String pattern = "^[-+]?\\d*(?:\\.\\d*)?(?:[eE][+\\-]?\\d+)?$";
        String s = new String(str);
        return Pattern.matches(pattern,s);

    }
}
