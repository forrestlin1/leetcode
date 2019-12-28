package org.forrestlin.leetcode;

import java.util.Stack;

/**
 * 二叉搜索树迭代器
 */
public class L73binarySearchTreeIterator {

    Stack<TreeNode> stack = new Stack<>();
    TreeNode cur = null;

    public L73binarySearchTreeIterator(TreeNode root) {
        this.cur = root;
    }

    /**
     * @return the next smallest number
     */
    public int next() {
        int res = -1;
        while (cur != null || !stack.isEmpty()) {
            //左子树不断入栈
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            res = cur.val;
            cur = cur.right;
            break;

        }
        return res;

    }

    /**
     * @return whether we have a next smallest number
     */
    public boolean hasNext() {
        return cur != null || !stack.isEmpty();
    }
}
