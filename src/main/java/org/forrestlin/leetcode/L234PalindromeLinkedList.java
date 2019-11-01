package org.forrestlin.leetcode;

/*
 *回文链表
 * */
public class L234PalindromeLinkedList {

    public static void main(String[] args) {
        L234PalindromeLinkedList test = new L234PalindromeLinkedList();
        ListNode l1 = new ListNode(1);
        //l1.next = new ListNode(1);
        //l1.next.next = new ListNode(1);
        //l1.next.next.next = new ListNode(2);
        //l1.next.next.next.next = new ListNode(1);
        System.out.println(test.isPalindrome(l1));

    }

    /*
     * 快慢指针找中点
     * 翻转前半部分链表
     * 遍历比较
     * */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //翻转
        ListNode fast = head;
        ListNode slow = head;
        //以下两个节点用于辅助找中点的同时进行前半部分链表翻转
        ListNode ahead = null;
        ListNode cur = head;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            cur.next = ahead;
            ahead = cur;
            cur = slow;
        }

        //这里考虑的是链表长度是奇数还是偶数的情况
        if (fast != null) {
            cur = cur.next;
        }

        //判断两个链表是否相等
        while (cur != null && ahead != null) {
            if (cur.val != ahead.val) {
                return false;
            }
            cur = cur.next;
            ahead = ahead.next;
        }
        if (cur == null && ahead == null) {
            return true;
        } else {
            return false;
        }

    }
}
