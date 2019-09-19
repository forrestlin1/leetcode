package org.forrestlin.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 无重复字符最长子串
 * @author: forrestlin
 * @create: 2019-09-10 18:21
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 */
public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String a = "abcabcbb";
        //"abcabcbb";
        int c = lengthOfLongestSubstring3(a);
        System.out.println(c);

    }

    /**
     * 暴力双循环解法，超时了
     */
    public static int lengthOfLongestSubstring(String s) {

        if (null == s || s.length() == 0) {
            return 0;
        }

        int max = 1;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j < s.length(); j++) {
                if (isContainDuplicateChar(s.substring(i, j + 1))) {
                    if (j - i > max) {
                        max = j - i;
                    }
                    break;
                }

                if (j == s.length() - 1 && j - i + 1 > max) {
                    max = j - i + 1;
                }

            }


        }

        return max;
    }

    public static boolean isContainDuplicateChar(String s) {

        if (s.length() == 1) {
            return false;
        }

        Set<Character> cnt = new HashSet<>();

        for (char c : s.toCharArray()) {
            cnt.add(c);
        }

        if (cnt.size() != s.length()) {
            return true;
        }

        return false;

    }

    /**
     * 滑动窗口子串，遍历过程中，如果发现子串出现当前字符串，则计算现子串的长度，并截取子串中当前字符的位置以后的子串
     */
    public static int lengthOfLongestSubstring2(String s) {

        int maxLen = s.length() == 0 ? 0 : 1;

        int tempLen = 0;
        String tempStr = "";
        for (int i = 0; i < s.length(); i++) {
            if (tempStr.indexOf(s.charAt(i)) > -1) {
                tempStr = tempStr.substring(tempStr.indexOf(s.charAt(i)) + 1) + s.charAt(i);
                maxLen = tempLen > maxLen ? tempLen : maxLen;
                tempLen = tempStr.length();
                continue;
            }
            tempStr = tempStr + s.charAt(i);
            tempLen++;

        }
        maxLen = tempLen > maxLen ? tempLen : maxLen;
        return maxLen;
    }

    /**
     * 其实就是一个队列,比如例题中的 abcabcbb，进入这个队列（窗口）为 abc 满足题目要求，当再进入 a，队列变成了 abca，这时候不满足要求。所以，我们要移动这个队列！
     *
     * 如何移动？
     *
     * 我们只要把队列的左边的元素移出就行了，直到满足题目要求！
     *
     * 一直维持这样的队列，找出队列出现最长的长度时候，求出解！
     *
     * left为滑动窗口左侧，
     */
    public static int lengthOfLongestSubstring3(String s) {

        if (s.length() == 1) {
            return 1;
        }
        Map<Character, Integer> chars = new HashMap<>();
        int max = 0;
        //滑动窗口左侧
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char currentChar = s.charAt(i);
            Integer oldCharCursor = chars.get(currentChar);
            if (oldCharCursor != null) {
                //这里要和left比较，是防止abba这种场景，指针挪到最后一个a时，取到重复的字符a是在第0位，此时left已经到2了，left只能向前
                left = oldCharCursor + 1 > left ? oldCharCursor + 1 : left;
            }
            max = i - left + 1 > max ? i - left + 1 : max;
            chars.put(currentChar, i);
        }
        return max;

    }

}
