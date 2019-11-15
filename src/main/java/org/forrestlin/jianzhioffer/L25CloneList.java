package org.forrestlin.jianzhioffer;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 复杂链表的复制
 * @author: forrestlin
 * @create: 2019-11-14 11:29
 */
public class L25CloneList {

    public RandomListNode Clone(RandomListNode pHead) {
        if (null == pHead) {
            return pHead;
        }

        Map<RandomListNode, RandomListNode> oldNew = new HashMap<>();

        RandomListNode toCopy = pHead;
        while (toCopy != null) {
            RandomListNode copy = new RandomListNode(toCopy.label);
            oldNew.put(toCopy, copy);
            toCopy = toCopy.next;
        }
        RandomListNode oriHead = pHead;

        while (pHead != null) {
            RandomListNode from = oldNew.get(pHead);
            if (pHead.next != null) {
                RandomListNode toNext = oldNew.get(pHead.next);
                from.next = toNext;
            }
            if (pHead.random != null) {
                RandomListNode toRandom = oldNew.get(pHead.random);
                from.random = toRandom;
            }
            pHead = pHead.next;
        }

        return oldNew.get(oriHead);

    }
}
