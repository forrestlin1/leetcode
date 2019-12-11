package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 相同的树
 * @author: forrestlin
 * @create: 2019-12-09 16:09
 */
public class L100sameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p != null && q != null) {
            return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        } else {
            return false;
        }
    }

}
