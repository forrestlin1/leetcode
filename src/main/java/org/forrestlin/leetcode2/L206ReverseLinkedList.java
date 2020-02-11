package org.forrestlin.leetcode2;



/**
 * @program: leetcode
 * @description: 反转链表
 * @author: forrestlin
 * @create: 2019-10-30 10:38
 */
public class L206ReverseLinkedList {

    public static void main(String[] args) {
        L206ReverseLinkedList test = new L206ReverseLinkedList();
        ListNode head = new ListNode(4);
        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(2);
        head.next = l1;
        l1.next = l2;

        System.out.println(test.reverseList(head));

        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    /*
     * 迭代法，需要三个指针
     * 也可以用栈，先入栈再出栈，逻辑简单
     * */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode before = null;
        ListNode moved = head;
        ListNode after = head.next;
        while (moved != null) {
            moved.next = before;
            before = moved;
            moved = after;
            if (after != null) {

                after = after.next;
            }
        }
        return before;

    }

    /*
     * 递归版本
     * */
    public ListNode reverseList1(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }


}
