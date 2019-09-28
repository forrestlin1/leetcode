package org.forrestlin.leetcode;

public class L33SearchInRotatedSortedArray {


    public static void main(String[] args) {
        L33SearchInRotatedSortedArray test = new L33SearchInRotatedSortedArray();
        //System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(test.search(new int[]{1, 3}, 3));
    }

    /*  5
    * 4 5
    * 4 5       3
    * 4 5     2 3
    * 4 5 0 1 2 3
    * 如上图，如果num[left]<num[mid]则旋转的地方在右边，判断target是否在左边，是的话向左归约
    * 如果num[mid]<num[right] 则旋转的地方在左边，判断target是否在右边，是的话向右规约
    *
    * */
    public int search(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return -1;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
                //旋转的地方在左边，有序的地方在右边，判断target是否在右边
            } else if (nums[mid] < nums[right]) {
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
        return -1;

    }
}
