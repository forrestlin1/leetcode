package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 寻找两个有序数组的中位数
 * @author: forrestlin
 * @create: 2019-09-11 17:07
 *
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 */
public class MedianOfTwoSortedArrays {

    public static void main(String[] args) {

        double res = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4});
        System.out.println(res);


    }

    /**
     * 双指针遍历两个数组 因为是有序的，根据大小顺序出队，并记录下标
     */
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int allLen = nums1.length + nums2.length;
        int midCurLeft = 0;
        int midCurRight = 0;
        int midLeft = 0;
        int midRight = 0;

        //奇数取中间个，偶数取中间两个的平均
        if (allLen % 2 == 1) {
            midCurLeft = midCurRight = allLen / 2;

        } else {
            midCurLeft = allLen / 2 - 1;
            midCurRight = midCurLeft + 1;
        }

        int i = 0, j = 0;
        int cur = 0;
        int curNum = 0;
        while (i < nums1.length || j < nums2.length) {

            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    curNum = nums1[i];
                    i = i + 1;
                } else {
                    curNum = nums2[j];
                    j = j + 1;
                }
            } else if (i < nums1.length) {
                curNum = nums1[i];
                i = i + 1;
            } else if (j < nums2.length) {
                curNum = nums2[j];
                j = j + 1;
            }

            if (cur == midCurLeft) {
                midLeft = curNum;
            }
            if (cur == midCurRight) {
                midRight = curNum;
                break;
            }

            cur++;


        }

        return ((double) (midLeft + midRight)) / 2;


    }

}
