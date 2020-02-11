package org.forrestlin.leetcode2;

/**
 * @program: leetcode
 * @description: 最大正方形
 * @author: forrestlin
 * @create: 2019-11-01 15:37
 */
public class L221MaximalSquare {

    /**
     * 动态规划问题。设二维数组dp[m][n]，其中dp[i][j]表示以坐标(i,j)为右下角元素的最大正方形的边长。
     * <p>
     * 通过观察我们可以看出当前位置的最大正方形边长为上，左，左上三个位置最大正方形边长的最小值+1。（必须这三个正方形同时满足&&该位置matrix[i][j]==1 的条件下，最大边长）
     * <p>
     * 得到动态规划方程： 如果 matrix[i][j] == 1
     * <p>
     * dp[i][j] = min(dp[i-1][j], dp[i][j-1], dp[i-1][j-1]) + 1
     * <p>
     * 否则
     * <p>
     * dp[i][j] = 0
     */
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }
        int res = 0;
        int[][] tmp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    int left = 0;
                    int up = 0;
                    int leftUp = 0;
                    if (j - 1 >= 0) {
                        left = tmp[i][j - 1];
                    }
                    if (i - 1 >= 0) {
                        up = tmp[i - 1][j];
                    }
                    if (i - 1 >= 0 && j - 1 >= 0) {
                        leftUp = tmp[i - 1][j - 1];
                    }
                    tmp[i][j] = Math.min(Math.min(left, up), leftUp) + 1;
                    res = Math.max(tmp[i][j], res);

                }
            }
        }
        return res * res;

    }

}
