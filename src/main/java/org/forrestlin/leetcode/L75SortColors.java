package org.forrestlin.leetcode;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 颜色分类
 * @author: forrestlin
 * @create: 2019-10-18 15:28
 */
public class L75SortColors {

    public static void main(String[] args) {
        L75SortColors test = new L75SortColors();
        int[] a = new int[]{1,2,0};
        test.sortColors(a);
        System.out.println(Arrays.asList(a));
    }

    public void sortColors(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        int left = 0, right = nums.length - 1, cur = 0;

        while (cur <= right) {

            if (nums[cur] == 0) {
                nums[cur++] = nums[left];
                nums[left] = 0;
                left++;
            }
            if (nums[cur] == 2) {
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
            } else {
                cur++;
            }

        }


    }
}
