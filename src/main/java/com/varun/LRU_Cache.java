package com.varun;

import java.util.HashMap;

// Practice Implementation of the LRU Cache Data Structure
// data structures used :-
// 1.HashMap from java ( will implement my own HashMap later )
// 2.Doubly Linked List ( my homemade )

class LRU_Node<K, V>{

    LRU_Node<K, V> next;
    LRU_Node<K, V> prev;
    V data;
    K key;


    public LRU_Node(K key , V data ){
        this.next = null;
        this.prev = null;
        this.data = data;
        this.key = key;
    }
}

public class LRU_Cache<K , V>{

    HashMap<K , LRU_Node<K , V>> map;

    private LRU_Node<K, V> head;
    private LRU_Node<K, V> tail;
    final int capacity;
    int nodeCount;

    // Step-0
    public LRU_Cache(int capacity){
        map  = new HashMap<>();
        this.capacity = capacity;
        this.nodeCount = 0;
    }

    // step-1
    public void put(K key , V data){

        LRU_Node<K, V> node = new LRU_Node<>(key , data);


        if(map.containsKey(key)){
            LRU_Node<K , V> existingNode = map.get(key);
            existingNode.data = data;
           addToHead(node);
           return;
        }


        if(nodeCount < capacity){
        map.put(key , node);
        addToHead(node);
        nodeCount++;
        System.out.println("put success!");
        return;
        }

        if(nodeCount == capacity){
            // remove the tail node ( slide the tail pointer and remove connections from last node, garbage collection will delete the node)
            removeTail();
            nodeCount--;

            // add the new object to the head;
            map.put(key , node);
            addToHead(node);
            nodeCount++;
        }

    }
    public V get(K key){

        LRU_Node<K , V> node = map.get(key);

        // means cache miss
        if (node == null) {
            return null;
        }
        moveToHead(node);
        return node.data;
    }


    // Helper Methods;
    private void addToHead(LRU_Node<K, V> n){

        // condition 1 :- head is empty
        if(head == null){
            head  = n;
            tail = head;

        }else{
            n.next = head;
            head.prev = n;
            head = n;
        }

    }
    private void removeTail(){
          if(head == tail){
              // there's only one element
              map.remove(tail.key);
              head = null;
              tail = null;

          }else{
              LRU_Node<K , V> temp = tail;
              map.remove(tail.key);
              tail = tail.prev;
              tail.next = null;
          }

    }
    private void moveToHead(LRU_Node<K , V> node){

        if(node == head){
            return;
        }
        removeNode(node);
        addToHead(node);
    }
    private void removeNode(LRU_Node<K , V> node){

        // base case
        if(node == head){
            head = head.next;
            head.prev.next = null;
            head.prev = null;
            return;
        }
        if(node == tail){
            removeTail();
            return;
        }
        // here there will be atleast 3 nodes or more ( so rewriting pointers)
        node.prev.next  = node.next;
        node.next.prev = node.prev;
    }
}
