package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @program: leetcode
 * @description: 合并区间
 * @author: forrestlin
 * @create: 2019-10-16 11:37
 */
public class L56MergeIntervals {

    public static void main(String[] args) {
        L56MergeIntervals test = new L56MergeIntervals();
        System.out.println(test.merge(new int[][]{new int[]{1,4}, new int[]{2, 3}}));
    }


    /**
     * 先排序，然后把重叠区间合并
     * 主要看 list和array转换
     * */
    public int[][] merge(int[][] intervals) {

        if (null == intervals || intervals.length == 0) {
            return new int[][]{};
        }

        Arrays.sort(intervals, Comparator.comparing((int[] o) -> o[0]));

        int begin = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> res = new ArrayList<>();
        for (int[] interval : intervals) {

            if (interval[0] <= end) {
                if (interval[1] > end) {

                    end = interval[1];
                }

            } else {
                res.add(new int[]{begin, end});
                begin = interval[0];
                end = interval[1];
            }

        }

        res.add(new int[]{begin, end});

        return res.toArray(new int[res.size()][2]);


    }
}

