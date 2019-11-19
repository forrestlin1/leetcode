package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 圈中最后剩下的数
 * @author: forrestlin
 * @create: 2019-11-19 14:59
 */
public class L46LastRemaining {

    public static void main(String[] args) {
        L46LastRemaining test = new L46LastRemaining();
        System.out.println(test.LastRemaining_Solution(5, 3));
    }

    public int LastRemaining_Solution(int n, int m) {
        if (n <= 0) {
            return -1;
        }
        List<Integer> remain = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            remain.add(i);
        }
        int cur = 0;
        while (remain.size() > 1) {
            int size = remain.size();
            int steps = m;
            while (steps - 1 > 0) {
                if (cur == remain.size() - 1) {
                    cur = 0;
                } else {
                    cur++;
                }
                steps--;
            }
            if (cur == remain.size() - 1) {
                remain.remove(remain.size() - 1);

                cur = 0;
            } else {
                remain.remove(cur);
            }

        }
        return remain.get(0);
    }

}
