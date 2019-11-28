package org.forrestlin.leetcode;

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
