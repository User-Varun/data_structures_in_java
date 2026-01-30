package com.varun;

public class App {

    // Logical element count (not capacity)
    public static void main(String[] args) {
        System.out.println("Lets get Coding...");

        LRU_Cache<String> cache = new LRU_Cache<>(3);

        cache.put(1 , "one data");
        cache.put(2 , "two data");

        System.out.println(cache.get(2));
    }
}
