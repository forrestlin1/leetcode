package org.forrestlin.leetcode;

/*
*对称二叉树
* */
public class L101SymmetricTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        L101SymmetricTree test = new L101SymmetricTree();
        System.out.println(test.isSymmetric(root));
    }


    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    /**
     * 定义镜像递归函数
     */
    private boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        } else {
            return t1.val == t2.val && isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
        }

    }
}
