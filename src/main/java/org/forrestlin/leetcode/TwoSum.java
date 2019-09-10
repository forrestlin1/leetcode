package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 两数之和
 * @author: forrestlin
 * @create: 2019-09-09 15:17
 *
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *
 * 给定 nums = [2, 7, 11, 15], target = 9
 *
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/two-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 */
public class TwoSum {

    /**
     * 1.空间换时间
     * 遍历一遍数组
     * 将{num,i}存到map里面
     * 遍历的时候get(target-当前num)，获取得到则满足要求
     */
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

    /**
     * 2.暴力解法
     * 双层循环判断
     */
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
