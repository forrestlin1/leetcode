package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 在排序数组中寻找元素的第一个和最后一个位置
 * @author: forrestlin
 * @create: 2019-09-29 20:08
 */
public class L34 {

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

    //标准二分查找
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
