package com.varun;

import java.util.ArrayList;

public class StackUsingArray<T> {

    int top;
    ArrayList<T> arr;




    public StackUsingArray(){
        this.top = -1;
        this.arr = new ArrayList<>();
    }


    public void push(T data){
        arr.add(++top , data);
    }
    public void pop(){

        if(top != -1){
            arr.remove(top);
            top--;
        }

    }

    public T peek(){

               return arr.get(top);


    }
    public boolean isEmpty(){
        return top == -1;
    }
    int getTop(){
        return top;
    }

}
