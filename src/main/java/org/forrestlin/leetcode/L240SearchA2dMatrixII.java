package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 搜索二位矩阵ii
 * @author: forrestlin
 * @create: 2019-11-06 02:21
 */
public class L240SearchA2dMatrixII {

    /**
     * 确实巧妙，想了下这个算法的关键是找到合适的遍历起点，这个点肯定具有某种特殊性，这个二维矩阵，四个角就是四个特殊点，但他们的特点不同，左上和右下分别是矩阵的最小和最大值，左下和右上具有两面性，如果是所在行最大值那么就是所在列的最小值，反过来也一样。左上和右下与目标值比较不相等时，下一步既可以遍历行也可以遍历列是不确定的，而左下和右上是可以确定的，因为自身值的特点可以排除一个方向的路径，只有一个遍历路径。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        //从右上角往左下角遍历寻找，比target大于则往左，小于则往下
        int row = 0;
        int col = matrix[0].length - 1;

        while (row < matrix.length && col >= 0) {
            if (matrix[row][col] > target) {
                col--;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                return true;
            }


        }
        return false;
    }
}