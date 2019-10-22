package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 从前序与中序遍历序列构造二叉树
 * @author: forrestlin
 * @create: 2019-10-22 11:14
 */
public class L105ConstructBinaryTreeFromPreorderAndIinorderTraversal {

    public static void main(String[] args) {
        L105ConstructBinaryTreeFromPreorderAndIinorderTraversal test = new L105ConstructBinaryTreeFromPreorderAndIinorderTraversal();
        TreeNode node = test.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        System.out.println();
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        List<Integer> preOrder = new ArrayList<>();
        for (int i : preorder) {
            preOrder.add(i);
        }
        List<Integer> inOrder = new ArrayList<>();
        for (int i : inorder) {
            inOrder.add(i);
        }

        return doBuildTree(preOrder, inOrder);

    }


    /**
     * 使用递归方式，先构建根节点，然后构建左子树，然后构建右子树
     * [左][根]<右>
     * 先序遍历：[3], {9}, <20, 15, 7 >
     * 中序遍历：{9}, [3], <15, 20, 7 >
     *
     * 找出左子树和右子树的前序和中序遍历
     * 再分别对左子树和右子树进行递归
     */
    private TreeNode doBuildTree(List<Integer> preOrder, List<Integer> inOrder) {

        if (preOrder == null || preOrder.size() == 0) {
            return null;
        }
        //1.找到根节点
        Integer rootVal = preOrder.get(0);
        TreeNode rootNode = new TreeNode(rootVal);

        //2.构造左子树

        List<Integer> leftInOrder = inOrder.subList(0, inOrder.indexOf(rootVal));
        List<Integer> leftPreOrder = preOrder.subList(1, 1 + leftInOrder.size());
        rootNode.left = doBuildTree(leftPreOrder, leftInOrder);

        //3.构造右子树
        List<Integer> rightInOrder = inOrder.subList(inOrder.indexOf(rootVal) + 1, inOrder.size());
        List<Integer> rightPreOrder = preOrder.subList(1 + leftInOrder.size(), inOrder.size());

        rootNode.right = doBuildTree(rightPreOrder, rightInOrder);

        return rootNode;
    }

}
