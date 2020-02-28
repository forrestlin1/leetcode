package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 组合总合
 * @author: forrestlin
 * @create: 2019-09-30 11:56
 *
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的数字可以无限制重复被选取。
 *
 * 说明：
 *
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 *
 * 输入: candidates = [2,3,6,7], target = 7,
 * 所求解集为:
 * [
 *   [7],
 *   [2,2,3]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,3,5], target = 8,
 * 所求解集为:
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 *
 */
public class L39CombinationSum {

    List<List<Integer>> res = new ArrayList<>();
    int[] candidates;


    public static void main(String[] args) {
        L39CombinationSum test = new L39CombinationSum();

        System.out.println(test.combinationSum(new int[]{2, 3, 6, 7}, 7));
    }

    /**
     * 回溯法，一直减去candidates的值，直到减为0，记录数组
     */
    public List<List<Integer>> combinationSum(int[] candidates1, int target) {

        candidates = candidates1;
        //这里排序后，方便后面剪枝和去重复
        Arrays.sort(candidates);
        downInto(target, new ArrayList<>(), 0);
        return res;

    }

    public void downInto(int target, List<Integer> curRes1, int start) {
        //因为已经排序了 candidates[i] <= target 之后就不需要判断了
        for (int i = start; i < candidates.length && candidates[i] <= target; i++) {

            int newTarget = target - candidates[i];

            List<Integer> curRes = new ArrayList<>();

            curRes.addAll(curRes1);

            if (newTarget == 0) {
                curRes.add(candidates[i]);
                res.add(curRes);

            } else if (newTarget < 0) {

            } else if (newTarget > 0) {
                curRes.add(candidates[i]);
                List<Integer> newList = new ArrayList<>();
                newList.addAll(curRes);
                //这里start传入i，避免回到candidates头部取值，也就能避免最后重复
                downInto(newTarget, newList, i);
            }


        }


    }

}
