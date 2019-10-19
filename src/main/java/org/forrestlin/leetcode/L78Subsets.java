package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/* 子集*/
public class L78Subsets {

    public static void main(String[] args) {
        L78Subsets test = new L78Subsets();
        System.out.println(test.subsets(new int[]{1, 2, 3}));


    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> numsI = new ArrayList<>();
        for (int num : nums) {
            numsI.add(num);
        }
        downInto(numsI, new ArrayList<>());
        return res;
    }

    private void downInto(List<Integer> numsI, List<Integer> tmp) {
        res.add(tmp);
        if (numsI.size() == 0) {
        } else {
            //这里与排列的区别就是往下传递的时候，只传递比当前数字大的
            List<Integer> newNumsITmp = new ArrayList<>(numsI);
            for (Integer num : numsI) {
                List<Integer> tmpRes = new ArrayList<>(tmp);
                tmpRes.add(num);

                newNumsITmp.remove(num);
                downInto(new ArrayList<>(newNumsITmp), tmpRes);
            }


        }

    }
}
