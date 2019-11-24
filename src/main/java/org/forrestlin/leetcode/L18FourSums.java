package org.forrestlin.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * 四数之和
 * */
public class L18FourSums {

    public static void main(String[] args) {
        L18FourSums test = new L18FourSums();
        System.out.println(test.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0));
    }


    /*
     * 双指针法
     * */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;//四个最小值相加等于目标值，直接break
            }
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; j++) {

                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int begin = j + 1;
                int end = nums.length - 1;
                while (begin < end) {
                    if (begin > j + 1 && nums[begin] == nums[begin - 1]) {
                        begin++;
                        continue;
                    }
                    if (end < nums.length - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[begin] + nums[end];
                    if (sum == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[begin]);
                        list.add(nums[end]);
                        res.add(list);
                        end--;
                        begin++;

                    } else if (sum > target) {
                        end--;
                    } else {
                        begin++;
                    }
                }
            }
        }
        return res;
    }
}
