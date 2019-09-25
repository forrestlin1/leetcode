package org.forrestlin.leetcode;

import java.util.Map;

/**
 * @program: leetcode
 * @description: 盛最多水的容器
 * @author: forrestlin
 * @create: 2019-09-23 14:55
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 */
public class L11ContainerWithMostWater {

    public static void main(String[] args) {

        maxArea(new int[]{1, 8, 6});

    }

    /**
     * 暴力法
     */
    public static int maxArea(int[] height) {
        int res = 0;

        int jmax = 0;
        for (int i = 1; i < height.length; i++) {
            for (int j = 0; j < i; j++) {
                if (height[j] > jmax) {
                    jmax = height[j];
                    int resTmp = Math.min(height[i], height[j]) * (i - j);
                    res = resTmp > res ? resTmp : res;
                }

            }
            jmax = 0;
        }

        return res;
    }

    /**
     * 双指针法
     * 两个指针从头尾，高度比较低的往中间走
     */
    public static int maxArea1(int[] height) {

        int res = 0;

        int l = 0;
        int r = height.length - 1;

        while (l < r) {
            int min = Math.min(height[l], height[r]);
            res = res > (r - l) * min ? res : (r - l) * min;

            if (height[l] > height[r]) {
                r--;
            } else {
                l++;
            }

        }

        return res;


    }
}
