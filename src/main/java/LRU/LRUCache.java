package LRU;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    Node head = new Node("#");
    Node tail = new Node("#");
    Map<String,Node> map = new HashMap<>();
    final int capacity;

    public LRUCache() {
        capacity = 100000;
        head.next = tail;
        tail.prev = head;
    }

    public void get(String key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            remove(node);
            insert(node);
            System.out.println("This string exists in Cache : "+node.key);
        }
        else
            System.out.println("This string does not exist in Cache : "+key);
    }

    public void put(String key){
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        if(map.size() == capacity){
            remove(tail.prev);
        }
        insert(new Node(key));
    }

    private void remove(Node node){
        map.remove(node.key);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(Node node){
        map.put(node.key,node);
        Node headNext = head.next;
        head.next = node;
        node.prev = head;
        headNext.prev = node;
        node.next = headNext;
    }

    class  Node{
        Node prev,next;
        String key;
        int value;
        public Node(String key) {
            this.key = key;
            this.value =-1;
        }
    }
}
