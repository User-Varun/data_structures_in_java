package com.varun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class QueueUsingSinglyLinkedListTest {
    QueueUsingSinglyLinkedList<String> q1;

    @BeforeEach
    public void setUp(){
        q1 = new QueueUsingSinglyLinkedList<>();
    }


    @Test
    public void testEnqueueAndDequeue(){
        q1.enqueue("varun");
        assertEquals("varun" , q1.front());
        q1.enqueue("manisha");
        assertEquals("varun" , q1.front());
        q1.enqueue("our baby");
        assertEquals("varun" , q1.front());


        q1.dequeue();
        assertEquals("manisha" , q1.front());
        q1.dequeue();
        assertEquals("our baby" , q1.front());
        q1.dequeue();
        assertNull(q1.front());

        assertTrue(q1.isEmpty());


    }


}
