package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 环形链表
 * @author: forrestlin
 * @create: 2019-10-25 11:37
 */
public class L141LinkedListCycle {

    /**
     * 快慢指针法，快指针走两格，慢指针走一格，有环的话最终会相遇
     */
    public boolean hasCycle(ListNode head) {

        if (head == null || head.next == null) {

            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != slow) {

            if (fast == null || fast.next == null) {
                return false;
            }
            fast = fast.next.next;
            slow = slow.next;
        }

        return true;
    }
}
