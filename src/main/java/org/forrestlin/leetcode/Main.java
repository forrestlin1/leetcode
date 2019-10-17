package org.forrestlin.leetcode;

import java.util.Comparator;
import java.util.Date;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: main
 * @author: forrestlin
 * @create: 2019-09-09 15:11
 */
public class Main {

    public static void main(String[] args) {

        Byte a = 1;
        Integer b = 1;
        System.out.println(a.equals(b));

    }

    //标准二分查找 left_bound
    //整个过程为low向目标逼近的过程
    //如果数组中存在目标，则返回目标的第一个下标
    //如果数组中不存在目标，-1
    public static int binarySearch(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        //这里因为high = length-1 整个为闭区间，所以low要<=high 而不是<high
        while (low <= high) {
            //用low+high/2可能会溢出
            int mid = low + (high - low) / 2;

            if (target > nums[mid]) {
                low = mid + 1;
            }
            if (target <= nums[mid]) {
                high = mid - 1;
            }

        }
        if (low <= nums.length - 1 && nums[low] == target) {
            return low;
        } else {
            return -1;
        }

    }

    //标准二分查找 right_bound
    //整个过程为high向目标逼近的过程
    //如果数组中存在目标，则返回目标的第最后下标
    //如果数组中不存在目标，-1
    public static int binarySearch1(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            //用low+high/2可能会溢出
            int mid = low + (high - low) / 2;
            if (target >= nums[mid]) {
                low = mid + 1;
            }
            if (target < nums[mid]) {
                high = mid - 1;
            }

            if (high >= 0 && nums[high] == target) {
                return high;
            } else {
                return -1;
            }


        }

        return -1;
    }


}

