package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 删除数组的重复项II
 * @author: forrestlin
 * @create: 2019-12-05 20:29
 */
public class L80removeDuplicatesFromSortedArrayII {

    public static void main(String[] args) {
        L80removeDuplicatesFromSortedArrayII test = new L80removeDuplicatesFromSortedArrayII();
        System.out.println(test.removeDuplicates(new int[]{0}));
    }

    /**
     * 题解中的超简洁做法
     */
    public int removeDuplicates1(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i - 2]) {
                nums[i++] = n;
            }
        }
        return i;
    }


    public int removeDuplicates(int[] nums) {
        if (null == nums) {
            return 0;
        }
        int cur = 0;
        int cnt = 0;
        for (int i = 1; i < nums.length; i++) {
            //不相等，直接替换，然后cur前进
            if (nums[i] != nums[cur]) {
                nums[cur + 1] = nums[i];
                cur++;
                cnt = 0;
            } else {
                //相等，且小于二,拷贝，然后前进一步
                if (cnt < 1) {
                    cnt++;
                    nums[cur + 1] = nums[i];
                    cur++;
                }
            }
        }
        return cur + 1;

    }
}
