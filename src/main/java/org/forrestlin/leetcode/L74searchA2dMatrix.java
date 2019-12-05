package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 搜索二维矩阵
 * @author: forrestlin
 * @create: 2019-12-05 17:54
 */
public class L74searchA2dMatrix {


    /**
     * 从右上往左下找 当前大于目标，则往左 否则往下
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        //从右上开始搜索
        int i = 0;
        int j = col - 1;
        while (i <= row - 1 && j >= 0) {
            if (matrix[i][j] > target) {
                j--;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }

        return false;
    }
}
