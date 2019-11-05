package org.forrestlin.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 二叉树的最近公共祖先
 * @author: forrestlin
 * @create: 2019-11-05 11:28
 */
public class L236LowestCommonAncestorOfABinaryTree {

    /**
     * 这类树的题目，往往对左右子树递归的调用函数，大部分情况得到局部的解。然后通过左子树解，右子树解，以及根节点来构造出整棵树的解。
     *
     * 如果p或者q其中一个是root,那么,p和q的最近公共祖先就是root
     * 如果root是空,即root是None,那么,返回None,把这个和(1)结合来看,这种情况也是返回root
     * 如果p和q分别位于二叉树的根节点的左子树和右子树,则他们的最近公共祖先也是root
     * 如果p和q都位于二叉树的某一边的子树,则需要去那个子树上寻找他们的最近公共祖先(去左子树或者右子树去寻找)
     * 以上,是一个明显的递归描述
     *
     * */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        //去左子树看是否可以访问到p或q,并把结果返回给left
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        //去右子树看是否可以访问到p或q,并把结果返回给right
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //如果left,right都不为空,则说明在左子树和右子树都分别访问到了p或q,则此时root是最近公共祖先,否则,哪个不空则返回哪个
        return left == null ? right : (right == null ? left : root);

    }


    /**
     * bfs,把所有节点对应的父节点记录下来，然后找p和q的公共父节点
     * */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        // Stack for tree traversal
        Deque<TreeNode> stack = new ArrayDeque<>();

        // HashMap for parent pointers
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        parent.put(root, null);
        stack.push(root);

        // Iterate until we find both the nodes p and q
        while (!parent.containsKey(p) || !parent.containsKey(q)) {

            TreeNode node = stack.pop();

            // While traversing the tree, keep saving the parent pointers.
            if (node.left != null) {
                parent.put(node.left, node);
                stack.push(node.left);
            }
            if (node.right != null) {
                parent.put(node.right, node);
                stack.push(node.right);
            }
        }

        // Ancestors set() for node p.
        Set<TreeNode> ancestors = new HashSet<>();

        // Process all ancestors for node p using parent pointers.
        while (p != null) {
            ancestors.add(p);
            p = parent.get(p);
        }

        // The first ancestor of q which appears in
        // p's ancestor set() is their lowest common ancestor.
        while (!ancestors.contains(q))
            q = parent.get(q);
        return q;
    }


}
