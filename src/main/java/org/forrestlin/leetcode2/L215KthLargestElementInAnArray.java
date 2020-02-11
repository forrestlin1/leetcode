package org.forrestlin.leetcode2;

import java.util.PriorityQueue;

/**
 * 数组中最K大的元素
 */
public class L215KthLargestElementInAnArray {

    public static void main(String[] args) {
        L215KthLargestElementInAnArray test = new L215KthLargestElementInAnArray();
        System.out.print(test.findKthLargest(new int[]{1, 4, 5, 2, 3}, 3));
    }


    /**
     * 使用优先队列
     */
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int num : nums) {
            q.add(num);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();

    }
}
