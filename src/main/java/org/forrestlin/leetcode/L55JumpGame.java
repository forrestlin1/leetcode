package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 跳跃游戏
 * @author: forrestlin
 * @create: 2019-10-15 11:32
 *
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 判断你是否能够到达最后一个位置。
 *
 * 示例 1:
 *
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 从位置 0 到 1 跳 1 步, 然后跳 3 步到达最后一个位置。
 * 示例 2:
 *
 * 输入: [4,0,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 */
public class L55JumpGame {

    public static void main(String[] args) {
        L55JumpGame test = new L55JumpGame();
        System.out.println(test.canJump2(new int[]{4, 0, 1, 0, 4}));
    }

    /**
     * 只需考虑0的位置能否跳过，所以遇到0的时候，向前找能跳过这个0的点
     * */
    public boolean canJump(int[] nums) {
        if (null == nums || nums.length <= 1) {
            return true;
        }
        int preZero = nums.length - 1;
        boolean res = true;
        for (int i = nums.length - 1; i >= 0; i--) {

            if (res && nums[i] == 0) {
                preZero = i;
                res = false;
            }

            //这里考虑当0是最后一位时，只需等于就行了
            if (preZero > 0 &&
                (nums[i] > preZero - i) || (preZero == nums.length - 1 && nums[i] >= preZero - i)) {
                res = true;
            }

        }
        return res;
    }

    public boolean canJump2(int[] nums) {
        int lastPos = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i + nums[i] >= lastPos) {
                lastPos = i;
            }
        }
        return lastPos == 0;
    }


    /**
     * 贪心
     *
     * 从右向左迭代，对于每个节点我们检查是否存在一步跳跃可以到达 GOOD 的位置（currPosition + nums[currPosition] >= leftmostGoodIndex）。
     * 如果可以到达，当前位置也标记为 GOOD ，同时，这个位置将成为新的最左边的 GOOD 位置，一直重复到数组的开头，如果第一个坐标标记为 GOOD 意味着可以从第一个位置跳到最后的位置。
     *
     *
     *
     * */
    public class Solution {
        public boolean canJump(int[] nums) {
            int lastPos = nums.length - 1;
            for (int i = nums.length - 1; i >= 0; i--) {
                if (i + nums[i] >= lastPos) {
                    lastPos = i;
                }
            }
            return lastPos == 0;
        }
    }


}
