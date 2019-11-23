package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 和为S的两个数
 * @author: forrestlin
 * @create: 2019-11-18 17:40
 */
public class L42FindNumbersWithSum {

    public static void main(String[] args) {
        L42FindNumbersWithSum test = new L42FindNumbersWithSum();
        System.out.println(test.FindNumbersWithSum(new int[]{1, 2, 4, 7, 11, 15}, 15));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        Map<Integer, Integer> helper = new HashMap<>();
        int resMin = 0;
        int resMax = 0;
        int multi = Integer.MAX_VALUE;
        for (int i : array) {
            Integer j = helper.get(i);
            if (j != null && ((i * j) < multi)) {
                resMin = i < j ? i : j;
                resMax = i < j ? j : i;
                multi = resMin * resMax;
            } else {
                helper.put(sum - i, i);
            }
        }

        if (multi == Integer.MAX_VALUE) {
            return new ArrayList<>();
        }

        return new ArrayList<>(Arrays.asList(new Integer[]{resMin, resMax}));

    }

}
