package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 杨辉三角II
 * @author: forrestlin
 * @create: 2019-12-11 18:26
 */
public class L119pascalsTriangleII {

    public static void main(String[] args) {
        L119pascalsTriangleII test = new L119pascalsTriangleII();
        System.out.println(test.getRow(4));
    }

    public List<Integer> getRow(int rowIndex) {

        List<Integer> lastRow = Arrays.asList(1);
        List<Integer> res = lastRow;
        for (int i = 2; i <= rowIndex; i++) {
            res = new ArrayList<>(i);
            for (int j = 0; j < i; j++) {
                if (j == 0 || j == i - 1) {
                    res.add(1);
                } else {
                    res.add(lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            lastRow = res;
        }
        return res;
    }
}
