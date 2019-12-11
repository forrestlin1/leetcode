package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 二叉树的层次遍历II
 * @author: forrestlin
 * @create: 2019-12-10 11:13 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
 */
public class L107binaryTreeLevelOrderTraversalII {

    public List<List<Integer>> levelOrderBottom1(TreeNode root) {

        LinkedList<List<Integer>> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        //这里使用queue,有addFirst
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> oneLevel = new ArrayList<>();
            // 每次都取出一层的所有数据
            int count = queue.size();
            //这里使用下标遍历，避免new一个来存
            for (int i = 0; i < count; i++) {
                TreeNode node = queue.poll();
                oneLevel.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            // 每次都往队头塞
            result.addFirst(oneLevel);
        }
        return result;
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        List<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);
        while (nodes.size() > 0) {
            List<Integer> line = new LinkedList<>();
            List<TreeNode> newNodes = new LinkedList<>();
            for (TreeNode node : nodes) {

                line.add(node.val);
                if (node.left != null) {

                    newNodes.add(node.left);
                }
                if (node.right != null) {

                    newNodes.add(node.right);
                }
            }
            res.add(line);
            nodes = newNodes;
        }

        Collections.reverse(res);
        return res;
    }
}
