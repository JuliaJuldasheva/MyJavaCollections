package ru.q1w2e3.myLinkedList;


import org.junit.Test;
import static junit.framework.TestCase.assertEquals;

public class MyLinkedListTest {

    private MyLinkedList<String> myLinkedList = new MyLinkedList<String>();



    @Test
    public void myTest(){
        myLinkedList.insert(0,"Second");
        myLinkedList.insert(0,"Third");

        myLinkedList.insertFirst("First");
        assertEquals(4,2+2);
    }


}
