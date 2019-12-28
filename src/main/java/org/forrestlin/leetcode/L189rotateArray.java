package org.forrestlin.leetcode;

import java.util.Arrays;

/**
 * 旋转数组
 */
public class L189rotateArray {

    public static void main(String[] args) {
        L189rotateArray test = new L189rotateArray();
        int[] tmp = new int[]{1, 2, 3, 4, 5, 6};
        test.rotate(tmp, 2);
        System.out.println(Arrays.toString(tmp));
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        while (k > 0) {
            //旋转一个
            int tmp = nums[nums.length - 1];
            for (int i = nums.length - 1; i >= 1; i--) {
                nums[i] = nums[i - 1];
            }
            nums[0] = tmp;

            k--;
        }
    }

    /*
    *
原始数组                  : 1 2 3 4 5 6 7
反转所有数字后             : 7 6 5 4 3 2 1
反转前 k 个数字后          : 5 6 7 4 3 2 1
反转后 n-k 个数字后        : 5 6 7 1 2 3 4 --> 结果

    * */
    public void rotate1(int[] nums, int k) {

        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    /*
     * 循环替换
     * */
    public void rotate2(int[] nums, int k) {
        k = k % nums.length;
        int count = 0;
        //这层循环是考虑
        //nums: [1, 2, 3, 4, 5, 6]
        //k: 2
        //1-》3-》5-》1
        //2-》4-》6-》2

        for (int start = 0; count < nums.length; start++) {
            int current = start;
            int prev = nums[start];
            do {
                int next = (current + k) % nums.length;
                int temp = nums[next];
                nums[next] = prev;
                prev = temp;
                current = next;
                count++;
            } while (start != current);
        }
    }


}
