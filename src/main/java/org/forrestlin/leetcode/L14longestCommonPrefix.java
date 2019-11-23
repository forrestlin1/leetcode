package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 最长公共前缀
 * @author: forrestlin
 * @create: 2019-11-22 16:26
 */
public class L14longestCommonPrefix {

    public static void main(String[] args) {
        L14longestCommonPrefix test = new L14longestCommonPrefix();
        System.out.println(test.longestCommonPrefix(new String[]{"a", ""}));
    }

    public String longestCommonPrefix(String[] strs) {
        String res = "";
        if (strs == null || strs.length == 0) {
            return res;
        }
        if (strs.length == 1) {
            return strs[0];
        }

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            boolean isCommon = true;
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() - 1 < i || strs[j].charAt(i) != c) {
                    isCommon = false;
                    break;
                }

            }

            if (isCommon) {
                res += c;
            } else {
                break;
            }
        }

        return res;
    }
}
