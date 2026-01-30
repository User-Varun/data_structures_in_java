package com.varun;

class Node<T>{
    public T data;
    public Node<T> next;


    public Node(T data){
        this.data = data;
        this.next = null;
    }
}

public class SinglyLinkedList<T>{
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public SinglyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public void insertAtHead(T data){

        Node<T> n = new Node<>(data);

        if(head != null){
            // insert before next;
            n.next = head;
            head = n;
        }else{
           head = n;
           tail = head;
        }
        size++;

    }

    public void insertAtTail(T data){
        Node<T> n = new Node<>(data);

        if(head == null && tail == null){
            head = n;
            tail = head;
        }
        else{

            /*
            // Old Way

            // traverse till the end node of the list
            Node<T> temp = next;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = n;
            */

            // this made insertion O(1) ( coz tail is stored )
            tail.next = n;
            tail = tail.next;
        }
        size++;
    }

    public void insertAtIndex(T data, int index){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        if(index == 0){
            insertAtHead(data);
            return;
        }

        if(index == size - 1){
            insertAtTail(data);
            return;
        }

        Node<T> n = new Node<>(data);
        Node<T> temp = head;

        // traverse till index - 1
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        n.next = temp.next;
        temp.next = n;
        size++;


    }

    public void deleteAtIndex(int index){

        if(index < 0 || index > size){
            throw new IndexOutOfBoundsException("Invalid index");
        }

        // first
        if(index == 0){
            if(head == null){
                throw new NullPointerException("next is empty");
            }

            if(head.next == null){
                head = null;
                tail = null;
            }else{
                head = head.next;
            }
            size--;
            return;
        }
        // last
        if(index == size - 1){
            // There's no way to go back to prev node, so this remains O(n)

            Node<T> temp = head;
           // traverse till index - 1;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            temp.next = null;
            tail = temp;

            size--;
            return;
        }


        Node<T> temp = head;
        // Base Case
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public T get(int index){

        if(index > size || index < 0){
            throw new IndexOutOfBoundsException("Invalid Index");
        }

        if(head == null){
            throw new NullPointerException("next is null");
        }


        if(index == 0){
            return head.data;
        }
        else if(index == 1){
            return head.next.data;
        }
        else if(index ==  size - 1){
            return tail.data;
        }

        // base case
        Node<T> temp = head;

        for(int i = 0; i < index; i++){
            temp = temp.next;
        }

        return temp.data;
    }

}

