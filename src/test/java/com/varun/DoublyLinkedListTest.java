package com.varun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoublyLinkedListTest {
    DoublyLinkedList<Integer> l1;
    DoublyLinkedList<String> l2;
    DoublyLinkedList<Integer> list;
    // the parameter Index is 0 based ( Stats at 0) ;

    @BeforeEach
    public void setUp(){
        l1 = new DoublyLinkedList<>();
        l2 = new DoublyLinkedList<>();
        list = new DoublyLinkedList<>();
    }

    @Test
    public void testHead(){
        l1.insertAtHead(10);
        l2.insertAtHead("mani");

        assertEquals(10 , l1.get(0));
        assertEquals("mani" , l2.get(0));

        assertEquals(1 , l1.getSize());
        assertEquals(1 , l2.getSize());

        l1.deleteAtHead();
        l2.deleteAtHead();

        assertEquals(0 , l1.getSize());
        assertEquals(0 , l2.getSize());
    }

    @Test
    public void testTail(){

        l1.insertAtTail(50);
        l2.insertAtTail("varun");

        assertEquals(1 , l1.getSize());
        assertEquals(1 , l2.getSize());

        l1.deleteAtTail();
        l2.deleteAtTail();
        assertEquals(0 , l1.getSize());
        assertEquals(0 , l2.getSize());
    }

    @Test
    public void testResetHeadAndTail(){
        l1.insertAtHead(50);
        l1.insertAtHead(100);

        assertTrue(l1.isHead(100));
        assertTrue(l1.isTail(50));

        l1.deleteAtHead();
        l1.deleteAtTail();

        assertTrue(l1.isHeadNull());
        assertTrue(l1.isTailNull());

    }

    @Test
    public void testInsertAndDeletionAtMiddle(){

        l1.insertAtTail(10);
        l1.insertAtTail(20);
        l1.insertAtTail(30);
        l1.insertAtTail(40);
        l1.insertAtTail(50);

        // now delete 30
        l1.deleteAtIndex(2);
        assertEquals(40 , l1.get(2));

        // insert 30 back
        l1.insertAtIndex(2, 30);
        assertEquals(30 , l1.get(2));

    }


        // ---------- EMPTY LIST ----------

        @Test
        void emptyListShouldThrow() {
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
            assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtHead());
            assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtTail());
            assertEquals(0, list.getSize());
        }

        // ---------- SINGLE ELEMENT ----------

        @Test
        void singleElementInsertDelete() {
            list.insertAtHead(10);

            assertEquals(1, list.getSize());
            assertEquals(10, list.get(0));

            list.deleteAtHead();

            assertEquals(0, list.getSize());
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        }

        // ---------- HEAD & TAIL INSERT ----------

        @Test
        void sequentialHeadInsert() {
            list.insertAtHead(1);
            list.insertAtHead(2);
            list.insertAtHead(3);

            assertEquals(3, list.getSize());
            assertEquals(3, list.get(0));
            assertEquals(1, list.get(2));
        }

        @Test
        void sequentialTailInsert() {
            list.insertAtTail(1);
            list.insertAtTail(2);
            list.insertAtTail(3);

            assertEquals(3, list.getSize());
            assertEquals(1, list.get(0));
            assertEquals(3, list.get(2));
        }

        // ---------- MIDDLE INSERT & DELETE ----------

        @Test
        void middleInsertDelete() {
            list.insertAtTail(10);
            list.insertAtTail(20);
            list.insertAtTail(40);

            list.insertAtIndex(2, 30);
            assertEquals(30, list.get(2));

            list.deleteAtIndex(2);
            assertEquals(40, list.get(2));
            assertEquals(3, list.getSize());
        }

        // ---------- LINK INVARIANTS ----------

        @Test
        void forwardBackwardLinksRemainConsistent() {
            for (int i = 0; i < 10; i++) {
                list.insertAtTail(i);
            }

            assertTrue(list.validateForwardLinks());
            assertTrue(list.validateBackwardLinks());

            list.deleteAtIndex(5);

            assertTrue(list.validateForwardLinks());
            assertTrue(list.validateBackwardLinks());
        }

        // ---------- BOUNDARY ABUSE ----------

        @Test
        void invalidIndexShouldThrow() {
            list.insertAtTail(10);

            assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
            assertThrows(IndexOutOfBoundsException.class, () -> list.get(2));
            assertThrows(IndexOutOfBoundsException.class, () -> list.deleteAtIndex(5));
        }

        // ---------- STRESS TEST ----------

        @Test
        void stressTestMixedOperations() {
            for (int i = 0; i < 100; i++) {
                list.insertAtTail(i);
            }

            for (int i = 0; i < 50; i++) {
                list.deleteAtHead();
                list.deleteAtTail();
            }

            assertEquals(0, list.getSize());
            assertTrue(list.validateForwardLinks());
            assertTrue(list.validateBackwardLinks());


        }
}
