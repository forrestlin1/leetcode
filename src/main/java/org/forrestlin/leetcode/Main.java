package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: main
 * @author: forrestlin
 * @create: 2019-09-09 15:11
 */
public class Main {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{0, 1, 1, 1, 2, 3, 5, 7, 8}, 4));
    }

    public static int binarySearch(int[] arr, int val) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println("low:" + low + " mid: " + mid + " high: " + high);
            if (val > arr[mid]) {
                low = mid + 1;
            }
            if (val <= arr[mid]) {
                high = mid - 1;
            }

        }

        return low;

    }

    public int[] searchRange(int[] nums, int target) {
        if (null == nums || 0 == nums.length) {
            return new int[]{-1, -1};
        }

        int i = binarySearch(nums, target);
        if (nums[i] != target) {
            return new int[]{-1, -1};

        } else {

            int end = i;
            for (; end < nums.length; end++) {
                if (nums[end] != target) {
                    break;
                }
            }

            if (nums[end] == target) {

                return new int[]{i, end};
            } else {
                return new int[]{i, end - 1};

            }

        }


    }

}

