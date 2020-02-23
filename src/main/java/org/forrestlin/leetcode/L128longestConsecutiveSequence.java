package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 最长连续序列
 */
public class L128longestConsecutiveSequence {

    /*
    *
    * 题目要求 O(n) 复杂度。

用哈希表存储每个端点值对应连续区间的长度
若数已在哈希表中：跳过不做处理
若是新数加入：
取出其左右相邻数已有的连续区间长度 left 和 right
计算当前数的区间长度为：cur_length = left + right + 1
根据 cur_length 更新最大长度 max_length 的值
更新区间两端点的长度值
    *
    * */
    public int longestConsecutive(int[] nums) {

        if (null == nums || 0 == nums.length) {
            return 0;
        }
        //遍历元素时存储每个元素的最长递增序列
        Map<Integer, Integer> lenMap = new HashMap<>();
        int maxlen = 0;
        for (int num : nums) {
            if (lenMap.get(num) == null) {
                int left = lenMap.getOrDefault(num - 1, 0);
                int right = lenMap.getOrDefault(num + 1, 0);
                int len = left + 1 + right;
                maxlen = Math.max(len, maxlen);
                lenMap.put(num, len);
                lenMap.put(num - left, len);
                lenMap.put(num + right, len);
            }
        }
        return maxlen;

    }
}
