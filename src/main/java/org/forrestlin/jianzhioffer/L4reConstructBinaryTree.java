package org.forrestlin.jianzhioffer;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
重建二叉树
* */
public class L4reConstructBinaryTree {

    public static void main(String[] args) {
        L4reConstructBinaryTree test = new L4reConstructBinaryTree();
        TreeNode res = test.reConstructBinaryTree(new int[]{1, 2, 3, 4, 5, 6, 7}, new int[]{3, 2, 4, 1, 6, 5, 7});
        System.out.println(res);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        List<Integer> preList = Arrays.stream(pre).boxed().collect(Collectors.toList());
        List<Integer> inList = Arrays.stream(in).boxed().collect(Collectors.toList());
        return build(preList, inList);

    }

    private TreeNode build(List<Integer> preList, List<Integer> inList) {
        if (preList == null | preList.size() == 0) {
            return null;
        }
        Integer rootVal = preList.get(0);
        TreeNode root = new TreeNode(rootVal);
        //左子树的中序
        List<Integer> newInListLeft = inList.subList(0, inList.indexOf(rootVal));
        //左子树的先序
        List<Integer> newPreListLeft = preList.subList(1, newInListLeft.size() + 1);
        root.left = build(newPreListLeft, newInListLeft);

        //右子树的中序
        List<Integer> newInListright = inList.subList(inList.indexOf(rootVal) + 1, inList.size());
        //右子树的先序
        List<Integer> newPreListright = preList.subList(1 + newInListLeft.size(), preList.size());

        root.right = build(newPreListright,newInListright);

        return root;
    }


}
