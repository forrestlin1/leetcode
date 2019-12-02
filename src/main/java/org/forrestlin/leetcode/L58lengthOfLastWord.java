package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 最后一个单词的长度
 * @author: forrestlin
 * @create: 2019-12-02 19:45
 */
public class L58lengthOfLastWord {

    public static void main(String[] args) {
        L58lengthOfLastWord test = new L58lengthOfLastWord();
        System.out.println(test.lengthOfLastWord(" "));
    }

    public int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            end--;
        }
        if (end < 0) {
            return 0;
        }
        int start = end;
        while (start >= 0 && s.charAt(start) != ' ') {
            start--;
        }
        return end - start;
    }


}
