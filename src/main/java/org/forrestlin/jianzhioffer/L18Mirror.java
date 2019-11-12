package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二叉树的镜像
 * @author: forrestlin
 * @create: 2019-11-12 15:32
 */
public class L18Mirror {

    public static void main(String[] args) {
        L18Mirror test = new L18Mirror();
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(8);
        head.left.left = new TreeNode(9);
        head.left.right = new TreeNode(2);
        head.right = new TreeNode(7);

        test.Mirror(head);
        System.out.println(1);
    }

    public void Mirror(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        Mirror(root.left);
        Mirror(root.right);
    }


}
