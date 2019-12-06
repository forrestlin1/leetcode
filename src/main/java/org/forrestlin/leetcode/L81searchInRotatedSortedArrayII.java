package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 搜索旋转排序数组II
 * @author: forrestlin
 * @create: 2019-12-06 10:47
 */
public class L81searchInRotatedSortedArrayII {


    public static void main(String[] args) {
        L81searchInRotatedSortedArrayII test = new L81searchInRotatedSortedArrayII();
        System.out.println(test.search(new int[]{1, 1, 3, 1}, 3));
    }

    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
                //这里相等的情况，无法使用二分搜索，只能先缩小范围
            } else if (nums[mid] == nums[right]) {
                if (nums[mid] == nums[left]) {
                    left++;
                } else {
                    right--;
                }
            }
            //旋转的地方在左边，有序的地方在右边，判断target是否在右边
            else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
                //旋转的地方在右边，有序的地方在左边，判断target是否在左边
            } else {
                if (nums[left] <= target && nums[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return false;


    }
}
