package org.forrestlin.jianzhioffer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 树的子结构
 * @author: forrestlin
 * @create: 2019-11-12 11:08
 */
public class L17HasSubtree {

    public static void main(String[] args) {
        L17HasSubtree test = new L17HasSubtree();
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(8);
        head.left.left = new TreeNode(9);
        head.left.right = new TreeNode(2);
        head.right = new TreeNode(7);

        head.left.left.left = new TreeNode(6);

        TreeNode head1 = new TreeNode(8);
        head1.left = new TreeNode(9);
        head1.right = new TreeNode(2);

        System.out.println(test.HasSubtree(head, head1));
    }

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        Queue<TreeNode> list = new LinkedList<>();
        list.add(root1);
        while (!list.isEmpty()) {
            TreeNode poll = list.poll();
            if (poll.val == root2.val && isContain(poll, root2)) {
                return true;
            }
            if (null != poll.left) {
                list.add(poll.left);
            }
            if (null != poll.right) {
                list.add(poll.right);
            }
        }

        return false;
    }

    private boolean isContain(TreeNode t1, TreeNode t2) {
        if (t1 != null && t2 != null) {

            return (t1.val == t2.val) && isContain(t1.left, t2.left) && isContain(t1.right, t2.right);

        } else if (t2 == null) {
            return true;
        } else {
            return false;
        }


    }
}
