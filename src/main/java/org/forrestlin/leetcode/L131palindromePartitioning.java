package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 分割回文子串
 * */
public class L131palindromePartitioning {

    public static void main(String[] args) {
        L131palindromePartitioning test = new L131palindromePartitioning();
        System.out.println(test.partition("cdd"));
    }

    /***
     * 先缓存是否回文子串计算结果
     * */
    public List<List<String>> partition1(String s) {
        int len = s.length();
        List<List<String>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }

        // 预处理
        // 状态：dp[i][j] 表示 s[i][j] 是否是回文
        boolean[][] dp = new boolean[len][len];
        // 状态转移方程：在 s[i] == s[j] 的时候，dp[i][j] 参考 dp[i + 1][j - 1]
        for (int right = 0; right < len; right++) {
            // 注意：left <= right 取等号表示 1 个字符的时候也需要判断
            for (int left = 0; left <= right; left++) {
                if (s.charAt(left) == s.charAt(right) && (right - left <= 2 || dp[left + 1][right - 1])) {
                    dp[left][right] = true;
                }
            }
        }

        Stack<String> stack = new Stack<>();
        backtracking(s, 0, len, dp, stack, res);
        return res;
    }

    private void backtracking(String s, int start, int len, boolean[][] dp, Stack<String> path, List<List<String>> res) {
        if (start == len) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < len; i++) {

            // 剪枝
            if (!dp[start][i]) {
                continue;
            }
            path.add(s.substring(start, i + 1));
            backtracking(s, i + 1, len, dp, path, res);
            path.pop();
        }
    }


    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0) {
            return res;
        }
        backTrace(s, new Stack<>());
        return res;
    }

    private void backTrace(String rs, Stack<String> tmp) {
        if (rs == null || rs.length() == 0) {
            res.add(new ArrayList<>(tmp));
            return;
        }

        for (int i = 1; i <= rs.length(); i++) {

            String tmpS = rs.substring(0, i);

            if (isPalindrome(tmpS)) {
                tmp.add(tmpS);

                backTrace(rs.substring(i), tmp);
                tmp.pop();
            }

        }


    }

    private boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        int low = 0;
        int high = s.length() - 1;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) {
                return false;
            } else {
                low++;
                high--;
            }
        }
        return true;

    }

}
