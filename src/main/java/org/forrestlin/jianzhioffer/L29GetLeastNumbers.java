package org.forrestlin.jianzhioffer;

/*
 * 数组中前k大的数字
 * */

import java.util.ArrayList;
import java.util.PriorityQueue;

/*
 * 最小的K个数
 * */
public class L29GetLeastNumbers {

    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if (null == input || input.length == 0 || k == 0 || k > input.length) {
            return res;
        }

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i : input) {
            q.add(i);
        }
        while (k > 0) {
            res.add(q.poll());
            k--;
        }
        return res;

    }
}
