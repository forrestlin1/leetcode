package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 在排序数组中寻找元素的第一个和最后一个位置
 * @author: forrestlin
 * @create: 2019-09-29 20:08
 *
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 *
 * 你的算法时间复杂度必须是 O(log n) 级别。
 *
 * 如果数组中不存在目标值，返回 [-1, -1]。
 *
 * 示例 1:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 *
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 *
 */
public class L34FindFirstAndLastPositionOfElementInSortedArray {

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return new int[]{-1, -1};
        }

        int i = binarySearch(nums, target);
        //target大于数组所有值，返回的是nums.length，可能数组越界
        if (i >= nums.length || nums[i] != target) {
            return new int[]{-1, -1};

        } else {

            int end = i;
            for (; end < nums.length; end++) {
                if (nums[end] != target) {
                    break;
                }
            }
            //可能数组越界，故判断end < nums.length
            if (end < nums.length && nums[end] == target) {

                return new int[]{i, end};
            } else {
                return new int[]{i, end - 1};

            }

        }
    }

    //标准二分查找 left_bound
    //整个过程为low向目标逼近的过程
    //如果数组中存在目标，则返回目标的第一个下标
    //如果数组中不存在目标，则返回第一个大于目标的下标（可能溢出）
    public static int binarySearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            //用low+high/2可能会溢出
            int mid = low + (high - low) / 2;

            if (val > arr[mid]) {
                low = mid + 1;
            }
            if (val <= arr[mid]) {
                high = mid - 1;
            }

        }

        return low;

    }
}
