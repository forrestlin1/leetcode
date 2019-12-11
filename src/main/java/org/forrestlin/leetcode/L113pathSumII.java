package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 路径总和II
 * @author: forrestlin
 * @create: 2019-12-11 11:01
 */
public class L113pathSumII {

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        backTrace(new Stack<>(), root, sum);
        return res;
    }

    private void backTrace(Stack<Integer> routs, TreeNode node, int sum) {
        if (node == null) {
            return;
        }
        if (node.val == sum && node.left == null && node.right == null) {
            routs.add(node.val);
            res.add(new LinkedList<>(routs));
            routs.pop();
            return;

        }
        if (node.left != null) {
            routs.add(node.val);
            backTrace(routs, node.left, sum - node.val);
            routs.pop();
        }
        if (node.right != null) {
            routs.add(node.val);
            backTrace(routs, node.right, sum - node.val);
            routs.pop();
        }

    }
}
