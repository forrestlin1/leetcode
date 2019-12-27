package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @program: leetcode
 * @description: 复制带随机指针的链表
 * @author: forrestlin
 * @create: 2019-12-26 11:32
 */
public class L138copyListWithRandomPointer {

    public Map<Node, Node> visited = new HashMap<>();

    /**
     * 字典法，使用map建立新老节点的映射关系
     * */
    public Node copyRandomList(Node head) {

        Node cloneHead = getCloneNode(head);

        while (head != null) {
            Node clone = getCloneNode(head);
            Node cloneNext = getCloneNode(head.next);
            Node cloneRandom = getCloneNode(head.random);
            clone.next = cloneNext;
            clone.random = cloneRandom;

            head = head.next;
        }

        return cloneHead;

    }

    public Node getCloneNode(Node node) {

        if (null == node) {
            return null;
        }
        Node cloneNode = visited.get(node);
        if (null == cloneNode) {
            cloneNode = new Node(node.val);
             visited.put(node, cloneNode);
            return cloneNode;
        } else {
            return cloneNode;
        }
    }


    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

}
