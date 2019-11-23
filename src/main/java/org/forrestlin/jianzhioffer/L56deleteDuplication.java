package org.forrestlin.jianzhioffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @program: leetcode
 * @description: 删除链表中重复的节点
 * @author: forrestlin
 * @create: 2019-11-20 17:03
 */
public class L56deleteDuplication {

    public static void main(String[] args) {
        L56deleteDuplication test = new L56deleteDuplication();
        ListNode h = new ListNode(1);
        h.next = new ListNode(1);
        h.next.next = new ListNode(1);
        System.out.println(test.deleteDuplication(h));
        System.out.println(test.deleteDuplication(h));
    }

    public ListNode deleteDuplication1(ListNode pHead) {

        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        // 自己构建辅助头结点
        ListNode head = new ListNode(Integer.MIN_VALUE);
        head.next = pHead;
        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null) {
            if (cur.next != null && cur.next.val == cur.val) {
                // 相同结点一直前进
                while (cur.next != null && cur.next.val == cur.val) {
                    cur = cur.next;
                }
                // 退出循环时，cur 指向重复值，也需要删除，而 cur.next 指向第一个不重复的值
                // cur 继续前进
                cur = cur.next;
                // pre 连接新结点
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return head.next;
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (null == pHead || null == pHead.next) {
            return pHead;
        }
        //先记录有重复的，再删
        Set<Integer> ds = new HashSet<>();
        ListNode h = pHead;
        while (h != null && h.next != null) {
            if (h.val == h.next.val) {
                ds.add(h.val);
                h = h.next;
            }
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = pHead;
        ListNode cur = pHead;
        ListNode ahead = dummy;
        while (cur != null) {
            if (ds.contains(cur.val)) {
                if (cur.next != null) {
                    ahead.next = ahead.next.next;
                    cur = cur.next;
                } else {
                    ahead.next = null;
                    cur = null;
                }
            } else {

                ahead = cur;
                cur = cur.next;
            }

        }

        return dummy.next;
    }
}
