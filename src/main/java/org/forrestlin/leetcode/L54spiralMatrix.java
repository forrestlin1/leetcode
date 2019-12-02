package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 螺旋矩阵
 * @author: forrestlin
 * @create: 2019-12-02 17:05
 */
public class L54spiralMatrix {

    public static void main(String[] args) {
        L54spiralMatrix test = new L54spiralMatrix();
        int m[][] = new int[][]{new int[]{1},
            new int[]{2}};
        System.out.println(test.spiralOrder(m));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (null == matrix || 0 == matrix.length || 0 == matrix[0].length) {

            return res;
        }

        //0向右 1向下 2向左 3向上
        int[] direction = new int[]{0, 1, 2, 3};

        int cnt = 0;
        int i = 0;
        int j = 0;
        int w = matrix[0].length;
        int h = matrix.length;
        res.add(matrix[i][j]);
        while (true) {

            int direct = direction[cnt % 4];
            //向内的层数
            int lev = (cnt + 1) / 4;
            int len = res.size();

            //向右遍历
            if (direct == 0) {
                while (j + 1 < w - lev) {
                    j++;
                    res.add(matrix[i][j]);
                }

            } else if (direct == 1) {

                while (i + 1 < h - lev) {
                    i++;
                    res.add(matrix[i][j]);
                }
            } else if (direct == 2) {

                while (j > lev) {
                    j--;
                    res.add(matrix[i][j]);
                }
            } else if (direct == 3) {

                while (i > lev) {
                    i--;
                    res.add(matrix[i][j]);
                }
            }

            //len==size说明已经没有可以添加的了
            //cnt>0 ,为了过[[1],[2]] 这条用例
            if (len == res.size() && cnt > 0) {
                break;

            }
            cnt++;

        }

        return res;
    }

}
