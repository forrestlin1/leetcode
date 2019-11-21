package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 链表中环的入口点
 * @author: forrestlin
 * @create: 2019-11-20 16:31
 */
public class L55EntryNodeOfLoop {

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;

        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                break;

            }
        }

        ListNode kou = pHead;
        while (slow != kou) {
            kou = kou.next;
            slow = slow.next;
        }

        return kou;


    }

}
