package org.forrestlin.leetcode;

/**
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0 输出: 4 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3 输出: -1
 */
public class L33SearchInRotatedSortedArray {


    public static void main(String[] args) {
        L33SearchInRotatedSortedArray test = new L33SearchInRotatedSortedArray();
        //System.out.println(test.search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(test.search_bd(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
    }

    /*   5
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


    public int search_bd(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[low] > nums[mid]) {
                if (nums[mid] > target && nums[high] >= target) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            } else {
                if (nums[low] <= target && nums[mid] > target) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }

        }
        return -1;

    }
}
