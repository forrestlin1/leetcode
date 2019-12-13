package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 杨辉三角
 * @author: forrestlin
 * @create: 2019-12-11 17:55
 */
public class L118pascalsTriangle {

    public static void main(String[] args) {
        L118pascalsTriangle test = new L118pascalsTriangle();
        System.out.println(test.generate(4));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> t1 = Arrays.asList(1);
        res.add(t1);
        for (int i = 2; i <= numRows; i++) {
            List<Integer> lastRow = res.get(i - 2);
            List<Integer> row = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0) {
                    row.add(lastRow.get(j));
                } else if (j == i - 1) {
                    row.add(lastRow.get(j - 1));
                } else {
                    row.add(lastRow.get(j - 1) + lastRow.get(j));
                }

            }
            res.add(row);
        }
        return res;
    }
}
