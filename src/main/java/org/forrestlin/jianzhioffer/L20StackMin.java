package org.forrestlin.jianzhioffer;

import java.util.Stack;

/**
 * @program: leetcode
 * @description: 包含min函数的栈
 * @author: forrestlin
 * @create: 2019-11-12 17:52
 */
public class L20StackMin {

    Stack<Integer> v = new Stack<>();
    Stack<Integer> min = new Stack<>();

    public void push(int node) {
        v.push(node);
        if (min.isEmpty() || node < min.peek()) {
            min.push(node);
        } else {
            min.push(min.peek());
        }

    }

    public void pop() {
        v.pop();
        min.pop();
    }

    public int top() {
        return v.peek();
    }

    public int min() {
        return min.peek();
    }
}
