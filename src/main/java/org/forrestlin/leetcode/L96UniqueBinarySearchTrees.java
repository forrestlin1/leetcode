package org.forrestlin.leetcode;

public class L96UniqueBinarySearchTrees {

    /**
     * 动态规划G(0) = 1, G(1) = 1, G(2) = 2 , G(n) = 求和（i = 1...n）G(i-1)*G(n-i)
     */
    public int numTrees(int n) {
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }

        }
        return G[n];
    }
}
