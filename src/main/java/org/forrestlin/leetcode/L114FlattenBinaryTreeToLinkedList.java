package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 二叉树展开为链表
 * @author: forrestlin
 * @create: 2019-10-22 19:50
 */
public class L114FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {

        backTrace(root);

    }

    /**
     * 中序遍历，遍历的过程中，将左节点折到右节点，再拼上原有的右节点
     */
    private TreeNode backTrace(TreeNode node) {
        if (null == node) {
            return null;
        }
        TreeNode leftTreeNode = null;
        TreeNode rightTreeNode = null;

        if (node.left != null) {
            leftTreeNode = backTrace(node.left);
        }

        if (node.right != null) {
            rightTreeNode = backTrace(node.right);
        }

        //展开成为链表
        if (leftTreeNode != null) {
            node.right = leftTreeNode;

            while (leftTreeNode.right != null) {
                leftTreeNode = leftTreeNode.right;
            }
            leftTreeNode.right = rightTreeNode;
        }

        node.left = null;

        return node;
    }
}
