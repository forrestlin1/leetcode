package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 删除排序链表中的重复元素
 * @author: forrestlin
 * @create: 2019-12-06 16:59
 */
public class L83removeDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (null == head || null == head.next) {
            return head;
        }
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return head;

    }
}
