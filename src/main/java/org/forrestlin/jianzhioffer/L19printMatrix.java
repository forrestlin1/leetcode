package org.forrestlin.jianzhioffer;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 顺时针打印矩阵
 * @author: forrestlin
 * @create: 2019-11-12 15:44
 */
public class L19printMatrix {

    /*
     *1  2  3  4
     *5  6  7  8
     *9  10 11 12
     *13 14 15 16
     *
     * 顺时针打印
     * 1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
     * 00 01 02 03 13 23 33 32 31 30 20 10 11 12 22 20
     * */
    public ArrayList<Integer> printMatrix(int[][] matrix) {

        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return list;
        }
        int up = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        while (true) {
            // 最上面一行
            for (int col = left; col <= right; col++) {
                list.add(matrix[up][col]);
            }
            // 向下逼近
            up++;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最右边一行
            for (int row = up; row <= down; row++) {
                list.add(matrix[row][right]);
            }
            // 向左逼近
            right--;
            // 判断是否越界
            if (left > right) {
                break;
            }
            // 最下面一行
            for (int col = right; col >= left; col--) {
                list.add(matrix[down][col]);
            }
            // 向上逼近
            down--;
            // 判断是否越界
            if (up > down) {
                break;
            }
            // 最左边一行
            for (int row = down; row >= up; row--) {
                list.add(matrix[row][left]);
            }
            // 向右逼近
            left++;
            // 判断是否越界
            if (left > right) {
                break;
            }
        }
        return list;
    }
}
