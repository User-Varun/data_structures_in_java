package com.varun;

public class DynamicArray {



    /*
        This is an int array implementation, later pushed to make a dynamic array

        note :- I'm shifting elements to preserve order. if order don't matter overwrite data using index;
         */
    private int size;
    private int[] arr;

    public DynamicArray(int capacity) {

        if (capacity < 0) {
            throw new IllegalArgumentException("Invalid capacity");
        }

        this.size = 0;
        this.arr = new int[capacity];
    }

    public void insertAtSpecificPos(int data, int pos) {

        // guard invalid positions or full array
        if (pos < 0 || pos > size) {
            throw new IndexOutOfBoundsException("Invalid Position");
        }

        // for now let's remain the array sized fixed, will add dynamic feature later;
        // edit : added the resize method;
        if (size >= arr.length) {
            resize();
        }

        for (int i = size - 1; i >= pos; i--) {
            arr[i + 1] = arr[i];
        }
        arr[pos] = data;
        size++;
    }

    public void deletionAtSpecificPos(int pos) {

        // guard invalid positions
        if (pos < 0 || pos >= size) {
            throw new IndexOutOfBoundsException("Invalid Position, nothing to delete");
        }

        for (int i = pos; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }
        arr[size - 1] = 0; // clear freed slot
        size--;
    }

    public void traverseArray() {
        // showing user only the logical size, not the actual size
        System.out.print("Array: [");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("]");
    }

    private void resize() {
        int[] newArr = new int[arr.length * 2];
        System.arraycopy(arr, 0, newArr, 0, size);
        arr = newArr;
    }

    public void getRealSize() {
        System.out.println("Real size: " + this.arr.length);
    }

    public int getSize() {
        return this.size;
    }

    public int getElByIndex(int index ){
        if(index < 0 || index >= this.size){
            throw new IndexOutOfBoundsException("Invalid Index");

        }
        return this.arr[index];
    }

}
