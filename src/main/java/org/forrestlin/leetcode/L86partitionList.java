package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 分隔链表
 * @author: forrestlin
 * @create: 2019-12-06 17:08
 */
public class L86partitionList {

    public static void main(String[] args) {
        L86partitionList test = new L86partitionList();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        System.out.println(test.partition(head, 3));
        System.out.println("");
    }

    /**
     * 官方解法 先将链表分离为大于x和小于x的两个，然后接起来
     */
    public ListNode partition(ListNode head, int x) {

        // before and after are the two pointers used to create the two list
        // before_head and after_head are used to save the heads of the two lists.
        // All of these are initialized with the dummy nodes created.
        ListNode before_head = new ListNode(0);
        ListNode before = before_head;
        ListNode after_head = new ListNode(0);
        ListNode after = after_head;

        while (head != null) {

            // If the original list node is lesser than the given x,
            // assign it to the before list.
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                // If the original list node is greater or equal to the given x,
                // assign it to the after list.
                after.next = head;
                after = after.next;
            }

            // move ahead in the original list
            head = head.next;
        }

        // Last node of "after" list would also be ending node of the reformed list
        after.next = null;

        // Once all the nodes are correctly assigned to the two lists,
        // combine them to form a single list which would be returned.
        before.next = after_head.next;

        return before_head.next;
    }


    /**
     * 遍历链表，把小的节点提到前面
     */
    public ListNode partition1(ListNode head, int x) {

        if (null == head || null == head.next) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = pre;
        //找出比x小的最后一个节点，后续的小节点可以往后面加
        while (cur.next != null) {
            if (cur.next.val < x) {
                cur = cur.next;
            } else {
                pre = cur;
                break;
            }
        }

        //将小的节点迁移到上一步找到的小节点后面
        ListNode curNext = cur.next;
        while (cur != null && curNext != null) {
            if (curNext.val < x) {
                ListNode preNext = pre.next;
                pre.next = curNext;
                cur.next = curNext.next;
                pre.next.next = preNext;
                pre = pre.next;
                curNext = cur.next;
            } else {
                cur = curNext;
                curNext = cur.next;
            }
        }

        return dummy.next;

    }
}
