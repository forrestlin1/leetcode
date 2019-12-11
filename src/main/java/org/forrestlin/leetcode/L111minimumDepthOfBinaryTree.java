package org.forrestlin.leetcode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 二叉树的最小深度
 * @author: forrestlin
 * @create: 2019-12-10 19:58
 */
public class L111minimumDepthOfBinaryTree {

    public static void main(String[] args) {
        L111minimumDepthOfBinaryTree test = new L111minimumDepthOfBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(test.minDepth(root));
    }

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depth = 1;
        Queue<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (nodes.size() > 0) {
            int cnt = nodes.size();

            for (int i = 0; i < cnt; i++) {
                TreeNode treeNode = nodes.poll();
                if (treeNode.left == null && treeNode.right == null) {
                    return depth;
                }
                if (treeNode.left != null) {
                    nodes.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    nodes.add(treeNode.right);
                }
            }
            depth++;
        }

        return depth;
    }
}
