package org.forrestlin.jianzhioffer;

import java.util.Stack;

/*
 * 两个栈实现队列
 * */
public class L5Stack {

    //写
    Stack<Integer> stack1 = new Stack<Integer>();
    //读
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }

        stack2.push(node);

    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }

        return stack2.pop();

    }
}
