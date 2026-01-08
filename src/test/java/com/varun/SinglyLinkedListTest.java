package com.varun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class SinglyLinkedListTest {
    SinglyLinkedList<Integer> l1;
    SinglyLinkedList<String> l2;


    @BeforeEach
    public void setUp(){
        l1 = new SinglyLinkedList<>();
        l2 = new SinglyLinkedList<>();
    }

    @Test
    public void testInsertAtHead(){
        l1.insertAtHead(10);
        assertEquals(10 , l1.get(0));

        l1.insertAtHead(20);
        assertEquals(20 , l1.get(0));

        l1.insertAtHead(30);
        assertEquals(30 , l1.get(0));

        assertEquals(3 , l1.getSize());

        l2.insertAtHead("Varun");
        assertEquals("Varun" , l2.get(0));
        l2.insertAtHead("Manisha");
        assertEquals("Manisha" , l2.get(0));
    }

    @Test
    public void testInsertAtTail(){
        l1.insertAtTail(10);

        assertEquals(10 , l1.get(0));
        l1.insertAtTail(20);
        assertEquals(20 , l1.get(1));
        l1.insertAtTail(30);
        assertEquals(30 , l1.get(2));
    }

    @Test
    public void testGetThrowsExceptionOnInvalidIndex(){
        l1.insertAtHead(5);
        l1.insertAtTail(10);

        assertThrows(IndexOutOfBoundsException.class , () -> l1.get(50) );
    }

    @Test
    public void testInsertAtIndex(){
        l1.insertAtIndex(10 , 0);
        l1.insertAtIndex(20 , 1);
        l1.insertAtIndex(30 , 2);

        l1.insertAtIndex(50 , 1);

        l1.insertAtIndex(100 , l1.getSize());

        assertEquals(10 , l1.get(0));
        assertEquals(50 , l1.get(1));
        assertEquals(20 , l1.get(2));
        assertEquals(30 , l1.get(3));
        assertEquals(100 , l1.get(4));

    }

    @Test
    public void testDeleteAtIndex(){
        l1.insertAtTail(10);
        l1.insertAtTail(20);
        l1.insertAtTail(30);

        l1.deleteAtIndex(1);
        assertEquals(30 , l1.get(1));
        l1.deleteAtIndex(1);
        assertEquals(10 , l1.get(0));
        assertThrows(NullPointerException.class , () -> l1.get(1));
        l1.deleteAtIndex(0);
        assertThrows(NullPointerException.class , () -> l1.get(0));

        assertEquals(0 , l1.getSize());
    }
}
