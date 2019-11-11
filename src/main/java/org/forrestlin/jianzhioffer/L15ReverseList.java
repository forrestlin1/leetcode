package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 反转链表
 * @author: forrestlin
 * @create: 2019-11-11 17:50
 */
public class L15ReverseList {

    public static void main(String[] args) {
        L15ReverseList test = new L15ReverseList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(test.ReverseList(head));
    }

    public ListNode ReverseList(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode after = cur.next;

        while (cur != null) {
            cur.next = pre;
            if (after == null) {
                break;
            }
            pre = cur;
            cur = after;
            after = after.next;

        }

        return cur;

    }
}
