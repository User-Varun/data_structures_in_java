package com.varun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StackUsingLinkedListTest {
    StackUsingLinkedList<String> s1;


    @BeforeEach
    public void setUp(){
        s1 = new StackUsingLinkedList<>();
    }


    @Test
    public void pushPopTest(){
        s1.push("varun");
        assertEquals("varun" , s1.peek());
        s1.push("mani");
        assertEquals("mani" , s1.peek());
        s1.push("manisha");
        assertEquals("manisha" , s1.peek());

        s1.pop();
        assertEquals("mani" , s1.peek());
        s1.pop();
        assertEquals("varun" , s1.peek());
        s1.pop();
        assertTrue(s1.isEmpty());


    }
}
