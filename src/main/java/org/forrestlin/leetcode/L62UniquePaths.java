package org.forrestlin.leetcode;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @program: leetcode
 * @description: 不同路径
 * @author: forrestlin
 * @create: 2019-10-16 18:19
 */
public class L62UniquePaths {

    public static void main(String[] args) {
        L62UniquePaths test = new L62UniquePaths();
        System.out.println(test.uniquePaths(51, 9));
    }


    /**
     *
     * 1	1 	1	 1	  1	  1	  1
     * 1	2 	3	 4	  5	  6	  7
     * 1	3 	6	 10	 15	  21	28
     *
     * 类似杨辉三角，进行累加
     *
     *
     */
    public int uniquePaths(int m, int n) {
        int[] memo = new int[n];

        Arrays.fill(memo, 1);

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[j] += memo[j - 1];
            }
        }

        return memo[n - 1];
    }


    /**
     * *
     * 动态规划 d(i,j)= d(i,j-1)+d(i-1,j)  递归法（自底部向上）会超时
     */
    public int uniquePaths1(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }

        return uniquePaths1(m - 1, n) + uniquePaths1(m, n - 1);


    }


    /**
     * 排列组合
     */
    public int uniquePaths2(int m, int n) {

        if (m <= 1 || n <= 1) {
            return 1;
        }

        int k = n + m - 2;
        int j = n > m ? m - 1 : n - 1;
        BigDecimal res = combinationCnt(BigDecimal.valueOf(k), BigDecimal.valueOf(j));

        return res.intValue();

    }


    private BigDecimal combinationCnt(BigDecimal n, BigDecimal m) {

        return recurrence(n).divide(recurrence(m).multiply(recurrence(n.subtract(m))));
    }

    //采用递归法
    public static BigDecimal recurrence(BigDecimal num) {
        if (num.compareTo(BigDecimal.ZERO) == 0) {
            return BigDecimal.ONE;
        } else {
            return num.multiply(recurrence(num.subtract(BigDecimal.ONE)));
        }
    }

}
