package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 链表中倒数第K个节点
 * @author: forrestlin
 * @create: 2019-11-11 17:20
 */
public class L14FindKthToTail {

    public static void main(String[] args) {
        L14FindKthToTail test = new L14FindKthToTail();
        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        System.out.println(test.FindKthToTail(head, 4).val);
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (0 == k) {
            return null;
        }
        ListNode kNode = null;
        ListNode tailNode = head;
        while (k - 1 > 0 && tailNode != null) {

            tailNode = tailNode.next;
            k--;
        }
        //k大于链表的长度
        if (tailNode == null) {
            return null;
        }
        kNode = head;

        while (tailNode.next != null) {
            tailNode = tailNode.next;
            kNode = kNode.next;
        }
        return kNode;

    }
}
