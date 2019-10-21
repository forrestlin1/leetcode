package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 二叉树最大深度
 * @author: forrestlin
 * @create: 2019-10-21 19:42
 */
public class L104MaximumDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        L104MaximumDepthOfBinaryTree test = new L104MaximumDepthOfBinaryTree();
        System.out.println(test.maxDepth(root));
    }

    int res = 0;

    public int maxDepth(TreeNode root) {

        backTrace(root, 1);
        return res;
    }

    private void backTrace(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (node.left != null) {
            backTrace(node.left, level + 1);
        }

        res = level > res ? level : res;

        if (node.right != null) {
            backTrace(node.right, level + 1);
        }

    }

}
