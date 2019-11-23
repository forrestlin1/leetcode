package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 翻转单词顺序列
 * @author: forrestlin
 * @create: 2019-11-18 18:06
 */
public class L44ReverseSentence {

    public static void main(String[] args) {
        L44ReverseSentence test = new L44ReverseSentence();
        System.out.println(test.ReverseSentence("student am i"));
    }

    public String ReverseSentence(String str) {
        if (null == str || str.length() <= 1) {
            return str;
        }
        str = " " + str;
        int lastI = str.length();
        StringBuilder sb = new StringBuilder("");
        for (int i = str.length() - 1; i >= 0; i--) {
            if (" ".equals(str.charAt(i) + "")) {
                sb.append(str.substring(i + 1, lastI)).append(" ");
                lastI = i;
            }

        }

        String res = sb.toString();

        return res.substring(0, res.length() - 1);

    }
}
