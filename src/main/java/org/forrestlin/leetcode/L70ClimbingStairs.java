package org.forrestlin.leetcode;

/*
 * @program: leetcode
 * @description: 爬楼梯
 * @author: forrestlin
 * @create: 2019-10-17 22:42
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。

每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？

注意：给定 n 是一个正整数。

示例 1：

输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

 */
public class L70ClimbingStairs {

    public static void main(String[] args) {
        L70ClimbingStairs test = new L70ClimbingStairs();
        System.out.println(test.climbStairs(6));

    }

    /**
     * 动态规划 dp[n] = dp[n-1]+dp[n-2] => dp[n+2] = dp[n+1]+dp[n] dp[1] = 1  dp[2] = 2
     * <p>
     * 其实就是斐波那契数列
     */
    public int climbStairs(int n) {

        if (n <= 2) {
            return n;
        }

        int res = 2;

        for (int j = 1, k = 3; k <= n; k++) {
            int tmp = res;
            res += j;
            j = tmp;

        }

        return res;


    }

}
