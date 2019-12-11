package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 路径总和
 * @author: forrestlin
 * @create: 2019-12-11 10:22
 */
public class L112pathSum {

    public static void main(String[] args) {
        L112pathSum test = new L112pathSum();
        TreeNode head = new TreeNode(1);
        System.out.println(test.hasPathSum(head, 0));
    }

    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }
}
