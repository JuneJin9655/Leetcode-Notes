package stack.leetcode146;

import stack.leetcode146.*;
import java.util.Map;
/*
Basically, the LRUCache works like this: with a fixed capacity, we need to always keep the most recently
used values in the cache. Whenever a new value is added, we first check if it already exists.
If it does, we update the value and move it to the head (the most recent spot). If it doesn’t exist,
we add it to the head and remove the least recently used value from the tail to stay within capacity.

For the data structure, we use three instance variables: the capacity, a Map to store int keys and
Node values, and a DoublyLinkedList called cache to manage the order.

* */
class LRUCache146 {
    private final int capacity;
    private final DoublyLinkedList cache;
    private final Map<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new DoublyLinkedList();
        this.map = new HashMap<>();

    }

    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        cache.moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            cache.moveToHead(node);
        }else{
            if(map.size() == capacity){
                Node tail = cache.removeTail();
                map.remove(tail.key);
            }
            Node newNode = new Node(key, value);
            cache.addToHead(newNode);
            map.put(key, newNode);
        }
    }
}
