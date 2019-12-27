package org.forrestlin.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 二叉树的后序遍历
 * @author: forrestlin
 * @create: 2019-12-26 17:16
 */
public class L145binaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        LinkedList<Integer> output = new LinkedList<>();
        if (root == null) {
            return output;
        }

        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            //遍历的时候是逆序遍历的，估写入结果是addFirst
            output.addFirst(node.val);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (node.right != null) {
                stack.add(node.right);
            }
        }
        return output;
    }

}
