//https://leetcode.com/problems/lfu-cache/

import java.util.HashMap;

class LFUCache{
    int capacity;
    int curSize;
    int minFrequency;
    HashMap<Integer, Node> cacheMap;
    HashMap<Integer, DoublyLinkedList> freqMap;

    public LFUCache(int capacity){
        this.capacity=capacity;
        this.curSize=0;
        this.minFrequency=0;
        this.freqMap=new HashMap<>();
        this.cacheMap=new HashMap<>();
    }
    public int get(int key){
        if (!cacheMap.containsKey(key)) {
            return -1;
        }
        Node node=cacheMap.get(key);
        updateNode(node);
        return node.value;
    }
    public void put(int key,int value){
        if (capacity==0) {
            return;
        }
        if (cacheMap.containsKey(key)) {
            Node node=cacheMap.get(key);
            node.value=value;
            updateNode(node);
        }
        else{
            curSize++;
            if (curSize>capacity) {
                DoublyLinkedList minFreqList= freqMap.get(minFrequency);
                Node nodeToRemove= minFreqList.tail.prev;
                cacheMap.remove(nodeToRemove.key);
                minFreqList.removeNode(nodeToRemove);
                curSize--;
            }
            minFrequency=1;
            Node newNode=new Node(key, value);
            DoublyLinkedList curList= freqMap.getOrDefault(minFrequency,new DoublyLinkedList());
            curList.insertAfterHead(newNode);
            freqMap.put(minFrequency,curList);
            cacheMap.put(key, newNode);
        }
    }
    public void updateNode(Node node){
        int curFreq=node.frequency;
        DoublyLinkedList curList=freqMap.get(curFreq);
        curList.removeNode(node);
        if (curFreq==minFrequency && curList.listSize==0) {
            minFrequency++;
        }
        node.frequency++;
        DoublyLinkedList newList= freqMap.getOrDefault(node.frequency, new DoublyLinkedList());
        newList.insertAfterHead(node);
        freqMap.put(node.frequency, newList);
    }

    class DoublyLinkedList{
        Node head;
        Node tail;
        int listSize;

        DoublyLinkedList(){
            this.listSize=0;
            this.head=new Node(-1,-1);
            this.tail=new Node(-1,-1);
            head.next=tail;
            tail.prev=head;
        }
        public void removeNode(Node node){
            Node prevNode=node.prev;
            Node nexNode=node.next;
            prevNode.next=nexNode;
            nexNode.prev=prevNode;
            listSize--;
        }
        public void insertAfterHead(Node node){
            Node nextNode=head.next;
            node.next=nextNode;
            nextNode.prev=node;
            head.next=node;
            node.prev=head;
            listSize++;
        }
    }
    class Node{
        int key;
        int value;
        int frequency;
        Node next;
        Node prev;

        Node(int key,int value) {
            this.key=key;
            this.value=value;
            this.frequency=1;
            this.next=null;
            this.prev=null;
        }
    }
}

public class LFU_cache {
    public static void main(String[] args) {
        LFUCache lfuCache=new LFUCache(2);

        lfuCache.put(1,10);
        lfuCache.put(2,20);
        System.out.println(lfuCache.get(1));
        lfuCache.put(3,30);
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        lfuCache.put(4,40);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
    }
}
