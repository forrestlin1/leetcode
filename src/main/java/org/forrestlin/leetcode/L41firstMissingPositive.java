package org.forrestlin.leetcode;

/*
* 缺失的第一个正数
*
* 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。

 

示例 1:

输入: [1,2,0]
输出: 3
示例 2:

输入: [3,4,-1,1]
输出: 2
示例 3:

输入: [7,8,9,11,12]
输出: 1


* */
public class L41firstMissingPositive {

    public static void main(String[] args) {
        L41firstMissingPositive test = new L41firstMissingPositive();
        System.out.println(test.firstMissingPositive(new int[]{1,2,0}));
        System.out.println(test.firstMissingPositive(new int[]{3,4,-1,1}));
        System.out.println(test.firstMissingPositive(new int[]{7,8,9,11,12}));
    }


    /*
    * 首先我们可以不考虑负数和零，因为不需要考虑。同样可以不考虑大于 n 的数字，
   因为首次缺失的正数一定小于或等于 n + 1 。
    * */
    public int firstMissingPositive(int[] nums) {

        //针对不包含1的情况特殊处理
        boolean isContainOne = false;
        for (int num : nums) {
            if (num == 1) {
                isContainOne = true;
            }
        }
        if (!isContainOne) {
            return 1;
        }

        //对于小于等于0的和大于n的，赋值为1
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0 || nums[i] > nums.length) {
                nums[i] = 1;
            }
        }
        //用对应的数组下标标识当前数字是否存在，如果为负数即为存在，如果为正数，即为不存在
        //a[1] 为负数，则代表1这个数是存在的
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (val == nums.length) {
                nums[0] = -1;
            } else {
                val = Math.abs(val);
                nums[val] = nums[val] < 0 ? nums[val] : -nums[val];
            }

        }
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                return i;
            }
        }
        return nums.length;


    }
}
