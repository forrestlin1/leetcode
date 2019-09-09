package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 两数之和
 * @author: forrestlin
 * @create: 2019-09-09 15:17
 */
public class TwoSum {


    public int[] twoSum(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (numMap.get(target - num) != null) {
                return new int[]{numMap.get(target - num), i};

            }

            numMap.put(num, i);

        }

        return null;


    }

    public int[] twoSum2(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return null;
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }

            }
        }
        return null;

    }

}
