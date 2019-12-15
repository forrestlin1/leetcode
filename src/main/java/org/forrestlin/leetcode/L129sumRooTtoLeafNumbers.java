package org.forrestlin.leetcode;

/**
 * 求根到叶子节点数字之和
 */
public class L129sumRooTtoLeafNumbers {

    public static void main(String[] args) {
        L129sumRooTtoLeafNumbers test = new L129sumRooTtoLeafNumbers();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        System.out.println(test.sumNumbers(root));
    }

    int res;

    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        eachSum(root, 0);
        return res;
    }

    private void eachSum(TreeNode node, int tmpSum) {

        int num = node.val;

        if (node.left == null && node.right == null) {
            res += tmpSum * 10 + node.val;
        }

        if (node.left != null) {
            eachSum(node.left, tmpSum * 10 + num);
        }
        if (node.right != null) {
            eachSum(node.right, tmpSum * 10 + num);
        }

    }


}
