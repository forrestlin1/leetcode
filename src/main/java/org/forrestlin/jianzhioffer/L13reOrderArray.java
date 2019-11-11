package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 调整数组顺序使奇数位于偶数前面
 * @author: forrestlin
 * @create: 2019-11-11 17:12
 */
public class L13reOrderArray {

    public static void main(String[] args) {
        L13reOrderArray test = new L13reOrderArray();
        int[] in = new int[]{1, 2, 3, 4, 5, 6};
        test.reOrderArray(in);
        System.out.println("hello world");

    }

    public void reOrderArray(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int cur = 0;
        for (int i = 0; i < array.length; i++) {
            //奇数往前挪动
            if ((array[i] & 1) > 0) {
                for (int j = i; j > cur; j--) {
                    int tmp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tmp;
                }
                cur++;
            }
        }

    }

}
