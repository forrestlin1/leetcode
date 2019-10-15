package org.forrestlin.leetcode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @program: leetcode
 * @description: 接雨水
 * @author: forrestlin
 * @create: 2019-10-10 10:47
 */
public class L42TrappingRainWater {

    public static void main(String[] args) {
        L42TrappingRainWater test = new L42TrappingRainWater();
        System.out.println(test.trap2(new int[]{4, 3, 1, 2}));
    }

    /**
     * 遍历数组，每一格能乘的水量等于左边最高位和右边最高位中，较低的那个，减去当前格的高度
     * 使用优先队列，能保存右边最高位
     */
    public int trap(int[] height) {

        if (height == null || height.length <= 2) {
            return 0;
        }

        PriorityQueue<Integer> pq = new PriorityQueue(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2) * -1;
            }
        });
        for (int i = 1; i < height.length; i++) {
            pq.add(height[i]);

        }
        int res = 0;
        int leftHigh = height[0];
        int rightHigh;
        for (int i = 1; i < height.length - 1; i++) {

            pq.remove(height[i]);

            leftHigh = leftHigh > height[i - 1] ? leftHigh : height[i - 1];
            if (height[i] >= leftHigh) {
                continue;
            }

            rightHigh = pq.peek();
            if (height[i] >= rightHigh) {
                continue;
            }

            res += (leftHigh < rightHigh ? leftHigh : rightHigh) - height[i];

        }
        return res;

    }

    /**
     * 双指针法
     * 假设一开始left-1大于right+1，则之后right会一直向左移动，直到right+1大于left-1。在这段时间内right所遍历的所有点都是左侧最高点maxleft大于右侧最高点maxright的，
     * 所以只需要根据原则判断maxright与当前高度的关系就行。反之left右移，所经过的点只要判断maxleft与当前高度的关系就行
     *
     * 双指针一开始位与头尾，然后慢慢向中间靠拢，只到left=right，则整个数组计算完成
     */
    public int trap2(int[] height) {

        int sum = 0;
        int max_left = 0;
        int max_right = 0;
        int left = 1;
        int right = height.length - 2; // 加右指针进去
        for (int i = 1; i < height.length - 1; i++) {
            //从左到右更
            if (height[left - 1] < height[right + 1]) {
                max_left = Math.max(max_left, height[left - 1]);
                int min = max_left;
                if (min > height[left]) {
                    sum = sum + (min - height[left]);
                }
                left++;
                //从右到左更
            } else {
                max_right = Math.max(max_right, height[right + 1]);
                int min = max_right;
                if (min > height[right]) {
                    sum = sum + (min - height[right]);
                }
                right--;
            }
        }
        return sum;


    }

    /**
     * 动态规划
     *
     *
     * 首先用两个数组，max_left [i] 代表第 i 列左边最高的墙的高度，max_right[i] 代表第 i 列右边最高的墙的高度。（一定要注意下，第 i 列左（右）边最高的墙，是不包括自身的，和 leetcode 上边的讲的有些不同）
     *
     * 对于 max_left我们其实可以这样求。
     *
     * max_left [i] = Max(max_left [i-1],height[i-1])。它前边的墙的左边的最高高度和它前边的墙的高度选一个较大的，就是当前列左边最高的墙了。
     *
     * 对于 max_right我们可以这样求。
     *
     * max_right[i] = Max(max_right[i+1],height[i+1]) 。它后边的墙的右边的最高高度和它后边的墙的高度选一个较大的，就是当前列右边最高的墙了。
     *
     *
     */
    public int trap3(int[] height) {

        int sum = 0;
        int[] max_left = new int[height.length];
        int[] max_right = new int[height.length];

        for (int i = 1; i < height.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], height[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            max_right[i] = Math.max(max_right[i + 1], height[i + 1]);
        }
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(max_left[i], max_right[i]);
            if (min > height[i]) {
                sum = sum + (min - height[i]);
            }
        }
        return sum;


    }

}
