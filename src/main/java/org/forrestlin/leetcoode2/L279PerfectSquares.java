package org.forrestlin.leetcoode2;

import java.util.LinkedList;
import java.util.Queue;

/*
 *完全平方数
 * */
public class L279PerfectSquares {

    /*
     * 动态规划，前正整数n的结果对应于n去掉一个完全平方数之后的子问题结果加一，但是去掉哪一个完全平方数才能达到最佳结果呢，
     * 这就需要我们自己去进行一个遍历，然后取最小的值即可
     *
     * 寻找对应平方数的递推公式为
     * dp[i] = min(dp[i], dp[i-j*j]+1)
     *
     * */
    public int numSquares(int n) {
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            //最坏的结果为i个1相加
            dp[i] = i;
            //以下寻找递推公式中的j
            for (int j = 1; i - j * j >= 0; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }

        return dp[n];
    }

    /**
     * 广度优先遍历，找到的第一个余数为0的就返回
     */
    public int numSquares1(int n) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(n, 1));
        int[] array = new int[n];

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            for (int i = 1; ; i++) {
                if (node.m - i * i < 0) {
                    break;
                } else if (node.m - i * i == 0) {
                    return node.step;
                }
                if (array[node.m - i * i] != 1) {
                    array[node.m - i * i] = 1;
                    queue.add(new Node(node.m - i * i, node.step + 1));
                }
            }
        }
        return -1;
    }

    class Node {

        int m;
        int step;

        Node(int m, int step) {
            this.m = m;
            this.step = step;
        }

    }
}
