package org.forrestlin.leetcode;

/*
 * 下一个排列
 *
 * 根据给出的数字，返回按照每位重新排列后下一个比该数字大的数字
 * 如果给出的数字已经是最大的了，则返回最小排列数
 * */
public class L31nextPermutation {

    public static void main(String[] args) {
        L31nextPermutation test = new L31nextPermutation();
        test.nextPermutation(new int[]{3, 2, 1});
    }


    /*
     * 1.从数组尾部向头部遍历，找到第一个递减的数字a，等待交换
     * 2.从数组尾部向头部遍历，找到第一个比a大的数字b，等待交换
     * 3.交换
     * 4，a原来所在的位置后面的数字排序需要 翻转
     *
     * 例子：146531 交换45后 156431  后面翻转后151346
     *
     * */
    public void nextPermutation(int[] nums) {
        int needSwap = -1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                needSwap = i;
                break;
            }
        }
        int toSwap = nums.length - 1;
        if (needSwap >= 0) {
            for (int i = nums.length - 1; i > needSwap; i--) {
                if (nums[i] > nums[needSwap]) {
                    toSwap = i;
                    break;
                }
            }
            //交换
            swap(nums, needSwap, toSwap);
        }

        //翻转需要交换的数字的后面所有位数
        int i = needSwap + 1;
        int j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }


    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


}
