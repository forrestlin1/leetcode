package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 重排链表
 * @author: forrestlin
 * @create: 2019-12-26 14:39
 */
public class L143reorderList {

    public static void main(String[] args) {
        L143reorderList test = new L143reorderList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        test.reorderList(head);
        System.out.println("");

    }

    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        //找到中点
        ListNode fast = head;
        ListNode slow = head;
        ListNode beforeSlow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            beforeSlow = slow;
            slow = slow.next;
        }

        //断开成两部分
        beforeSlow.next = null;

        //反转链表
        ListNode pre = null;
        ListNode cur = slow;
        ListNode after = slow.next;
        while (cur != null) {
            cur.next = pre;
            pre = cur;
            cur = after;
            if (after != null) {
                after = after.next;
            }
        }

        //得到链表的头pre
        //拼接两个链表
        ListNode res = new ListNode(0);
        ListNode tmp = res;
        while (pre != null || head != null) {
            if (head != null) {
                tmp.next = head;
                head = head.next;
                tmp = tmp.next;
            }
            if (pre != null) {
                tmp.next = pre;
                pre = pre.next;
                tmp = tmp.next;
            }
        }

        head = res.next;

    }


}
