package org.forrestlin.jianzhioffer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/*
 * 从头到尾打印链表
 * */
public class L3printListFromTailToHead {

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {

        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> help = new Stack<>();
        while (listNode != null) {
            help.push(listNode.val);
            listNode = listNode.next;
        }

        while (!help.isEmpty()) {
            res.add(help.pop());
        }
        return res;

    }
}
