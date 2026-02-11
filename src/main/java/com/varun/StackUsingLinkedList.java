package com.varun;

class StackNode<T>{
    T data;
    StackNode<T> next;

    public StackNode(T data){
        this.data = data;
        this.next = null;
    }
}

public class StackUsingLinkedList<T>{
    StackNode<T> top;


    public StackUsingLinkedList(){
        this.top = null;

    }


    public void push(T data){

        StackNode<T> n = new StackNode<>(data);

        if(top == null){
            top = n;
            return;
        }
        // otherwise
        n.next = top;
        top = n;
    }
    public void pop(){
        if(top != null){
            StackNode<T> temp = top;
            top = temp.next;
            temp.next = null;
        }
    }
    public T peek(){
        if(top != null){
        return top.data;
    }
    return null;
    }
    public boolean isEmpty(){
        return top == null;
    }

}
