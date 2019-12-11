package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集
 */
public class L90subsetsII {

    public static void main(String[] args) {
        L90subsetsII test = new L90subsetsII();
        System.out.println(test.subsetsWithDup(new int[]{1, 2, 2, 3}));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        if (null == nums || 0 == nums.length) {
            return res;
        }
        res.add(new ArrayList<>());
        Arrays.sort(nums);
        //包含多少个元素的子集
        for (int i = 1; i <= nums.length; i++) {
            backTrace(i, 0, new ArrayList<>(), nums);
        }
        return res;
    }

    private void backTrace(int k, int start, List<Integer> tmpList, int[] nums) {
        if (k == 0) {
            res.add(new ArrayList<>(tmpList));
        }

        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            tmpList.add(nums[i]);
            backTrace(k - 1, i + 1, tmpList, nums);
            tmpList.remove(tmpList.size() - 1);
        }


    }
}
