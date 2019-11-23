package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 二叉搜索树的第K个节点
 * @author: forrestlin
 * @create: 2019-11-21 20:21
 */
public class L62KthNode {

    public static void main(String[] args) {
        TreeNode head = new TreeNode(3);
        head.left = new TreeNode(1);
        head.right = new TreeNode(5);
        L62KthNode test = new L62KthNode();
        System.out.println(test.KthNode(head, 3).val);
    }

    int cnt;

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (null == pRoot) {
            return null;
        }
        cnt = k;
        return backTrace(pRoot);
    }

    private TreeNode backTrace(TreeNode node) {
        TreeNode target = null;

        if (null != node.left) {
            target = backTrace(node.left);
        }
        if (cnt == 1 && target == null) {
            System.out.println(node.val);
            return node;
        } else {
            cnt--;
        }
        if (null != node.right && target == null) {
            target = backTrace(node.right);
        }

        return target;
    }

}
