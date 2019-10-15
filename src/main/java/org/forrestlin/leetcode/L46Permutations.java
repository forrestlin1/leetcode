package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 全排列
 * @author: forrestlin
 * @create: 2019-10-12 11:05
 *
 * 给定一个没有重复数字的序列，返回其所有可能的全排列。
 *
 * 示例:
 *
 * 输入: [1,2,3]
 * 输出:
 * [
 *   [1,2,3],
 *   [1,3,2],
 *   [2,1,3],
 *   [2,3,1],
 *   [3,1,2],
 *   [3,2,1]
 * ]
 */
public class L46Permutations {

    public static void main(String[] args) {
        L46Permutations test = new L46Permutations();
        System.out.println(test.permute(new int[]{1,2}));
    }

    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) {
            return new ArrayList<>();
        }
        List<Integer> numsLst = new LinkedList<>();
        for (int num : nums) {
            numsLst.add(num);
        }

        downInto(numsLst, new ArrayList<>());
        return res;

    }

    private void downInto(List<Integer> nums, List<Integer> tempRes) {

        if (nums.size() == 1) {
            List<Integer> tempResult = new LinkedList<>(tempRes);
            tempResult.add(nums.get(0));
            res.add(tempResult);
            return;
        }

        for (Integer num : nums) {
            List<Integer> leftnums = new ArrayList<>(nums);
            List<Integer> tempResult = new LinkedList<>(tempRes);
            leftnums.remove(num);
            tempResult.add(num);
            downInto(leftnums, tempResult);
        }


    }

}
