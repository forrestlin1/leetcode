package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @program: leetcode
 * @description: 二叉树和为某一值的路径
 * @author: forrestlin
 * @create: 2019-11-13 11:09
 * <p>
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * <p>路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class L24FindPath {

    public static void main(String[] args) {
        L24FindPath test = new L24FindPath();
        TreeNode head = new TreeNode(10);
        head.left = new TreeNode(5);
        head.right = new TreeNode(12);
        head.left.left = new TreeNode(4);
        head.left.right = new TreeNode(7);
        System.out.println(test.FindPath(head, 22));
    }

    ArrayList<ArrayList<Integer>> res = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        backTrace(root, new ArrayList<>(), target);

        Collections.sort(res, (a, b) -> {
            if (a.size() > b.size()) {
                return -1;
            } else {
                return 1;
            }
        });
        return res;
    }

    private void backTrace(TreeNode node, ArrayList<Integer> path, int target) {
        //到叶子节点了
        if (null == node) {
            return;

        } else {
            ArrayList<Integer> newPath = new ArrayList<>(path);
            newPath.add(node.val);
            if (node.left != null) {
                backTrace(node.left, newPath, target);

            }
            if (node.right != null) {

                backTrace(node.right, newPath, target);
            }
            if (null == node.left && null == node.right) {
                int sum = 0;
                for (Integer val : newPath) {
                    sum += val;
                }
                if (target == sum) {
                    res.add(new ArrayList<>(newPath));
                }
            }

        }

    }
}
