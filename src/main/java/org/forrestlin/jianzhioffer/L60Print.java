package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @program: leetcode
 * @description: 把二叉树打印成多行
 * @author: forrestlin
 * @create: 2019-11-21 18:30
 */
public class L60Print {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (null == pRoot) {
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        Queue<TreeNode> tmp = new LinkedList<>();
        q.add(pRoot);
        while (!q.isEmpty()) {
            ArrayList<Integer> l = new ArrayList<>();
            while (!q.isEmpty()) {
                TreeNode poll = q.poll();
                l.add(poll.val);
                if (poll.left != null) {
                    tmp.add(poll.left);
                }
                if (poll.right != null) {
                    tmp.add(poll.right);
                }
            }
            res.add(l);
            q.addAll(tmp);
            tmp.clear();
        }

        return res;
    }
}
