package com.varun;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CircularQueueUsingArrayTest {
    CircularQueueUsingArray q1;

    @BeforeEach
    public void setUp(){
        q1 = new CircularQueueUsingArray(3);
    }


    @Test
    public void enqueueDequeTest(){
        q1.enqueue("manisha");
        assertEquals("manisha" , q1.front());
        q1.enqueue("varun");
        assertEquals("manisha" , q1.front());
        q1.enqueue("my wife");
        assertEquals("manisha" , q1.front());


        q1.dequeue();
        assertEquals("varun" , q1.front());

        q1.dequeue();
        assertEquals("my wife" , q1.front());

        q1.dequeue();
        assertNull(q1.front());


        assertTrue(q1.isEmpty());

        q1.enqueue("manisha");
        assertEquals("manisha" , q1.front());
        q1.enqueue("varun");
        assertEquals("manisha" , q1.front());

        q1.dequeue();
        assertEquals("varun" , q1.front());

        q1.dequeue();
        assertNull(q1.front());



    }
}
