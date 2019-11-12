package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 合并两个排序链表
 * @author: forrestlin
 * @create: 2019-11-12 10:37
 */
public class L16Merge {

    public static void main(String[] args) {
        L16Merge test = new L16Merge();
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        System.out.println(test.Merge(head1, head).next.val);
    }

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null || list2 == null) {
            return list1 == null ? list2 : list1;
        }

        ListNode head = new ListNode(0);
        ListNode res = head;
        while (list1 != null || list2 != null) {
            if (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    head.next = list1;
                    list1 = list1.next;
                } else {
                    head.next = list2;
                    list2 = list2.next;
                }
            } else if (list1 == null) {
                head.next = list2;
                list2 = list2.next;
            } else if (list2 == null) {
                head.next = list1;
                list1 = list1.next;
            }

            head = head.next;

        }

        return res.next;
    }

}
