package org.forrestlin.jianzhioffer;

import java.util.ArrayList;

/**
 * @program: leetcode
 * @description: 和为S的正数序列
 * @author: forrestlin
 * @create: 2019-11-18 17:28
 */
public class L41FindContinuousSequence {

    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {

        ArrayList<ArrayList<Integer>> p = new ArrayList<ArrayList<Integer>>();
        //有两个指针，一个指向头，一个指向尾
        //因为是连续的，构成等差数列，用等差数列的求和公式
        int low = 1, hight = 2;
        while (low < hight) {
            int temp = (low + hight) * (hight - low + 1) / 2;
            //如果相等，说明这个连续的数列可以构成和为sum
            if (temp == sum) {
                ArrayList<Integer> a = new ArrayList<Integer>();
                for (int i = low; i <= hight; i++) {
                    a.add(i);
                }
                p.add(a);
                //继续找下一组
                low++;
            } else if (temp < sum) {
                hight++;
            } else {
                low++;
            }
        }
        return p;
    }

}
