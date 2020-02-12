package org.forrestlin.leetcode5;

/*
* 字符串的排列
*
* 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。

换句话说，第一个字符串的排列之一是第二个字符串的子串。

示例1:

输入: s1 = "ab" s2 = "eidbaooo"
输出: True
解释: s2 包含 s1 的排列之一 ("ba").
*
* */
public class L567permutationInString {

    public static void main(String[] args) {
        L567permutationInString test = new L567permutationInString();
        System.out.println(test.checkInclusion("abc", "bbbca"));
    }

    /*
     * 滑动窗口，一个长度为s1的窗口，从左往右滑动
     * 每滑动一个位置，对应的计算窗口内的字符数与s1的字符数是否一致
     * 使用两个数组来存储着两个的字符分布
     * 滑动窗口时，考虑
     * */
    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) {
            return false;
        }
        //存储s1每个字符出现的个数（只会出现小写字母）
        int[] chars1 = new int[26];
        //存储s2每个字符出现的个数（只会出现小写字母）
        int[] chars2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars1[s1.charAt(i) - 'a']++;
            chars2[s2.charAt(i) - 'a']++;
        }
        //count代表26个小写字母中，有多少个字母的出现次数是一样的
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (chars1[i] == chars2[i]) {
                count++;
            }
        }
        //这里只关注窗口在往右滑动的时候，左边减少的一个字符，和右边增加的一个字符
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (26 == count) {
                return true;
            }
            int l = s2.charAt(i) - 'a';
            int r = s2.charAt(i + s1.length()) - 'a';

            //窗口右滑，最左边的字符串会去掉
            chars2[l]--;
            if (chars1[l] == chars2[l]) {
                count++;
                //注意这里，只有原来时相等的，也就是右滑之前时相等的，现在变成不相等了，才需要减少count
            } else if (chars1[l] == chars2[l] + 1) {
                count--;
            }

            //窗口右滑，最右边的字符串会加入到窗口中
            chars2[r]++;
            if (chars1[r] == chars2[r]) {
                count++;
            } else if (chars1[r] == chars2[r] - 1) {
                count--;
            }
        }

        return 26 == count;

    }
}
