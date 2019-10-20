package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的中序遍历
 */
public class L94BinaryTreeInorderTraversal {

    List<Integer> res = new ArrayList<>();

    /**
     * 递归解法
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        if (root.left != null) {
            inorderTraversal(root.left);
        }

        res.add(root.val);

        if (root.right != null) {
            inorderTraversal(root.right);
        }
        return res;
    }

    /**
     * 非递归解法
     */
    public List<Integer> inorderTraversal1(TreeNode root) {
        Stack<TreeNode> help = new Stack<>();

        TreeNode cur = root;


        while (cur != null||!help.isEmpty()) {
            while (cur != null) {
                help.push(cur);
                cur = cur.left;
            }

            cur = help.pop();
            res.add(cur.val);
            cur = cur.right;



        }

        return res;

    }
}
