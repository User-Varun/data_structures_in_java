package com.varun;

import java.util.HashMap;

// Practice Implementation of the LRU Cache Data Structure
// data structures used :-
// 1.HashMap from java ( will implement my own HashMap later )
// 2.Doubly Linked List ( my homemade )

class LRU_Node<T>{

    LRU_Node<T> next;
    LRU_Node<T> prev;
    T data;
    int key;


    public LRU_Node(int key, T data){
        this.next = null;
        this.prev = null;
        this.data = data;
        this.key = key;
    }
}

public class LRU_Cache<T>{

    HashMap<Integer , LRU_Node<T>> map;

    private LRU_Node<T> head;
    private LRU_Node<T> tail;
    final int capacity;
    int nodeCount;

    // Step-0
    public LRU_Cache(int capacity){
        map  = new HashMap<>();
        this.capacity = capacity;
        this.nodeCount = 0;
    }

    // step-1
    public void put(int key , T data){

        LRU_Node<T> node = new LRU_Node<>(key, data);

        if(nodeCount < capacity){
        map.put(key , node);
        nodeCount++;
        return;
        }

        if(nodeCount == capacity){
            // delete last el + insert the el at front
            removeTail();
            addToHead(head , node);

        }

    }
    public T get(int key){

        LRU_Node<T> res = map.get(key);

        return res.data;
    }


    // Helper Methods;
    private void addToHead(LRU_Node<T> head , LRU_Node<T> n){

        // condition 1 :- head is empty
        if(head == null){
            head  = n;
            tail = head;
            return;
        }
        // condition 2 :- head.next == empty
        if(head.next == null){
            n.next = head;
            tail.prev = n;
            head = n;
            return;
        }

        // condition 3 :- there are more than 2 elements
        n.next = head;
        head = n;

    }
    private void moveToHead(){}
    private void removeNode(){}
    private void removeTail(){}

}
