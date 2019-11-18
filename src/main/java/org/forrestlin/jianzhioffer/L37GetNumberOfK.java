package org.forrestlin.jianzhioffer;

import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 数字在排序数组中出现的次数
 * @author: forrestlin
 * @create: 2019-11-18 11:57
 */
public class L37GetNumberOfK {

    public int GetNumberOfK(int[] array, int k) {
        int low = 0;
        int high = array.length - 1;

        //这里因为high = length-1 整个为闭区间，所以low要<=high 而不是<high
        while (low <= high) {
            //用low+high/2可能会溢出
            int mid = low + (high - low) / 2;

            if (k > array[mid]) {
                low = mid + 1;
            }
            //这里等于的时候也-1，这样low才能往左移，匹配到第一个
            if (k <= array[mid]) {
                high = mid - 1;
            }

        }
        if (low <= array.length - 1 && array[low] == k) {

            int cnt = 0;
            while (low < array.length) {
                if (array[low] == k) {
                    cnt++;
                } else {
                    return cnt;
                }
                low++;
            }
            return cnt;

        } else {
            return 0;
        }


    }
}
