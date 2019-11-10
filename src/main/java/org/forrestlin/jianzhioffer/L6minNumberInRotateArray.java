package org.forrestlin.jianzhioffer;

/*
 * 旋转树组的最小数字
 * */
public class L6minNumberInRotateArray {

    /*
     * 遍历法，找到第一个比前一个数字小的，然后返回
     *
     * 这道题还可以考虑使用二分查找
     * */
    public int minNumberInRotateArray(int[] array) {
        if (null == array || array.length == 0) {
            return 0;
        }
        if (array.length == 1) {
            return array[0];
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] < array[i - 1]) {
                return array[i];
            }
        }
        return 0;

    }
}
