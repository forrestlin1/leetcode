package org.forrestlin.leetcode;

import java.util.Arrays;

/**
 * 最大数
 */
public class L179largestNumber {

    public String largestNumber(int[] nums) {
        String[] numStrs = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numStrs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(numStrs, (String a, String b) -> {
            String o1 = a + b;
            String o2 = b + a;
            return o2.compareTo(o1);
        });

        if (numStrs[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder("");
        for (String numStr : numStrs) {
            sb.append(numStr);
        }
        return sb.toString();

    }
}
