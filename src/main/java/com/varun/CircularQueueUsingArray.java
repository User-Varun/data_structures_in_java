package com.varun;

public class CircularQueueUsingArray {
    int front;
    int rear;
    int capacity;
    int size;
    String[] arr;

    public CircularQueueUsingArray(int capacity) {
        this.front = 0;
        this.rear = -1;
        this.capacity = capacity;
        this.size = 0;
        this.arr = new String[capacity];
    }


    public void enqueue(String data) {


        if (arr[front] == null) {
            arr[front] = data;
            size++;
            return;
        }

        try {
            if (size > capacity) {
                throw new Exception("Queue Full");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        if (size < capacity) {
            arr[size] = data;
            size++;
        }

    }

    public void dequeue(){

        try {
            if (arr[front] == null) {
             throw new Exception("Que is Empty");
            }

            arr[front] = null;
            // when front is deleting the last element the pointers should be reset.
            front = (front + 1) % capacity;
            rear = (rear + 1) & capacity;
            size--;

        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }

    public boolean isEmpty(){
        return arr[front] == null;
    }

    public String front(){
        if (arr[front] != null) {
            return arr[front];
        }
        return null;
    }
}