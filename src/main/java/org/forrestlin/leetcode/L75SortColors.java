package org.forrestlin.leetcode;

import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 颜色分类
 * @author: forrestlin
 * @create: 2019-10-18 15:28
 */
public class L75SortColors {

    public static void main(String[] args) {
        L75SortColors test = new L75SortColors();
        int[] a = new int[]{1, 2, 0};
        test.sortColors(a);

        for (int i : a) {

            System.out.println(i);
        }

    }
/**
 * 我们用三个指针（left, right 和cur）来分别追踪0的最右边界，2的最左边界和当前考虑的元素,向右遍历树组，遇到0则和left替换
 * 遇到2则和right替换。
 *
 * */
    public void sortColors(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return;
        }
        int left = 0, right = nums.length - 1, cur = 0;

        while (cur <= right) {

            if (nums[cur] == 0) {
                nums[cur] = nums[left];
                nums[left] = 0;
                left++;
                //注意   这里只有等于0时候需要cur++因为左边是指针遍历过了，没问题的数组，而右边替换后，可能把一个0替换回来
                //这个时候就需要继续替换了
                cur++;
            } else if (nums[cur] == 2) {
                nums[cur] = nums[right];
                nums[right] = 2;
                right--;
            } else if (nums[cur] == 1) {
                cur++;

            }

        }


    }
}
