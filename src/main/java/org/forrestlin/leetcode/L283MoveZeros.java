package org.forrestlin.leetcode;

import java.util.Arrays;

/*
 * 移动0
 * */
public class L283MoveZeros {

    public static void main(String[] args) {
        L283MoveZeros test = new L283MoveZeros();
        int[] val = new int[]{0, 0, 1};
        test.moveZeroes(val);
        System.out.println(Arrays.asList(val));
    }

    /**
     * 把所有非0元素都搬到前面，然后后面的树组元素都赋值为0即可
     *
     *1.nums中，i指针用于存放非零元素
     * 2.j指针用于遍历寻找非零元素
     * （注：j指针找到一个非零元素后，方法nums[i]的位置，i++，用于下一个j指针找到的非零元素）
     * 3.j指针遍历完后，最后nums数组还有空位置，存放0即可
     *
     */
    public void moveZeroes(int[] nums) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != 0) {
                if (i != j) {
                    nums[i] = nums[j];
                }
                i++;
            }
        }
        for (; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

    public void moveZeroes1(int[] nums) {
        int zeroCnt = 0;
        for (int i = 0; i < nums.length - zeroCnt; ) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - zeroCnt - 1; j++) {
                    int tmp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = tmp;
                }
                zeroCnt++;
            } else {
                i++;
            }
        }
    }

}
