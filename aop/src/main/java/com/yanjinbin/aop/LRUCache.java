package com.yanjinbin.aop;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    class Node {

        Node pre;

        Node next;

        Integer key;

        Integer value;

        Node(Integer k, Integer v) {
            this.key = k;
            this.value = v;
        }
    }

    Map<Integer, Node> map = new HashMap<>();

    Node head;

    Node tail;

    Integer cap;

    public LRUCache(int capacity) {
        cap = capacity;
        head = new Node(null, null);
        tail = new Node(null, null);
        head.next = tail;
        tail.pre = head;
    }

    public int get(Integer key) {
        Node node = map.get(key);
        if (node != null) {
            node.pre.next = node.next;
            node.next.pre = node.pre;
            appendTail(node);
            return node.value;
        }
        return -1;
    }

    public void set(Integer key, Integer value) {
        Node n = map.get(key);
        // existed
        if (n != null) {
            n.value = value;
            map.put(key, n);
            n.pre.next = n.next;
            n.next.pre = n.pre;
            appendTail(n);
            return;
        }
        // else {
        if (map.size() == cap) {
            Node tmp = head.next;
            head.next = head.next.next;
            head.next.pre = head;
            map.remove(tmp.key);
        }
        n = new Node(key, value);
        // youngest node append taill
        appendTail(n);
        map.put(key, n);

    }

    private void appendTail(Node node) {
        node.next = tail;
        node.pre = tail.pre;
        tail.pre.next = node;
        tail.pre = node;
    }
}
