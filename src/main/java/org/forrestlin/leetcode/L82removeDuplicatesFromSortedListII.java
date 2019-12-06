package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 删除排序链表中的重复元素 II
 * @author: forrestlin
 * @create: 2019-12-06 11:57
 */
public class L82removeDuplicatesFromSortedListII {


    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        //关键点是cur.val和cur.next.val进行比较
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) {
                    cur = cur.next;
                }

                pre.next = cur.next;
                cur = cur.next;

            } else {
                pre = cur;
                cur = cur.next;
            }
        }

        return dummy.next;

    }

}
