package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 二叉树的层次遍历
 * @author: forrestlin
 * @create: 2019-10-21 19:19
 */
public class L102BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (null == root) {
            return res;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        while (nodeList.size() > 0) {
            List<Integer> curLevel = new ArrayList<>();
            List<TreeNode> newNodeList = new ArrayList<>();
            for (TreeNode treeNode : nodeList) {
                curLevel.add(treeNode.val);
                if (treeNode.left != null) {
                    newNodeList.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    newNodeList.add(treeNode.right);
                }
            }

            res.add(curLevel);
            nodeList = newNodeList;
        }

        return res;


    }

}
