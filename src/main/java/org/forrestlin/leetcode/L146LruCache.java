package org.forrestlin.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
* lru缓存机制
* */
public class L146LruCache {

    public static void main(String[] args) {

        LRUCache cache = new LRUCache(19);
        cache.put(10, 13);
        cache.put(3, 17);
        cache.put(6, 11);
        cache.put(10, 5);
        cache.put(9, 10);
        cache.get(13);
        cache.put(2, 19);

        cache.get(2);
        cache.get(3);
        cache.put(5, 25);
        cache.get(8);
        cache.put(9, 22);
        cache.put(5, 5);
        cache.put(1, 30);
        cache.get(11);
        cache.put(9, 12);
        cache.get(7);
        cache.get(5);
        cache.get(8);
        cache.get(9);

        System.out.println(cache.get(1) + "" + cache.get(2));

    }

}

class Node {

    public int key, val;
    public Node next, prev;

    public Node(int k, int v) {
        this.key = k;
        this.val = v;
    }
}


/*
* 使用双向链表存储，才能在O（1）时间复杂度内put
* */
class LRUCache1 {

    // key -> Node(key, val)
    private HashMap<Integer, Node> map;
    // Node(k1, v1) <-> Node(k2, v2)...
    private DoubleList cache;
    // 最大容量
    private int cap;

    public LRUCache1(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        cache = new DoubleList();
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }
        int val = map.get(key).val;
        // 利用 put 方法把该数据提前
        put(key, val);
        return val;
    }

    public void put(int key, int val) {
        // 先把新节点 x 做出来
        Node x = new Node(key, val);

        if (map.containsKey(key)) {
            // 删除旧的节点，新的插到头部
            cache.remove(map.get(key));
            cache.addFirst(x);
            // 更新 map 中对应的数据
            map.put(key, x);
        } else {
            if (cap == cache.size()) {
                // 删除链表最后一个数据
                Node last = cache.removeLast();
                map.remove(last.key);
            }
            // 直接添加到头部
            cache.addFirst(x);
            map.put(key, x);
        }
    }
}


class DoubleList {

    private Node head, tail; // 头尾虚节点
    private int size; // 链表元素数

    public DoubleList() {
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    // 在链表头部添加节点 x
    public void addFirst(Node x) {
        x.next = head.next;
        x.prev = head;
        head.next.prev = x;
        head.next = x;
        size++;
    }

    // 删除链表中的 x 节点（x 一定存在）
    public void remove(Node x) {
        x.prev.next = x.next;
        x.next.prev = x.prev;
        size--;
    }

    // 删除链表中最后一个节点，并返回该节点
    public Node removeLast() {
        if (tail.prev == head) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    // 返回链表长度
    public int size() {
        return size;
    }
}


class LRUCache {

    int cap;
    private Map<Integer, Integer> maps;
    private List<Integer> capList;


    public LRUCache(int capacity) {
        cap = capacity;
        maps = new HashMap<>();
        capList = new LinkedList<Integer>();
    }

    public int get(int key) {

        Integer val = maps.get(key);
        if (val == null) {
            return -1;
        } else {
            capList.remove(Integer.valueOf(key));
            capList.add(0, key);
            return val;
        }

    }

    public void put(int key, int value) {

        if (capList.size() == cap) {
            if (maps.get(key) == null) {
                Integer removed = capList.remove(capList.size() - 1);
                maps.remove(removed);

            }
        }

        if (maps.get(key) != null) {
            capList.remove(Integer.valueOf(key));
            maps.remove(Integer.valueOf(key));
        }
        maps.put(key, value);
        capList.add(0, key);

    }
}