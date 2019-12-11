package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 从中序与后序遍历序列构造二叉树
 * @author: forrestlin
 * @create: 2019-12-09 17:13
 */
public class L106ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (null == inorder || null == postorder || inorder.length == 0) {
            return null;
        }
        List<Integer> inOrders = new ArrayList<>();
        for (int i : inorder) {
            inOrders.add(i);
        }
        List<Integer> postOrders = new ArrayList<>();
        for (int i : postorder) {
            postOrders.add(i);
        }

        return doBuildTree(inOrders, postOrders);

    }

    private TreeNode doBuildTree(List<Integer> inOrders, List<Integer> postOrders) {
        Integer rootVal = postOrders.get(postOrders.size() - 1);
        TreeNode root = new TreeNode(rootVal);

        int rootIndexin = inOrders.indexOf(rootVal);

        List<Integer> leftInOrders = inOrders.subList(0, rootIndexin);
        List<Integer> rightInOrders = inOrders.subList(rootIndexin + 1, inOrders.size());

        List<Integer> leftPostOrders = postOrders.subList(0, leftInOrders.size());
        List<Integer> rightPostOrders = postOrders.subList(leftInOrders.size(), postOrders.size() - 1);

        if (leftInOrders.size() > 0) {
            TreeNode left = doBuildTree(leftInOrders, leftPostOrders);
            root.left = left;
        }
        if (rightInOrders.size() > 0) {
            TreeNode right = doBuildTree(rightInOrders, rightPostOrders);
            root.right = right;
        }
        return root;


    }


}
