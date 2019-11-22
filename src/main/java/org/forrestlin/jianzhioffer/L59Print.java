package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @program: leetcode
 * @description: 按之子形打印二叉树
 * @author: forrestlin
 * @create: 2019-11-21 16:21
 */
public class L59Print {

    public static void main(String[] args) {
        L59Print test = new L59Print();
        TreeNode head = new TreeNode(8);
        head.left = new TreeNode(8);
        head.left.left = new TreeNode(9);
        head.left.right = new TreeNode(2);
        head.right = new TreeNode(7);
        head.left.left.left = new TreeNode(1);
        head.left.left.right = new TreeNode(2);

        System.out.println(test.Print(head));
    }


    /**
     * 这里的关键点是用了两个栈，巧妙使用栈先进后出的特性，达到之字遍历的效果!!!!
     */
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<>();

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        while (!s1.empty() || !s2.empty()) {
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s2.push(node.left);
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        s1.push(node.right);
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }
}
