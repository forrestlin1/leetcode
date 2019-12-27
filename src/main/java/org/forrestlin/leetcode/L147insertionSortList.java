package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 对链表进行插入排序
 * @author: forrestlin
 * @create: 2019-12-26 17:50
 */
public class L147insertionSortList {

    public static void main(String[] args) {
        L147insertionSortList test = new L147insertionSortList();

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        test.insertionSortList(head);
        System.out.println("");
    }

    ListNode res = new ListNode(Integer.MIN_VALUE);

    public ListNode insertionSortList(ListNode head) {
        while (head != null) {
            ListNode headNext = head.next;
            head.next = null;
            insert(head);
            head = headNext;
        }
        return res.next;
    }

    private void insert(ListNode node) {
        ListNode before = res;
        ListNode after = res.next;
        while (before != null) {
            if (after == null) {
                before.next = node;
                break;
            } else if (before.val <= node.val && after.val >= node.val) {
                before.next = node;
                node.next = after;
                break;
            } else {
                before = after;
                after = after.next;
            }

        }
    }
}
