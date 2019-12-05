package org.forrestlin.leetcode;
//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//
// 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//
// 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
//
//
//
// 网格中的障碍物和空位置分别用 1 和 0 来表示。
//
// 说明：m 和 n 的值均不超过 100。
//
// 示例 1:
//
// 输入:
//[
//  [0,0,0],
//  [0,1,0],
//  [0,0,0]
//]
//输出: 2
//解释:
//3x3 网格的正中间有一个障碍物。
//从左上角到右下角一共有 2 条不同的路径：
//1. 向右 -> 向右 -> 向下 -> 向下
//2. 向下 -> 向下 -> 向右 -> 向右

/**
 * @program: leetcode
 * @description: 不同路径II
 * @author: forrestlin
 * @create: 2019-12-03 16:41
 */
public class L63uniquePathsII {

    public static void main(String[] args) {
        L63uniquePathsII test = new L63uniquePathsII();
        int[][] grid = new int[][]{
            new int[]{0, 0, 0},
            new int[]{0, 1, 0},
            new int[]{0, 0, 0}

        };
        System.out.println(test.uniquePathsWithObstacles(grid));
    }

    /**
     * 动态规划 d(i,j)= d(i,j-1)+d(i-1,j)  递归法（自底部向上）会超时 遇到障碍物，则当前节点的路径数为0
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (null == obstacleGrid || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }

        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    if (obstacleGrid[0][0] == 1) {
                        return 0;
                    } else {
                        obstacleGrid[0][0] = 1;
                    }
                    continue;
                }

                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                    continue;
                }
                int left = (j - 1 >= 0) ? obstacleGrid[i][j - 1] : 0;
                int up = (i - 1 >= 0) ? obstacleGrid[i - 1][j] : 0;
                obstacleGrid[i][j] = left + up;

            }
        }

        return obstacleGrid[row - 1][col - 1];
    }

}
