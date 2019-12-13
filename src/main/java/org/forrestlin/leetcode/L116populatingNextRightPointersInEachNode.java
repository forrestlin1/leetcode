package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 填充每个节点的下一个右侧节点指针
 * @author: forrestlin
 * @create: 2019-12-11 15:53
 */
public class L116populatingNextRightPointersInEachNode {


    /**
     * 迭代版本
     */
    public Node connect1(Node root) {
        Node pre = root;
        while (pre != null) {
            Node cur = pre;
            while (cur != null) {
                if (cur.left != null) {
                    cur.left.next = cur.right;
                }
                if (cur.right != null && cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }


    /**
     * 递归版本
     */
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;

        //这一步很关键，判断root的next来连接儿子
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);

        return root;

    }

}


class Node {

    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}