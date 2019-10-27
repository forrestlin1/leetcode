package org.forrestlin.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * 最小栈
 * */
public class L155MinStack {

    /**
     * 一个栈存数值，一个栈存最小值 关键点：当压栈值小于当前helper顶的值的时候，压入当前的最小值到helper 如果x大于helper栈顶元素，则再压入一个栈顶元素占位
     */
    private Stack<Integer> vals;
    private Stack<Integer> helper;

    public L155MinStack() {
        vals = new Stack<>();
        helper = new Stack<>();
    }

    public void push(int x) {
        vals.push(x);
        if (helper.isEmpty()) {
            helper.push(x);
        } else if (helper.peek() > x) {
            helper.push(x);
        } else {
            helper.push(helper.peek());
        }


    }

    public void pop() {
        vals.pop();
        helper.pop();
    }

    public int top() {

        return vals.peek();
    }

    public int getMin() {
        return helper.peek();
    }
}


