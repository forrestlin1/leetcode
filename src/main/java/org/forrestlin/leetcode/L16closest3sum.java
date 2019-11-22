package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 最接近的三数之和
 * @author: forrestlin
 * @create: 2019-11-22 16:56
 */
public class L16closest3sum {

    int mostNearDif = Integer.MAX_VALUE;
    int tar;

    //先排序，再用双指针法
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length - 2; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (Math.abs(target - ans) > Math.abs(target - sum)) {
                    ans = sum;
                }
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    start++;
                } else {
                    return ans;
                }

            }


        }
        return ans;
    }


    //回溯 超时了
    public int threeSumClosest1(int[] nums, int target) {
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        tar = target;
        backTrace(numList, new LinkedList<>());
        return target - mostNearDif;

    }

    private void backTrace(List<Integer> leastNum, List<Integer> tmp) {
        if (tmp.size() >= 3) {
            int dif = tar - (tmp.get(0) + tmp.get(1) + tmp.get(2));
            if (Math.abs(dif) < Math.abs(mostNearDif)) {
                mostNearDif = dif;
            }

        } else {
            for (int i = 0; i < leastNum.size(); i++) {

                Integer num = leastNum.get(i);
                List<Integer> curTmp = new LinkedList<>(tmp);
                curTmp.add(num);
                List<Integer> curleastNum = new LinkedList<>(leastNum);
                curleastNum.remove(i);
                backTrace(curleastNum, curTmp);
            }

        }

    }
}
