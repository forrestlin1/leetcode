package org.forrestlin.leetcode;

import java.util.Arrays;

/*
 * 移除元素
 * */
public class L27removeElement {

    public static void main(String[] args) {
        L27removeElement test = new L27removeElement();
        int[] is = new int[]{0, 4, 4, 0, 4, 4, 4, 0, 2};
        System.out.println(test.removeElement(is, 4));
        System.out.println(Arrays.toString(is));
    }

    /*
    * 当 nums[j]nums[j] 与给定的值相等时，递增 jj 以跳过该元素。只要 nums[j] \neq valnums[j]

​
 =val，我们就复制 nums[j]nums[j] 到 nums[i]nums[i] 并同时递增两个索引。重复这一过程，直到 jj 到达数组的末尾，该数组的新长度为 ii。

    * */
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; i < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    /*
    * 当我们遇到 nums[i] = valnums[i]=val 时，我们可以将当前元素与最后一个元素进行交换，并释放最后一个元素。这实际上使数组的大小减少了 1。

请注意，被交换的最后一个元素可能是您想要移除的值。但是不要担心，在下一次迭代中，我们仍然会检查这个元素。(i没有加1)

    * */
    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                // reduce array size by one
                n--;
            } else {
                i++;
            }
        }
        return n;
    }


    /*
     * 自己想的，太复杂了
     * */
    public int removeElement1(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }

        int cur = nums.length - 1;
        int i;
        for (i = 0; i < nums.length; i++) {
            if (i >= cur) {
                break;
            }
            if (nums[i] == val) {
                while (nums[cur] == val && cur > i) {
                    cur--;
                }
                if (nums[cur] != val) {
                    nums[i] = nums[cur];
                    cur--;
                }

            }
            if (i >= cur) {
                break;
            }
        }

        if (nums[i] != val) {

            return i + 1;
        } else {
            return i;
        }


    }
}
