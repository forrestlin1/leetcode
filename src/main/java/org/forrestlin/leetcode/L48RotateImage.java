package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 旋转图像
 * @author: forrestlin
 * @create: 2019-10-14 17:59
 *
 * 给定一个 n × n 的二维矩阵表示一个图像。
 *
 * 将图像顺时针旋转 90 度。
 *
 * 说明：
 *
 * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 *
 */
public class L48RotateImage {


    /**
     * 自外向内一共有不超过 n/2n/2 层（单个中心元素不算一层）矩形框。对于第 timestimes 层矩形框，其框边长 len=nums-(times*2)len=nums−(times∗2)，
     * 将其顺时针分为 44 份 len-1len−1 的边，对四条边进行元素的循环交换即可。
     */
    public void rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        int times = 0;
        while (times <= (nums >> 1)) {
            int len = nums - (times << 1);
            for (int i = 0; i < len - 1; ++i) {
                int temp = matrix[times][times + i];
                matrix[times][times + i] = matrix[times + len - i - 1][times];
                matrix[times + len - i - 1][times] = matrix[times + len - 1][times + len - i - 1];
                matrix[times + len - 1][times + len - i - 1] = matrix[times + i][times + len - 1];
                matrix[times + i][times + len - 1] = temp;
            }
            ++times;
        }
    }

    /**
     * 先沿右上 - 左下的对角线翻转（270° +270°+ 一次镜像），再沿水平中线上下翻转（-180° +−180°+ 一次镜像），可以实现顺时针 9090 度的旋转效果
     */

    public void rotate2(int[][] matrix) {
        if (matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }
        int nums = matrix.length;
        for (int i = 0; i < nums; ++i) {
            for (int j = 0; j < nums - i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - j][nums - 1 - i];
                matrix[nums - 1 - j][nums - 1 - i] = temp;
            }
        }
        for (int i = 0; i < (nums >> 1); ++i) {
            for (int j = 0; j < nums; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[nums - 1 - i][j];
                matrix[nums - 1 - i][j] = temp;
            }
        }
    }


}
