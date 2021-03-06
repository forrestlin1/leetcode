package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: leetcode
 * @description: 删除链表的倒数第N个节点
 * @author: forrestlin
 * @create: 2019-09-25 10:22
 * <p>
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * <p>
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
public class L19RemoveNthNodeFromEndOfList {

    public static void main(String[] args) {
        L19RemoveNthNodeFromEndOfList test = new L19RemoveNthNodeFromEndOfList();
        ListNode head = new ListNode(0);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        ListNode listNode = test.removeNthFromEnd_bd(head, 3);
        while (listNode != null) {

            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    /**
     * 数组法
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        List<ListNode> nodeList = new ArrayList<>();

        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        if (nodeList.size() == n) {
            return nodeList.get(0).next;
        } else {
            nodeList.get(nodeList.size() - n - 1).next =
                nodeList.get(nodeList.size() - n).next == null ? null : nodeList.get(nodeList.size() - n + 1);
            return nodeList.get(0);
        }


    }

    /**
     * 双指针法 两个指针相隔n，当快指针指向末尾的时候，慢指针即为所要删除的节点
     */
    public ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode oriHead = head;
        ListNode needRemove = null;

        for (int i = 0; head != null; i++) {

            if (needRemove != null) {
                needRemove = needRemove.next;
            }

            if (i == n) {
                needRemove = oriHead;
            }

            head = head.next;
        }

        if (needRemove == null) {
            return oriHead.next;
        } else {
            needRemove.next = needRemove.next == null ? null : needRemove.next.next;
            return oriHead;
        }


    }

    /**
     * 练习用的
     * */
    public ListNode removeNthFromEnd_bd(ListNode head, int n) {
        ListNode oriHead = head;
        ListNode needRemove = null;

        for (int i = 0; head != null; i++) {
            if (needRemove != null) {
                needRemove = needRemove.next;
            }
            if (i == n) {
                needRemove = oriHead;
            }
            head = head.next;
        }

        if (needRemove == null) {
            return oriHead.next;
        } else {
            needRemove.next = needRemove.next == null ? null : needRemove.next.next;
            return oriHead;
        }
    }

}

