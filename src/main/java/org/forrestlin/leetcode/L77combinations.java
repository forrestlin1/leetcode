package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * @program: leetcode
 * @description: 组合
 * @author: forrestlin
 * @create: 2019-12-05 18:06
 * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:

输入: n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

 */
public class L77combinations {

    public static void main(String[] args) {
        L77combinations test = new L77combinations();
        System.out.println(test.combine(4, 2));
    }

    private List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || n < k) {
            return result;
        }
        findCombinations(n, k, 1, new Stack<>());
        return result;
    }


    // p 可以声明成一个栈
    // i 的极限值满足： n - i + 1 = (k - pre.size())。
    // 【关键】n - i + 1 是闭区间 [i,n] 的长度。
    // k - pre.size() 是剩下还要寻找的数的个数。
    private void findCombinations(int n, int k, int index, Stack<Integer> p) {
        if (p.size() == k) {
            result.add(new ArrayList<>(p));
            return;
        }
        //TODO 这里关键是剪枝 n - (k - p.size()) + 1
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.push(i);
            findCombinations(n, k, i + 1, p);
            p.pop();
        }
    }


    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine1(int n, int k) {
        if (n == 0 || k == 0) {
            return res;
        }

        List<Integer> allNums = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            allNums.add(i);
        }
        backTrace(new Stack<>(), allNums, 0, k);
        return res;
    }

    private void backTrace(Stack<Integer> pre, List<Integer> allNums, int start, int remainCnt) {
        if (0 == remainCnt) {
            res.add(new ArrayList<>(pre));
            return;
        }

        for (int i = start; i < allNums.size(); i++) {
            Integer num = allNums.get(i);
            pre.add(num);
            backTrace(pre, allNums, i + 1, remainCnt - 1);
            pre.pop();
        }

    }


}
