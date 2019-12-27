package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 二叉树的前序遍历
 * @author: forrestlin
 * @create: 2019-12-26 16:17
 */
public class L144binaryTreePreorderTraversal {

    List<Integer> res = new ArrayList<>();

    /**
     * 递归方式
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        backTrace(root);
        return res;
    }

    private void backTrace(TreeNode node) {
        if (null == node) {
            return;
        }
        res.add(node.val);
        backTrace(node.left);
        backTrace(node.right);
    }

    /**
     * 非递归方式
     */
    public List<Integer> preorderTraversal1(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            res.add(node.val);
            if (node.right != null) {
                stack.add(node.right);
            }
            if (node.left != null) {
                stack.add(node.left);
            }
        }

        return res;
    }


}
