package org.forrestlin.jianzhioffer;

/**
 * @program: leetcode
 * @description: 两个链表的第一个公共节点
 * @author: forrestlin
 * @create: 2019-11-18 11:08
 */
public class L36FindFirstCommonNode {

    public static void main(String[] args) {
        L36FindFirstCommonNode test = new L36FindFirstCommonNode();

        ListNode head = new ListNode(4);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);
        ListNode head2 = new ListNode(6);
        head2.next = new ListNode(6);
        head2.next.next = head.next;
        System.out.println(test.FindFirstCommonNode(head, head2).val);
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {

        if (pHead1 == null || pHead2 == null) {
            return null;
        }

        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            // 寻找公共节点
            if (p1 != p2) {
                //// 判断谁先走到了头 先走到头的回来继续走
                //// 相当于减去长链表比短链表长的部分 然后2个相同长度的链表从头开始遍历
                if (p1 == null) {
                    p1 = pHead2;
                }
                if (p2 == null) {
                    p2 = pHead1;
                }
            }

        }

        return p1;
    }

}
