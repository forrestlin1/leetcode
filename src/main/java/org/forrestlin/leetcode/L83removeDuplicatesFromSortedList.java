package org.forrestlin.leetcode;

/*
 * @program: leetcode
 * @description: 删除排序链表中的重复元素
 * @author: forrestlin
 * @create: 2019-12-06 16:59
 *
 * 给定一个排序链表，删除所有重复的元素，使得每个元素只出现一次。

示例 1:

输入: 1->1->2
输出: 1->2
示例 2:

输入: 1->1->2->3->3
输出: 1->2->3

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
