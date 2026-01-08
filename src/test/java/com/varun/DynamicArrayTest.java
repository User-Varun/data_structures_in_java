package com.varun;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DynamicArrayTest {
    private DynamicArray a;
    private DynamicArray a1;

    @BeforeEach
    public void setUp(){
        a = new DynamicArray(4);
        a1 = new DynamicArray(5);
    }

    @Test
    public void testInitialSize(){
        assertEquals(0 , a.getSize());
    }

    @Test
    public void testInsertIncreasesSize(){
        // initial size
        assertEquals(0 , a.getSize());

       // Size after insert
        a.insertAtSpecificPos(10 , 0);
        assertEquals(1 , a.getSize());
        a.insertAtSpecificPos(20,1);
        assertEquals(2 , a.getSize());

    }

    @Test
    public void testInsertion(){
        a1.insertAtSpecificPos(70, 0);
        a1.insertAtSpecificPos(71, 1);
        a1.insertAtSpecificPos(72, 2);


        // verify size and contents after inserts
        assertEquals(3, a1.getSize());

        assertEquals(70, a1.getElByIndex(0));
        assertEquals(71, a1.getElByIndex(1));
        assertEquals(72, a1.getElByIndex(2));


    }

    @Test
    public void testDeletion(){

        a1.insertAtSpecificPos(70, 0);
        a1.insertAtSpecificPos(71, 1);
        a1.insertAtSpecificPos(72, 2);
        a1.insertAtSpecificPos(73, 3);
        a1.insertAtSpecificPos(74, 4);

        // verify size before and after deletion;
        assertEquals(5 , a1.getSize());

        a1.deletionAtSpecificPos(2);
        a1.deletionAtSpecificPos(3);

        assertEquals(3 , a1.getSize());

        // verifying deletion works
        assertEquals(70 , a1.getElByIndex(0));
        assertEquals(71 , a1.getElByIndex(1));
        assertEquals(73 , a1.getElByIndex(2));
    }
}
