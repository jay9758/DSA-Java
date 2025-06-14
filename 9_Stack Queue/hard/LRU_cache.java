//https://leetcode.com/problems/lru-cache/

import java.util.HashMap;
import java.util.Map;

class LRUCache{
    class Node{
        Node prev,next;
        int key,value;
        Node(int key,int value){
            this.key=key;
            this.value=value;
        }
    }
    Node head=new Node(0,0);
    Node tail=new Node(0,0);
    Map<Integer, Node> map=new HashMap<>();
    int capacity;

    public LRUCache(int capacity){
        this.capacity=capacity;
        head.next=tail;
        tail.prev=head;
    }
    public int get(int key){
        if (map.containsKey(key)) {
            Node node=map.get(key);
            delete(node);
            insertAfterHead(node);
            return node.value;
        }
        return -1;
    }
    public void put(int key,int value){
        if (map.containsKey(key)) {
            delete(map.get(key));
        }
        if (map.size()==capacity) {
            delete(tail.prev);
        }
        insertAfterHead(new Node(key, value));
    }
    public void delete(Node node){
        map.remove(node.key);
        node.prev.next=node.next;
        node.next.prev=node.prev;
    }
    public void insertAfterHead(Node node){
        map.put(node.key, node);
        node.next=head.next;
        node.next.prev=node;
        head.next=node;
        node.prev=head;
    }
}
public class LRU_cache {
    public static void main(String[] args) {
        LRUCache lruCache=new LRUCache(2);

        lruCache.put(1, 1);
        lruCache.put(2, 2);
        System.out.println(lruCache.get(1));
        lruCache.put(3, 3);
        System.out.println(lruCache.get(2));
        lruCache.put(4, 4);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
    }
}
