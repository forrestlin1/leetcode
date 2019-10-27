package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/*
 * 相交链表
 * */
public class L160IntersectionOfTwoLinkedLists {

    /*
     *HashMap法
     * 先遍历A，把A所有节点都存到map
     * 然后遍历B，判断是否有节点等于A中的节点
     * */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        Map<ListNode, Integer> helpMap = new HashMap<>();
        while (headA != null) {
            helpMap.put(headA, 1);
            headA = headA.next;
        }
        while (headB != null) {
            Integer cnt = helpMap.get(headB);
            if (cnt != null) {
                return headB;
            }
            headB = headB.next;


        }

        return null;

    }

    /***
     *
     * 先求出A和B的长度，得出他们的长度差，然后使用两个指针同时从离节点一样长的地方开始往前走，判断是否相等，相等即是交叉点
     * <p>
     * 1->2->3->4->5 2->3->4->5
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = 1;
        int lenB = 1;
        //保存住头节点
        ListNode curA = headA;
        ListNode curB = headB;
        while (curA.next != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB.next != null) {
            lenB++;
            curB = curB.next;
        }

        //如果相交，最后一个节点肯定是一样的
        if (curA != curB) {
            return null;
        }
        curA = headA;
        curB = headB;
        //A比B长，A要先走几步才能达到相同起点（距离相交点的距离相同）
        int difLen = Math.abs(lenA - lenB);
        if (lenA > lenB) {
            while (difLen > 0) {
                curA = curA.next;
                difLen--;
            }
        }
        if (lenB > lenA) {
            while (difLen > 0) {
                curB = curB.next;
                difLen--;
            }
        }

        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }

        return null;

    }
}
