package org.forrestlin.leetcode.algorithm;

import java.util.LinkedList;
import java.util.List;

/*
* 最小栈
* */
public class L155MinStack {

}

class MinStack {

    private List<Integer> vals;
    int min = Integer.MIN_VALUE;
    int minCnt = 1;

    public MinStack() {
        vals = new LinkedList<>();
    }

    public void push(int x) {
        vals.add(x);
        if (x == min) {
            minCnt++;
        } else {
            min = Math.min(x, min);
            minCnt = 1;
        }

    }

    public void pop() {
        int val = vals.get(0);
        vals.remove(0);
        if (val == min) {

        }
    }

    public int top() {

        return vals.get(0);
    }

    public int getMin() {
        return min;
    }
}