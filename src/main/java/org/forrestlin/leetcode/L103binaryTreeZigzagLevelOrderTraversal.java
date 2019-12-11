package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @program: leetcode
 * @description: 二叉树的锯齿形遍历
 * @author: forrestlin
 * @create: 2019-12-09 16:17
 */
public class L103binaryTreeZigzagLevelOrderTraversal {

    public static void main(String[] args) {
        L103binaryTreeZigzagLevelOrderTraversal test = new L103binaryTreeZigzagLevelOrderTraversal();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(test.zigzagLevelOrder(root));
    }

    /**
     * DFS
     */
    public List<List<Integer>> zigzagLevelOrder1(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        traversal(root, res, 0);
        return res;
    }

    private void traversal(TreeNode root, List<List<Integer>> res, int level) {
        if (root == null) {
            return;
        }

        if (res.size() == level) {
            res.add(new ArrayList<Integer>());
        }

        if ((level & 1) == 1) {
            res.get(level).add(0, root.val);
        } else {
            res.get(level).add(root.val);
        }

        traversal(root.left, res, level + 1);
        traversal(root.right, res, level + 1);
    }


    /**
     * BFS
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        res.add(Arrays.asList(root.val));
        List<TreeNode> nodes = new ArrayList<>();
        if (null != root.left) {
            nodes.add(root.left);
        }
        if (null != root.right) {
            nodes.add(root.right);
        }
        //加入下一层时先加左子树还是先加右子树
        boolean lefToRight = false;
        //除了根节点，其他节点都是反向读取
        //偶数层需要先写入右子，再写入左子，奇数层反之
        while (nodes.size() > 0) {
            List<Integer> line = new ArrayList<>();
            List<TreeNode> newNodes = new ArrayList<>();
            for (int i = nodes.size() - 1; i >= 0; i--) {
                line.add(nodes.get(i).val);
                if (lefToRight) {
                    if (nodes.get(i).left != null) {
                        newNodes.add(nodes.get(i).left);
                    }
                    if (nodes.get(i).right != null) {
                        newNodes.add(nodes.get(i).right);
                    }

                } else {
                    if (nodes.get(i).right != null) {
                        newNodes.add(nodes.get(i).right);
                    }
                    if (nodes.get(i).left != null) {
                        newNodes.add(nodes.get(i).left);
                    }
                }

            }
            res.add(line);
            nodes = newNodes;
            lefToRight = !lefToRight;
        }
        return res;
    }
}
