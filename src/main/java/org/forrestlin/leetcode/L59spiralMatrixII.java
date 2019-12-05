package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 螺旋矩阵II
 * @author: forrestlin
 * @create: 2019-12-03 10:00
 * <p>
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * <p>
 * 示例:
 * <p>
 * 输入: 3 输出: [ [ 1, 2, 3 ], [ 8, 9, 4 ], [ 7, 6, 5 ] ]
 */
public class L59spiralMatrixII {

    public static void main(String[] args) {
        L59spiralMatrixII test = new L59spiralMatrixII();
        System.out.println(test.generateMatrix(3));
    }

    /**
     *lettcode解法
     */
    public int[][] generateMatrix1(int n) {
        int l = 0, r = n - 1, t = 0, b = n - 1;
        int[][] mat = new int[n][n];
        int num = 1, tar = n * n;
        while (num <= tar) {
            for (int i = l; i <= r; i++) {
                mat[t][i] = num++; // left to right.
            }
            t++;
            for (int i = t; i <= b; i++) {
                mat[i][r] = num++; // top to bottom.
            }
            r--;
            for (int i = r; i >= l; i--) {
                mat[b][i] = num++; // right to left.
            }
            b--;
            for (int i = b; i >= t; i--) {
                mat[i][l] = num++; // bottom to top.
            }
            l++;
        }
        return mat;
    }


    /**
     * 自己选的解法
     * */
    public int[][] generateMatrix(int n) {

        int[][] matrix = new int[n][n];

        //0向右 1向下 2向左 3向上
        int[] direction = new int[]{0, 1, 2, 3};

        int cnt = 0;
        int i = 0;
        int j = 0;
        int w = matrix[0].length;
        int h = matrix.length;
        matrix[0][0] = 1;
        int num = 1;
        while (true) {

            int direct = direction[cnt % 4];
            //向内的层数
            int lev = (cnt + 1) / 4;

            //向右遍历
            if (direct == 0) {
                while (j + 1 < w - lev) {
                    j++;
                    num++;
                    matrix[i][j] = num;
                }

            } else if (direct == 1) {

                while (i + 1 < h - lev) {
                    i++;
                    num++;
                    matrix[i][j] = num;
                }
            } else if (direct == 2) {

                while (j > lev) {
                    j--;
                    num++;
                    matrix[i][j] = num;
                }
            } else if (direct == 3) {

                while (i > lev) {
                    i--;
                    num++;
                    matrix[i][j] = num;
                }
            }

            if (num == n * n) {
                break;
            }
            cnt++;

        }

        return matrix;

    }
}
