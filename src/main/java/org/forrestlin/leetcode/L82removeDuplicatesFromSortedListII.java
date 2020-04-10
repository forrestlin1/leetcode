package org.forrestlin.leetcode;

/*
 * @program: leetcode
 * @description: 删除排序链表中的重复元素 II
 * @author: forrestlin
 * @create: 2019-12-06 11:57
 *
 * 给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中 没有重复出现 的数字。

示例 1:

输入: 1->2->3->3->4->4->5
输出: 1->2->5
示例 2:

输入: 1->1->1->2->3
输出: 2->3

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
