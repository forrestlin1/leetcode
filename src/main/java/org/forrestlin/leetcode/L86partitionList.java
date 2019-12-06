package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 分隔链表
 * @author: forrestlin
 * @create: 2019-12-06 17:08
 */
public class L86partitionList {

    public static void main(String[] args) {
        L86partitionList test = new L86partitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println(test.partition(head, 3));
    }

    public ListNode partition(ListNode head, int x) {

        ListNode left = new ListNode(1);
        ListNode right = new ListNode(2);

        while (head != null) {
            if (head.val < x) {
                left.next = head;
            } else if (head.val > x) {
                right.next = head;
            }
            ListNode tmp = head;
            head = head.next;
            tmp.next = null;
        }
        ListNode res = new ListNode(3);
        if (left.next != null) {
            res.next = left.next;
        }
        ListNode tmpTail = res;
        while (tmpTail.next != null) {
            tmpTail = tmpTail.next;
        }
        tmpTail.next = new ListNode(x);
        if (right.next != null) {
            tmpTail.next.next = right.next;
        }
        return res.next;

    }
}
