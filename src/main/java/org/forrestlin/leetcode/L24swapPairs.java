package org.forrestlin.leetcode;

/*两两交换链表中的节点*/
public class L24swapPairs {

    public static void main(String[] args) {
        L24swapPairs test = new L24swapPairs();
        ListNode h = new ListNode(1);
        h.next = new ListNode(2);
        h.next.next = new ListNode(3);
        h.next.next.next = new ListNode(4);
        ListNode res = test.swapPairs_bd(h);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }
        ListNode cl = head;
        ListNode cr = head.next;
        ListNode next = head.next.next;
        ListNode dummy = new ListNode(-1);
        head = dummy;
        while (cr != null) {
            cl.next = next;
            cr.next = cl;
            dummy.next = cr;

            dummy = cl;
            cl = cl.next;
            if (cl != null) {
                cr = cl.next;
            } else {
                cr = null;
            }
            if (cr != null) {

                next = cr.next;
            } else {
                next = null;
            }
        }

        return head.next;

    }


    public ListNode swapPairs_bd(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode after = swapPairs_bd(head.next.next);
        ListNode newHead = head.next;
        head.next = after;
        newHead.next = head;
        return newHead;

    }
}
