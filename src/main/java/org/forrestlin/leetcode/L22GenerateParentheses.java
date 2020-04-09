package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 括号生成
 * @author: forrestlin
 * @create: 2019-09-26 19:33
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [ "((()))", "(()())", "(())()", "()(())", "()()()" ]
 */
public class L22GenerateParentheses {

    public static void main(String[] args) {
        L22GenerateParentheses test = new L22GenerateParentheses();
        System.out.println(test.generateParenthesis(3));
    }

    /**
     * 方法二：回溯法
     * <p>
     * 思路和算法
     * <p>
     * 只有在我们知道序列仍然保持有效时才添加 '(' or ')'，而不是像 方法一 那样每次添加。我们可以通过跟踪到目前为止放置的左括号和右括号的数目来做到这一点，
     * <p>
     * 如果我们还剩一个位置，我们可以开始放一个左括号。 如果它不超过左括号的数量，我们可以放一个右括号。
     */
    public List<String> generateParenthesis(int n) {

        if (n == 0) {
            return new ArrayList<>();
        }

        List<String> res = new ArrayList<>();
        doGenerate(res, 0, 0, n, "");

        return res;

    }

    public void doGenerate(List<String> res, int open, int close, int max, String cur) {

        if (cur.length() == 2 * max) {
            res.add(cur);
            return;
        }

        if (open < max) {
            doGenerate(res, open + 1, close, max, cur + "(");
        }

        if (close < open) {
            doGenerate(res, open, close + 1, max, cur + ")");
        }


    }


    public List<String> generateParenthesis_bd(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        List<String> res = new ArrayList<>();
        backTrace(res, 0, 0, n, "String cur");
        return res;
    }

    public void backTrace(List<String> res, int left, int right, int max, String cur) {
        if (left + right == 2 * max) {
            res.add(cur);
        }

        if (left > right) {
            backTrace(res, left, right + 1, max, cur + ")");
        }
        if (left < max) {
            backTrace(res, left + 1, right, max, cur + "(");
        }

    }

}
