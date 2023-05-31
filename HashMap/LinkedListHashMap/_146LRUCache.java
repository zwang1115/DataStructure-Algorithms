package HashMap.LinkedListHashMap;

import java.util.HashMap;


/**
 * LeetCode 146
 * Medium
 */
public class _146LRUCache {
        class Node {
            int key;
            int value;
            Node pre;
            Node next;

            public Node(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }

        private HashMap<Integer, Node> map;
        private int capacity;
        private Node head;
        private Node tail;

        public _146LRUCache(int capacity) {
            map = new HashMap<>();
            this.capacity = capacity;
            head = null;
            tail = null;
        }

        public int get(int key) {
            Node node = map.get(key);
            if (node == null) {
                return -1;
            }
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
            return node.value;
        }

        public void put(int key, int value) {
            Node node = map.get(key);
            if (node != null) {
                node.value = value;
                if (node != tail) {
                    if (node == head) {
                        head = head.next;
                    } else {
                        node.pre.next = node.next;
                        node.next.pre = node.pre;
                    }
                    tail.next = node;
                    node.pre = tail;
                    node.next = null;
                    tail = node;
                }
            } else {
                Node newNode = new Node(key, value);
                if (capacity == 0) {
                    Node temp = head;
                    head = head.next;
                    if (temp == tail) tail = null;
                    map.remove(temp.key);
                    capacity++;
                }
                if (head == null && tail == null) {
                    head = newNode;
                } else {
                    tail.next = newNode;
                    newNode.pre = tail;
                    newNode.next = null;
                }
                tail = newNode;
                map.put(key, newNode);
                capacity--;
            }
        }
    }

