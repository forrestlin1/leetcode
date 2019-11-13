package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 从上往下打印二叉树
 * @author: forrestlin
 * @create: 2019-11-13 10:11
 * <p>
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */
public class L22PrintFromTopToBottom {

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode poll = q.poll();
            res.add(poll.val);
            if (null != poll.left) {
                q.add(poll.left);
            }
            if (null != poll.right) {
                q.add(poll.right);
            }

        }
        return res;
    }
}
