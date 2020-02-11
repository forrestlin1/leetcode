package org.forrestlin.leetcode2;

/*
 * 打家劫舍3
 * */
public class L337HouseRobberIII {

    public static void main(String[] args) {
        L337HouseRobberIII test = new L337HouseRobberIII();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        System.out.println(test.rob(root));
    }

    /*
     * 可参考L198打家劫舍
     * 对于一个以 node 为根节点的二叉树而言，如果尝试偷取 node 节点，那么势必不能偷取其左右子节点，然后继续尝试偷取其左右子节点的左右子节点。
     *
     *如果不偷取该节点，那么只能尝试偷取其左右子节点。
     *
     *比较两种方式的结果，谁大取谁。
     *
     * */
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        //偷取根节点+左右子树的左右子节点的情况
        int res1 = root.val;
        if (root.left != null) {
            res1 += (rob(root.left.left) + rob(root.left.right));
        }
        if (root.right != null) {
            res1 += (rob(root.right.left) + rob(root.right.right));
        }

        //不偷取根节点的情况，只偷取左右子节点
        int res2 = rob(root.left) + rob(root.right);

        return Math.max(res1, res2);

    }


}
