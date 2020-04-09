package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 组合总合II
 * @author: forrestlin
 * @create: 2019-11-28 18:16
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。 解集不能包含重复的组合。  示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8, 所求解集为: [ [1, 7], [1, 2, 5], [2, 6], [1, 1, 6] ] 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5, 所求解集为: [   [1,2,2],   [5] ]
 */
public class L40combinationSumII {

    public static void main(String[] args) {
        L40combinationSumII test = new L40combinationSumII();
        System.out.println(test.combinationSum22_bd(new int[]{2, 5, 2, 1, 2}, 5));
    }

    public List<List<Integer>> combinationSum22(int[] candidates, int target) {
        int len = candidates.length;
        List<List<Integer>> res = new ArrayList<>();
        if (len == 0) {
            return res;
        }
        // 先将数组排序，这一步很关键
        Arrays.sort(candidates);
        findCombinationSum2(candidates, 0, len, target, new Stack<>(), res);
        return res;
    }


    // residue 表示剩余，这个值一开始等于 target，基于题目中说明的"所有数字（包括目标数）都是正整数"这个条件
    // residue 在递归遍历中，只会越来越小
    private void findCombinationSum2(int[] candidates, int begin, int len, int residue, Stack<Integer> stack, List<List<Integer>> res) {
        if (begin == 1 && stack.size() == 1) {
            System.out.println("");
        }
        if (residue == 0) {
            res.add(new ArrayList<>(stack));
            return;
        }

        for (int i = begin; i < len && residue - candidates[i] >= 0; i++) {
            // 这一步之所以能够生效，其前提是数组一定是排好序的，这样才能保证：
            // 在递归调用的统一深度（层）中，一个元素只使用一次。 比如 1,2,2,2,5  目标值是5
            //TODO 这一步剪枝操作基于 candidates 数组是排序数组的前提下
            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }
            stack.add(candidates[i]);
            // 【关键】因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            findCombinationSum2(candidates, i + 1, len, residue - candidates[i], stack, res);
            stack.pop();
        }
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combinationSum22_bd(int[] candidates, int target) {
        if (candidates == null || 0 == candidates.length) {
            return res;
        }
        Arrays.sort(candidates);

        backTrace(0, new ArrayList<>(), candidates, target);
        return res;
    }

    public void backTrace(int begin, List<Integer> tmpRes, int[] candidates, int resume) {
        if (resume == 0) {
            res.add(new ArrayList<>(tmpRes));
        }
        for (int i = begin; i < candidates.length && candidates[i] <= resume; i++) {

            if (i > begin && candidates[i] == candidates[i - 1]) {
                continue;
            }

            tmpRes.add(candidates[i]);
            backTrace(i + 1, tmpRes, candidates, resume - candidates[i]);
            tmpRes.remove(tmpRes.size() - 1);

        }
    }


}
