package org.forrestlin.leetcode;

/*
 * 求众数
 * */
public class L169MajorityElement {

    /*
     * 多数投票算法 Boyer-Moore Algorithm
     * 众数个数超过一半，我们把众数即为1，其他记为-1，则最终抵消后，众数肯定是大0的
     *
     * */
    public int majorityElement(int[] nums) {
        int cnt = 0;
        int candidate = 0;

        for (int num : nums) {
            if (cnt == 0) {
                candidate = num;
            }
            if (candidate == num) {
                cnt++;
            } else {
                cnt--;
            }


        }
        return candidate;

    }
}
