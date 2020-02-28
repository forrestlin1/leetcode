package org.forrestlin.leetcode;

import java.util.Stack;
/**
 *
 * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 *
 * 示例 1:
 *
 * 输入: "(()"
 * 输出: 2
 * 解释: 最长有效括号子串为 "()"
 *
 *
 * */
public class L32LongestValidParentheses {

    public static void main(String[] args) {
        L32LongestValidParentheses test = new L32LongestValidParentheses();
        System.out.println(test.longestValidParentheses("(()()))"));


    }

    /**
     * 使用栈来匹配
     */
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            //左括号 入栈待匹配
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                //右括号 出栈
                stack.pop();
                if (stack.empty()) {
                    //右括号出栈后为空说明前面已经匹配完，从这个位置重新开始匹配
                    stack.push(i);
                } else {
                    //右括号出栈后不为空，说明当前字串满足条件，但是还没匹配完，先计算这个字串的长度
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}
