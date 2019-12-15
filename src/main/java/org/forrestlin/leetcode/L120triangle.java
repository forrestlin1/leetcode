package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 三角形的最小路径和
 */
public class L120triangle {

    public static void main(String[] args) {
        L120triangle test = new L120triangle();
        List<List<Integer>> tr = new ArrayList<>();
        /*tr.add(Arrays.asList(2));
        tr.add(Arrays.asList(3, 4));
        tr.add(Arrays.asList(6, 5, 7));
        tr.add(Arrays.asList(4, 1, 8, 3));*/
        tr.add(Arrays.asList(-1));
        tr.add(Arrays.asList(-2, -3));
        System.out.println(test.minimumTotal(tr));
    }

    /**
     * 解法1 二维数组进行求解
     *
     * @param triangle
     * @return
     */
    public int minimumTotal1(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 加1可以不用初始化最后一层
        int[][] dp = new int[triangle.size() + 1][triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + curTr.get(j);
            }
        }
        return dp[0][0];
    }

    /**
     * 解法2 一维数组进行求解
     *
     * @param triangle
     * @return
     */
    public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) {
            return 0;
        }
        // 只需要记录每一层的最小值即可
        int[] dp = new int[triangle.size() + 1];

        for (int i = triangle.size() - 1; i >= 0; i--) {
            List<Integer> curTr = triangle.get(i);
            for (int j = 0; j < curTr.size(); j++) {
                //这里的dp[j] 使用的时候默认是上一层的，赋值之后变成当前层
                dp[j] = Math.min(dp[j], dp[j + 1]) + curTr.get(j);
            }
        }
        return dp[0];
    }

    /*
     * 自己解法，自顶向下，效率较低
     * */
    public int minimumTotal(List<List<Integer>> triangle) {
        if (null == triangle || triangle.size() == 0) {
            return 0;
        }

        List<Integer> resList = new LinkedList<>();
        resList.addAll(triangle.get(0));
        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> row = triangle.get(i);
            int lastRes = 0;
            for (int j = 0; j < row.size(); j++) {

                if (j == 0) {

                    lastRes = resList.get(j);
                    resList.set(0, resList.get(0) + row.get(0));

                } else if (j == row.size() - 1) {

                    resList.add(lastRes + row.get(j));
                } else {

                    int tmp = resList.get(j);
                    resList.set(j, Math.min(resList.get(j), lastRes) + row.get(j));
                    lastRes = tmp;
                }


            }
            System.out.println(resList);
        }

        int res = resList.get(0);
        for (Integer i : resList) {
            res = Math.min(i, res);
        }
        return res;


    }
}
