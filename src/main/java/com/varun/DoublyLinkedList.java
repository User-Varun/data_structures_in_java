package com.varun;

class DNode<T>{
    public T data;
    public DNode<T> next;
    public DNode<T> prev;

    public DNode(T data){
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DoublyLinkedList<T>{

     private DNode<T> head;
     private DNode<T> tail;
     int size;

    // the parameter Index is 0 based ( Stats at 0) ;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize(){
        return size;
    }

    public void insertAtHead(T data){

        DNode<T> n = new DNode<>(data);

        if(head == null){
            head = n;
            tail = head;

        }else{
            n.next = head;
            head.prev = n;
            head = n;
        }
        size++;


    }

    public void insertAtTail(T data){
        DNode<T> n = new DNode<>(data);

        if(head == null){
            head = n;
            tail = head;
            size++;
            return;
        }
        if(tail == head){
            tail = n;
            tail.prev = head;
            head.next = n;
            size++;
            return;
        }

        // insert at tail
        tail.next = n;
        tail.next.prev = tail;
        tail = tail.next;
        size++;
    }

    public void insertAtIndex(int index , T data){

        if(index < 0 || index > size || head == null){
            throw new IndexOutOfBoundsException("Invalid Index or list is empty");
        }

        if(index == 0){
            insertAtHead(data);
            return;
        }

//        if(index == size - 1 ){
//            insertAtTail(data);
//            return;
//        }

        DNode<T> n = new DNode<>(data);

        // traverse till index - 1;
        DNode<T> temp = head;
        for(int i = 0; i < index - 1; i++){
            temp = temp.next;
        }

        n.next = temp.next;
        temp.next = n;
        n.prev = temp;
        size++;
    }


    public void deleteAtHead(){
        if(head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }

        // multiple el , move next node
        head = head.next;
        head.prev = null;
        size--;
    }

    public void deleteAtTail(){
        if(head == null){
            throw new IndexOutOfBoundsException("List is empty");
        }

        if(head == tail){
            head = null;
            tail = null;
            size--;
            return;
        }

        // multiple el, delete move tail pointer
        tail = tail.prev; // this is where DLL shines;
        tail.next = null;
        size--;
    }

    public void deleteAtIndex(int index){

        if(index < 0 || index > size || head == null){
            throw new IndexOutOfBoundsException("Invalid index or list is empty");
        }

        if(index == 0){
            deleteAtHead();
            return;
        }

//        if(index ==  size - 1){
//            deleteAtTail();
//            return;
//        }

        // using next for all
        // traverse till index
        DNode<T> temp2 = head;
//        for(int i= 0; i < size; i++){
//            System.out.println(temp2.data);
//            temp2 = temp2.next;
//        }

        DNode<T> temp = head;
        for(int i =0; i < index; i++){
            temp = temp.next;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        size--;
    }

    public T get(int index){
        if(index < 0 || index > size || head == null){
            throw new IndexOutOfBoundsException("Invalid index or list is empty");
        }

        if(index == 0){
            return head.data;
        }

        if(index == size - 1){
            return tail.data;
        }

         /*
         the efficient logic would be to choose the pointer(tail or next ) that closest to the index, but since
         I couldn't figure out any logic, other than traversing from both pointer and finding the shortest length
         ( but that would be not efficient solution I think, but I don't know.)
         */

        // choosing next by for all;
        DNode<T> temp  = head;

        for(int i =0; i < index; i++){
            temp = temp.next;
        }
        return temp.data;

    }






    // for running test cases only
    public boolean isHead(T data){
        return head.data == data;
    }
    public boolean isTail(T data){
        return tail.data == data;
    }
    public boolean isHeadNull(){
        return head == null;
    }
    public boolean isTailNull(){
        return tail == null;
    }

    boolean validateForwardLinks() {
        DNode<T> curr = head;
        DNode<T> prev = null;

        while (curr != null) {
            if (curr.prev != prev) return false;
            prev = curr;
            curr = curr.next;
        }
        return prev == tail;
    }

    boolean validateBackwardLinks() {
        DNode<T> curr = tail;
        DNode<T> next = null;

        while (curr != null) {
            if (curr.next != next) return false;
            next = curr;
            curr = curr.prev;
        }
        return next == head;
    }


}
