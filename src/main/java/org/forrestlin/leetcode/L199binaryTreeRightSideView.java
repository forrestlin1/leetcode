package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 二叉树的右视图
 */
public class L199binaryTreeRightSideView {

    public static void main(String[] args) {
        L199binaryTreeRightSideView test = new L199binaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);

    }

    /*
    *
    *1.这道题树的每一层只保存一个节点

2.保存的节点为最右侧节点

基于这两个要求，我们想一下如何处理：

1.可以创建一个当前深度标记变量deep，让deep与遍历的结果集合result.length进行比较，如果deep大于result.length，就说明这一层还没有将最右节点放入结果集，反之则是放过了。这样就能达成每层只放一个节点的逻辑

2.调整一下递归时遍历左右节点的顺序，让右侧节点先开始遍历，就能配合处理1。这样就能达成优先放入最右侧节点的逻辑
    * */

    List<Integer> list = new ArrayList<>();

    public List<Integer> rightSideView2(TreeNode root) {
        helper(root, 0);
        return list;
    }

    public void helper(TreeNode root, int n) {
        if (root == null) {
            return;
        }
        if (n == list.size()) {
            list.add(root.val);
        }
        helper(root.right, n + 1);
        helper(root.left, n + 1);
    }

    /*非递归方法*/
    public List<Integer> rightSideView1(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> ret = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (i == size - 1) {
                    ret.add(node.val);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return ret;
    }


    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> l1 = new LinkedList<>();
        LinkedList<TreeNode> l2 = new LinkedList<>();
        l1.add(root);
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        while (l1.size() > 0 || l2.size() > 0) {
            TreeNode node = null;
            while (l1.size() > 0) {
                node = l1.pollFirst();
                if (node.left != null) {
                    l2.add(node.left);
                }
                if (node.right != null) {
                    l2.add(node.right);
                }
            }
            if (node != null) {

                res.add(node.val);
            }
            node = null;
            while ((l2.size() > 0)) {
                node = l2.pollFirst();
                if (node.left != null) {
                    l1.add(node.left);
                }
                if (node.right != null) {
                    l1.add(node.right);
                }
            }
            if (node != null) {

                res.add(node.val);
            }
        }

        return res;

    }


}
