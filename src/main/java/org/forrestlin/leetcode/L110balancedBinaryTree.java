package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 平衡二叉树
 * @author: forrestlin
 * @create: 2019-12-10 18:09
 */
public class L110balancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        if (null == root) {
            return true;
        }
        return backTrace(root, 1) == -1 ? false : true;
    }

    public int backTrace(TreeNode node, int depth) {
        if (depth == -1) {
            return -1;
        }
        int depthLeft = depth;
        int depthRight = depth;
        if (node.left != null) {
            depthLeft = backTrace(node.left, depth + 1);
        }
        if (node.right != null) {
            depthRight = backTrace(node.right, depth + 1);
        }
        if (Math.abs(depthLeft - depthRight) <= 1 && depthLeft != -1 && depthRight != -1) {
            return Math.max(depthLeft, depthRight);
        } else {
            return -1;
        }
    }

}
