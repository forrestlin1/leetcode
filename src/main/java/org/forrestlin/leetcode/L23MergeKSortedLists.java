package org.forrestlin.leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: leetcode
 * @description: 合并k个有序列表
 * @author: forrestlin
 * @create: 2019-09-27 10:34
 */
public class L23MergeKSortedLists {

    public static void main(String[] args) {
        L23MergeKSortedLists tet = new L23MergeKSortedLists();
        ListNode[] in = new ListNode[2];
        in[0] = null;
        in[1] = new ListNode(1);
        tet.mergeKLists2(in);
    }

    /**
     * 同时合并法
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode res = pre;
        downInto(pre, lists);
        return res.next;

    }

    public void downInto(ListNode pre, ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return;
        }
        if (lists[0] != null) {
            int minIndex = 0;
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null && lists[minIndex].val > lists[i].val) {
                    minIndex = i;
                }

            }
            pre.next = lists[minIndex];
            lists[minIndex] = lists[minIndex].next;
            pre = pre.next;
        }
        List<ListNode> nodeList = new ArrayList<>();

        for (ListNode node : lists) {
            if (node != null) {

                nodeList.add(node);
            }
        }

        downInto(pre, nodeList.toArray(new ListNode[nodeList.size()]));


    }


    /**
     * 两两合并法
     */
    public ListNode mergeKLists2(ListNode[] lists) {

        if (lists == null || lists.length == 0) {
            return null;
        }

        ListNode pre = new ListNode(Integer.MIN_VALUE);
        ListNode head = pre;

        for (int i = 0; i < lists.length; i++) {

            if (lists[i] != null) {
                pre = mergeTwoList(pre, lists[i]);
            }

        }

        return head.next;

    }

    public ListNode mergeTwoList(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(Integer.MIN_VALUE);
        ListNode head = dummyNode;

        while (l1 != null || l2 != null) {

            if (l1 == null) {
                dummyNode.next = l2;
                return head.next;
            }

            if (l2 == null) {
                dummyNode.next = l1;
                return head.next;
            }

            if (l1.val < l2.val) {
                dummyNode.next = l1;
                l1 = l1.next;
            } else {

                dummyNode.next = l2;
                l2 = l2.next;

            }

            dummyNode = dummyNode.next;


        }
        return head.next;


    }

    /**
     * 方法3 使用优先队列
     * */
    public ListNode mergeKLists3(ListNode[] lists) {
        PriorityQueue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.val));
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        queue.addAll(Stream.of(lists).filter(Objects::nonNull).collect(Collectors.toList()));
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            p.next = node;
            p = p.next;
            if (node.next != null) {
                queue.add(node.next);
            }
        }
        return dummy.next;
    }


}
