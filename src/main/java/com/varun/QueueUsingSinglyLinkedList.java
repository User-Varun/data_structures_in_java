package com.varun;


class QueueNode<T>{

    T data;
    QueueNode<T> next;

    public QueueNode(T data){
        this.data = data;
        this.next = null;
    }
}

public class QueueUsingSinglyLinkedList<T> {

    QueueNode<T> head;
    QueueNode<T> tail;


    public QueueUsingSinglyLinkedList(){
        this.head = null;
        this.tail = null;
    }


    public void enqueue(T data){

        QueueNode<T> node = new QueueNode<>(data);

        if(head == null){
            // queue is empty
            head = node;
            tail = head;
        }
        // else insert on tail
        tail.next = node;
        tail = tail.next;
    }
    public void dequeue(){
      try{
        if(head == null){
            throw new Exception("Queue is empty, nothing to dequeue");
        }

        if(head.next == null){
            head = null;
            tail = null;
            return;
        }

        // otherwise 2 or more than 2 el
          head = head.next;

    }catch(Exception e){
          System.out.println(e.getMessage());
      }

}

    public T front(){
       if(head != null){
           return head.data;
       }
       return null;
    }

    public boolean isEmpty(){
         return head == null;
    }
}
