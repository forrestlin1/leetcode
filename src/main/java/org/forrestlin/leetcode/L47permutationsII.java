package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 全排列II
 * @author: forrestlin
 * @create: 2019-11-29 11:01
 *
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 *
 * 示例:
 *
 * 输入: [1,1,2]
 * 输出:
 * [
 *   [1,1,2],
 *   [1,2,1],
 *   [2,1,1]
 * ]
 *
 */
public class L47permutationsII {

    public static void main(String[] args) {
        L47permutationsII test = new L47permutationsII();
        System.out.println(test.permuteUnique(new int[]{1, 1, 3}));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return res;
        }

        Arrays.sort(nums);
        List<Integer> numsLst = new LinkedList<>();
        for (int num : nums) {
            numsLst.add(num);
        }
        backTrace(numsLst, new ArrayList<>());
        return res;
    }

    public void backTrace(List<Integer> numsLst, List<Integer> tmp) {

        if (numsLst.size() == 1) {
            tmp.add(numsLst.get(0));
            res.add(tmp);
            return;
        }

        for (int i = 0; i < numsLst.size(); i++) {
            if (i > 0 && numsLst.get(i) == numsLst.get(i - 1)) {
                continue;
            }

            List<Integer> newtmp = new ArrayList<>();
            newtmp.addAll(tmp);
            newtmp.add(numsLst.get(i));
            List<Integer> leftnums = new ArrayList<>(numsLst);
            leftnums.remove(numsLst.get(i));
            backTrace(leftnums, newtmp);

        }

    }
}
