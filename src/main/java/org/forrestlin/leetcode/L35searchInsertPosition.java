package org.forrestlin.leetcode;

/**
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 你可以假设数组中无重复元素。
 *
 * 示例 1:
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * 示例 2:
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * */
public class L35searchInsertPosition {

    public static void main(String[] args) {

        L35searchInsertPosition test = new L35searchInsertPosition();
        System.out.println(test.searchInsert(new int[]{1, 3, 5, 6}, 5));
        System.out.println(2 + ((3 - 2) >> 1));
    }


    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > nums[mid]) {
                low = mid + 1;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }
            if (target == nums[mid]) {
                return mid;
            }

        }
        return low;


    }


}
