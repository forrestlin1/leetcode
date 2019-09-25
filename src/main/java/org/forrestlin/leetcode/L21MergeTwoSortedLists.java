package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 合并两个有序链表
 * @author: forrestlin
 * @create: 2019-09-25 17:05
 */
public class L21MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode dummyNode = new ListNode(0);
        ListNode res = dummyNode;
        while (l1 != null || l2 != null) {

            if (l1 == null) {
                dummyNode.next = l2;
                return res.next;
            }
            if (l2 == null) {
                dummyNode.next = l1;
                return res.next;
            }
            if (l1.val > l2.val) {
                dummyNode.next = l2;
                l2 = l2.next;
            } else {
                dummyNode.next = l1;
                l1 = l1.next;

            }
            dummyNode = dummyNode.next;

        }

        return res.next;

    }
}
