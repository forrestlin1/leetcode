package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 翻转字符串里的单词
 * @author: forrestlin
 * @create: 2019-12-27 15:14
 */
public class L151reverseWordsInAString {

    public static void main(String[] args) {
        L151reverseWordsInAString test = new L151reverseWordsInAString();
        System.out.println(test.reverseWords("hello world"));
    }

    public String reverseWords(String s) {
        if (s == null||s.length() ==0) {
            return "";
        }

        s = s.trim();
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = ss.length - 1; i >= 0; i--) {
            if (ss[i].length() > 0) {
                sb.append(ss[i]);
                sb.append(" ");
            }

        }

        String res = sb.toString();
        if (res.length() == 0) {
            return "";
        }
        return res.substring(0, res.length() - 1);
    }



}
