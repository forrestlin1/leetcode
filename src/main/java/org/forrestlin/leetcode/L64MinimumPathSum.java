package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 最小路径和
 * @author: forrestlin
 * @create: 2019-10-17 19:23
 */
public class L64MinimumPathSum {

    public static void main(String[] args) {
        L64MinimumPathSum test = new L64MinimumPathSum();
        System.out.println(test.minPathSum(new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}}));
        System.out.println(test.minPathSum_bd(new int[][]{new int[]{1, 3, 1}, new int[]{1, 5, 1}, new int[]{4, 2, 1}}));
    }

    /**
     * 动态规划 自顶向下
     */
    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] = grid[i][j - 1] + grid[i][j];
                } else if (j == 0) {
                    grid[i][j] = grid[i - 1][j] + grid[i][j];
                } else {
                    grid[i][j] = Math.min(grid[i - 1][j], grid[i][j - 1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }


    public int minPathSum2(int[][] grid) {

        int m = grid.length - 1;
        int n = grid[0].length - 1;
        return dp(m, n, grid);

    }


    /**
     * 动态规划dp(m,m) =  Math.min(dp(m - 1, n, grid), dp(m, n - 1, grid)) + grid[m][n]
     * <p>
     * 超时
     */
    public int dp(int m, int n, int[][] grid) {

        if (n == 0) {
            int res = 0;
            for (int i = 0; i <= m; i++) {
                res += grid[i][0];
            }
            System.out.println(res);
            return res;
        } else if (m == 0) {
            int res = 0;
            for (int i = 0; i <= n; i++) {
                res += grid[0][i];
            }

            return res;
        }

        int res = Math.min(dp(m - 1, n, grid), dp(m, n - 1, grid)) + grid[m][n];

        return res;
    }


    public int minPathSum_bd(int[][] grid) {

        int row = grid.length;
        int col = grid[0].length;
        int[] dp = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    dp[0] = grid[0][0];
                    continue;
                }
                int up = i > 0 ? dp[j] : Integer.MAX_VALUE;
                int left = j > 0 ? dp[j - 1] : Integer.MAX_VALUE;
                dp[j] = Math.min(up, left) + grid[i][j];
            }
        }
        return dp[col - 1];


    }

}
