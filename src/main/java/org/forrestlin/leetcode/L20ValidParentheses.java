package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 有效的括号
 * @author: forrestlin
 * @create: 2019-09-25 15:45
 */
public class L20ValidParentheses {

    private Map<String, String> coupleMap = new HashMap<String, String>() {{
        put("]", "[");
        put("}", "{");
        put(")", "(");
    }};

    public boolean isValid(String s) {
        if (null == s || "".equals(s)) {
            return true;
        }

        Stack<String> stack = new Stack<>();
        for (char c : s.toCharArray()) {

            String cur = String.valueOf(c);
            String curR = coupleMap.get(cur);
            if (!stack.empty() && stack.peek().equals(curR)) {
                stack.pop();
            } else {
                stack.push(cur);
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }


    }

}
