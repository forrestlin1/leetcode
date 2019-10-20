package org.forrestlin.leetcode;

/*
* 验证二叉搜索树
* */
public class L98ValidateBinarySearchTree {

    boolean res = true;
    int lastVal;
    boolean isFirstVal = true;

    public boolean isValidBST(TreeNode root) {
        backTrace(root);
        return res;

    }

    /**
     * 中序遍历，遍历的过程中判断是不是递增的
     */
    private void backTrace(TreeNode cur) {

        if (cur != null && cur.left != null) {

            backTrace(cur.left);

        }
        if (cur != null) {
            if (cur.val > lastVal || isFirstVal) {
                isFirstVal = false;
                lastVal = cur.val;
            } else {
                res = false;
                return;
            }
        }

        if (cur != null && cur.right != null) {

            backTrace(cur.right);

        }

    }
}
