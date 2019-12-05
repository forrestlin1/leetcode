package org.forrestlin.leetcode;

/**
 * @program: leetcode
 * @description: 旋转链表
 * @author: forrestlin旋转链表
 * @create: 2019-12-03 15:20 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。 示例 1: 输入: 1->2->3->4->5->NULL, k = 2 输出: 4->5->1->2->3->NULL 解释: 向右旋转 1 步:
 * 5->1->2->3->4->NULL 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2: 输入: 0->1->2->NULL, k = 4 输出: 2->0->1->NULL 解释: 向右旋转 1 步: 2->0->1->NULL 向右旋转 2 步: 1->2->0->NULL 向右旋转 3 步: 0->1->2->NULL 向右旋转 4
 * 步: 2->0->1->NULL
 */
public class L61rotateList {

    public static void main(String[] args) {
        L61rotateList test = new L61rotateList();
        ListNode head = new ListNode(1);
        //head.next = new ListNode(2);

        ListNode listNode = test.rotateRight(head, 4);
        while (listNode != null) {

            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }


    /**
     * 官方解法，先连成环，再找新头部，然后打破环
     */
    public ListNode rotateRight1(ListNode head, int k) {
        // base cases
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }

        // close the linked list into the ring
        ListNode old_tail = head;
        int n;
        for (n = 1; old_tail.next != null; n++) {
            old_tail = old_tail.next;
        }
        old_tail.next = head;

        // find new tail : (n - k % n - 1)th node
        // and new head : (n - k % n)th node
        ListNode new_tail = head;
        for (int i = 0; i < n - k % n - 1; i++) {
            new_tail = new_tail.next;
        }
        ListNode new_head = new_tail.next;

        // break the ring
        new_tail.next = null;

        return new_head;
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        int len = 0;
        ListNode tmpCur = head;
        //计算长度
        while (tmpCur != null) {
            len++;
            tmpCur = tmpCur.next;
        }
        int rotate = k % len;
        if (rotate == 0) {
            return head;
        }
        //获取旋转点
        tmpCur = head;
        ListNode newEnd = head;
        while (tmpCur != null) {
            if (rotate >= 0) {
                rotate--;
            } else {
                newEnd = newEnd.next;
            }
            tmpCur = tmpCur.next;

        }
        //获取原链表尾节点
        ListNode newHead = newEnd.next;
        tmpCur = newHead;
        while (tmpCur.next != null) {
            tmpCur = tmpCur.next;
        }

        newEnd.next = null;
        tmpCur.next = head;
        return newHead;

    }
}
