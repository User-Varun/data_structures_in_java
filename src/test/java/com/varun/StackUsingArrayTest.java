package com.varun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackUsingArrayTest {

    StackUsingArray<Integer> s1;

    @BeforeEach
    public void setUp(){
        s1 = new StackUsingArray<>();
    }


    @Test
    public void testPushPop(){

        s1.push(10);
        assertEquals(10 , s1.peek());
        s1.push(20);
        assertEquals(20 , s1.peek());
        s1.push(30);
        assertEquals(30 , s1.peek());

        s1.pop();
        assertEquals(20 , s1.peek());
        s1.pop();
        assertEquals(10 , s1.peek());
        s1.pop();
        assertEquals(-1 , s1.getTop());

        assertTrue(s1.isEmpty());
}}
