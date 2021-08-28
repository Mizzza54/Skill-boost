package task146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {
    private final Map<Integer, Node> map;
    private final int capacity;
    private int size;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.map = new HashMap<>(capacity);
        this.capacity = capacity;
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            updateNode(map.get(key));
            return map.get(key).getValue();
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.setValue(value);
            updateNode(node);
        } else {
            Node node = new Node(key, value);
            if (size == 0) {
                size++;
                head = tail = node;
            } else if (size < capacity) {
                size++;
                node.setNext(head);
                head.setPrev(node);
                head = node;
            } else {
                node.setNext(head);
                head.setPrev(node);
                head = node;
                map.remove(tail.getKey());
                tail = tail.getPrev();
                tail.setNext(null);
            }
            map.put(key, node);
        }
    }

    private void updateNode(Node node) {
        if (node.getPrev() == null) {
            return;
        }
        node.getPrev().setNext(node.getNext());
        if (node.getNext() == null) {
            tail = node.getPrev();
            tail.setNext(null);
        } else {
            node.getNext().setPrev(node.getPrev());
        }
        node.setPrev(null);
        node.setNext(head);
        head.setPrev(node);
        head = node;
    }
}

class Node {
    private final int key;
    private int value;
    private Node next;
    private Node prev;

    public Node(final int key, final int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }
}

/**
 * Your task146.LRUCache object will be instantiated and called as such:
 * task146.LRUCache obj = new task146.LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */