package org.forrestlin.leetcode2;

import java.util.LinkedList;
import java.util.Queue;

/*
 * 翻转二叉树
 * */
public class L226InvertBinaryTree {

    //递归法，先翻转子树，再交换子树
    public TreeNode invertTree(TreeNode root) {
        if (null == root) {
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    //迭代法 从上往下交换
    public TreeNode invertTree1(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.poll();
            TreeNode tmp = cur.left;
            cur.left = cur.right;
            cur.right = tmp;
            if (null != cur.left) {
                q.add(cur.left);
            }
            if (null != cur.right) {
                q.add(cur.right);
            }
        }
        return root;

    }
}
