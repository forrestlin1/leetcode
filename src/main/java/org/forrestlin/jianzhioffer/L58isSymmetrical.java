package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 对称的二叉树
 * @author: forrestlin
 * @create: 2019-11-21 15:25
 */
public class L58isSymmetrical {

    public boolean isSymmetrical(TreeNode pRoot) {
        if (null == pRoot) {
            return false;
        }
        return isMirror(pRoot.left, pRoot.right);

    }

    private boolean isMirror(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left != null && right != null) {
            return left.val == right.val && isMirror(left.left, right.right) && isMirror(left.right, right.left);
        }
        return false;

    }
}
