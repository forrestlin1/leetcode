package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二叉树的深度
 * @author: forrestlin
 * @create: 2019-11-18 15:15
 */
public class L38TreeDepth {

    public int TreeDepth(TreeNode root) {

        return backTrace(root, 0);
    }

    private int backTrace(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        int depthL = depth + 1, depthR = depth + 1;
        if (root.left != null) {
            depthL = backTrace(root.left, depth + 1);
        }
        if (root.right != null) {
            depthR = backTrace(root.right, depth + 1);
        }

        return Math.max(depthL, depthR);


    }

}
