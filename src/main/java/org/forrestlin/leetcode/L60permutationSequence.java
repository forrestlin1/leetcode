package org.forrestlin.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 第K个排列
 * @author: forrestlin
 * @create: 2019-12-03 10:48
 */
public class L60permutationSequence {

    public static void main(String[] args) {
        L60permutationSequence test = new L60permutationSequence();
        System.out.println(test.getPermutation(4, 18));
    }

    /**
     * 假设现在n=3n=3，k=3k=3，那么我们如何直接获得第kk个排列呢？我们的方法是，一位一位地获取第kk个排列中的所有元素。
     * <p>
     * 比如说，在现在的假设下，我们怎么知道当n=3n=3时，第33个排列的第一个元素是什么呢？很简单，由于集合中的元素没有重复，每一个元素开头的排列的数量均相同，且均为(n-1)!(n−1)!。由此，我们可以得知，11开头的排列总数为2!=22!=2，同理2,32,3开头的排列总数也都为22。因此，第33个排列的第一位应当是22。
     * <p>
     * 当确定了第一位为22之后，我们首先需要做的就是从集合中去掉22，集合中剩下的元素个数就变为了n-1n−1。同时，还要从kk中减去(n-1)!(n−1)!，即只关注第一位为22的排列。
     */
    public String getPermutation(int n, int k) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        StringBuilder res = new StringBuilder("");
        k = k - 1;
        int index = 0;
        for (int i = n; i > 0; i--) {
            int temp = k / (fact(i - 1));
            int j = 0;
            int m = -1;
            while (j < n) {
                if (arr[j] == 0) {
                    j++;
                } else {
                    m++;
                    if (m == temp) {
                        res.append(arr[j]);
                        arr[j] = 0;
                        index++;
                        k = k % (fact(i - 1));
                        break;
                    }
                    j++;
                }
            }
        }
        return res.toString();

    }

    public static int fact(int n) {
        int res = 1;
        while (n > 1) {
            res = res * n;
            n--;
        }
        return res;
    }

    int cnt;
    int des;
    String res = "";

    /**
     * 回溯法
     */
    public String getPermutation1(int n, int k) {

        List<Integer> allNums = new LinkedList<>();
        for (int i = 1; i <= n; i++) {

            allNums.add(i);
        }

        cnt = 0;
        des = k;
        backTrace("", allNums);

        return res;

    }

    private void backTrace(String tmp, List<Integer> leastNums) {
        if (cnt >= des) {
            return;
        }
        if (leastNums.size() == 1) {
            tmp = tmp + leastNums.get(0);
            cnt++;
            if (cnt == des) {
                res = tmp;
            }
            return;
        }

        //剪枝
        int tmpcnt = leastNums.size() - 1;
        for (int i = tmpcnt - 1; i > 1; i--) {
            tmpcnt *= i;
        }

        for (Integer leastNum : leastNums) {
            if (cnt + tmpcnt < des) {
                cnt = cnt + tmpcnt;
                continue;
            }

            String newTmp = tmp + leastNum;
            List<Integer> newList = new LinkedList<>(leastNums);
            newList.remove(leastNum);
            backTrace(newTmp, newList);
        }


    }
}
