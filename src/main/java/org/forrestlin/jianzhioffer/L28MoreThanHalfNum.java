package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 数组中出现次数超过一半的数字
 * @author: forrestlin
 * @create: 2019-11-15 11:08
 */
public class L28MoreThanHalfNum {

    public static void main(String[] args) {
        L28MoreThanHalfNum test = new L28MoreThanHalfNum();
        System.out.println(test.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        int res = 0;
        int cnt = 0;
        for (int i : array) {
            if (cnt == 0) {
                res = i;
            }
            if (i == res) {
                cnt++;
            } else {
                cnt--;
            }

        }

        int num = 0;//需要判断是否真的是大于1半数
        for (int i = 0; i < array.length; i++) {
            if (array[i] == res) {
                num++;
            }
        }
        return (num > array.length / 2) ? res : 0;

    }
}
