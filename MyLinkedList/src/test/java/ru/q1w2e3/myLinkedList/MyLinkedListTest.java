package ru.q1w2e3.myLinkedList;


import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class MyLinkedListTest {

    private MyLinkedList<Integer> myLinkedList;

    @Before
    public void init() {
        myLinkedList = new MyLinkedList<Integer>();
    }


    @Test
    public void getSizeTest() {
        int expectedSize = 0;
        int actualSize = myLinkedList.getSize();

        assertEquals(expectedSize, actualSize);
    }


    @Test
    public void insertFirstTest() {
        myLinkedList.insertFirst(4);
        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(1);

        myLinkedList.insertFirst(0);

        int expectedSize = 5;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);

        int expectedValue = 0;
        int actualValue = myLinkedList.getFirst();
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void insertLastTest() {
        myLinkedList.insertFirst(8);
        myLinkedList.insertFirst(7);
        myLinkedList.insertFirst(6);
        myLinkedList.insertFirst(5);

        myLinkedList.insertLast(9);

        int expectedSize = 5;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);

        int expectedValue = 9;
        int actualValue = myLinkedList.getElementByIndex(myLinkedList.getSize() - 1);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void insertTest() {
        myLinkedList.insertFirst(14);
        myLinkedList.insertFirst(13);
        myLinkedList.insertFirst(12);
        myLinkedList.insertFirst(11);
        myLinkedList.insertFirst(10);

        myLinkedList.insert(3, 15);

        int expectedSize = 6;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);

        int expectedValue = 15;
        int actualValue = myLinkedList.getElementByIndex(3);
        assertEquals(expectedValue, actualValue);
    }

    @Test(expected = IllegalArgumentException.class)
    public void insertNegativeArgumentTest() {

        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(1);

        myLinkedList.insert(1, null);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void insertNegativeIndexTest() {

        myLinkedList.insertFirst(3);
        myLinkedList.insertFirst(2);
        myLinkedList.insertFirst(1);

        myLinkedList.insert(-1, 4);
    }

    @Test
    public void indexOfTest() {
        myLinkedList.insertFirst(19);
        myLinkedList.insertFirst(18);
        myLinkedList.insertFirst(17);
        myLinkedList.insertFirst(16);

        int expectedValue1 = 1;
        int actualValue1 = myLinkedList.indexOf(17);
        assertEquals(expectedValue1, actualValue1);

        int expectedValue2 = -1;
        int actualValue2 = myLinkedList.indexOf(20);
        assertEquals(expectedValue2, actualValue2);
    }

    @Test
    public void containsTest() {
        myLinkedList.insertFirst(24);
        myLinkedList.insertFirst(23);
        myLinkedList.insertFirst(22);
        myLinkedList.insertFirst(21);

        assertTrue( myLinkedList.contains(22));
        assertFalse(myLinkedList.contains(100));
    }

    @Test
    public void isEmptyTest() {
        myLinkedList.insertFirst(28);
        myLinkedList.insertFirst(27);
        myLinkedList.insertFirst(26);
        myLinkedList.insertFirst(25);

        assertFalse(myLinkedList.isEmpty());
        myLinkedList.clear();
        assertTrue(myLinkedList.isEmpty());
    }

    @Test
    public void getFirstTest() {
        myLinkedList.insertFirst(32);
        myLinkedList.insertFirst(31);
        myLinkedList.insertFirst(30);
        myLinkedList.insertFirst(29);

        int expectedValue1 = 29;
        int actualValue1 = myLinkedList.getFirst();
        assertEquals(expectedValue1, actualValue1);

        int expectedValue2 = 0;
        int actualValue2 = myLinkedList.indexOf(29);
        assertEquals(expectedValue2, actualValue2);
    }

    @Test
    public void getLastTest() {
        myLinkedList.insertFirst(36);
        myLinkedList.insertFirst(35);
        myLinkedList.insertFirst(34);
        myLinkedList.insertFirst(33);

        int expectedValue1 = 36;
        int actualValue1 = myLinkedList.getLast();
        assertEquals(expectedValue1, actualValue1);

        int expectedValue2 = 3;
        int actualValue2 = myLinkedList.indexOf(36);
        assertEquals(expectedValue2, actualValue2);
    }

    @Test
    public void getElementByIndexTest() {
        myLinkedList.insertFirst(40);
        myLinkedList.insertFirst(39);
        myLinkedList.insertFirst(38);
        myLinkedList.insertFirst(37);

        int expectedValue = 39;
        int actualValue = myLinkedList.getElementByIndex(2);
        assertEquals(expectedValue, actualValue);
    }

    @Test
    public void cloneTest() {
        myLinkedList.insertFirst(45);
        myLinkedList.insertFirst(44);
        myLinkedList.insertFirst(43);
        myLinkedList.insertFirst(42);
        myLinkedList.insertFirst(41);

        MyLinkedList<Integer> newList = myLinkedList.clone();

        int expectedSize = 5;
        int actualSize = newList.getSize();
        assertEquals(expectedSize, actualSize);

        for (int i = 0; i < myLinkedList.getSize(); i++) {
            int expectedValue = myLinkedList.getElementByIndex(i);
            int actualValue = newList.getElementByIndex(i);
            assertEquals(expectedValue, actualValue);
        }
    }

    @Test
    public void removeFirstTest() {
        myLinkedList.insertFirst(50);
        myLinkedList.insertFirst(49);
        myLinkedList.insertFirst(48);
        myLinkedList.insertFirst(47);
        myLinkedList.insertFirst(46);

        int expectedValue = myLinkedList.getElementByIndex(1);
        myLinkedList.removeFirst();
        int actualValue = myLinkedList.getFirst();
        assertEquals(expectedValue, actualValue);

        int expectedSize = 4;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeLastTest() {
        myLinkedList.insertFirst(55);
        myLinkedList.insertFirst(54);
        myLinkedList.insertFirst(53);
        myLinkedList.insertFirst(52);
        myLinkedList.insertFirst(51);

        int expectedValue = myLinkedList.getElementByIndex(myLinkedList.getSize() - 2);
        myLinkedList.removeLast();
        int actualValue = myLinkedList.getElementByIndex(myLinkedList.getSize() - 1);
        assertEquals(expectedValue, actualValue);

        int expectedSize = 4;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test
    public void removeByValueTest() {
        myLinkedList.insertFirst(60);
        myLinkedList.insertFirst(59);
        myLinkedList.insertFirst(58);
        myLinkedList.insertFirst(57);
        myLinkedList.insertFirst(56);

        myLinkedList.removeByValue(58);
        assertFalse(myLinkedList.contains(58));

        int expectedSize = 4;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeByValueEmptyListTest() {
        myLinkedList.removeByValue(58);
    }

    @Test
    public void removeByIndexTest() {
        myLinkedList.insertFirst(65);
        myLinkedList.insertFirst(64);
        myLinkedList.insertFirst(63);
        myLinkedList.insertFirst(62);
        myLinkedList.insertFirst(61);

        int index = 2;

        int expectedValue1 = myLinkedList.getElementByIndex(index + 1);
        myLinkedList.removeByIndex(index);
        int actualValue1 = myLinkedList.getElementByIndex(index);

        assertEquals(expectedValue1, actualValue1);
        assertFalse(myLinkedList.contains(63));

        int expectedSize = 4;
        int actualSize = myLinkedList.getSize();
        assertEquals(expectedSize, actualSize);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeByIndexEmptyListTest() {
        int index = 2;
        myLinkedList.removeByIndex(index);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeByInvalidIndexTest() {
        myLinkedList.insertFirst(70);
        myLinkedList.insertFirst(69);
        myLinkedList.insertFirst(68);
        myLinkedList.insertFirst(67);
        myLinkedList.insertFirst(66);

        int index = 10;
        myLinkedList.removeByIndex(index);
    }


    @Test
    public void clearTest() {
        myLinkedList.insertFirst(70);
        myLinkedList.insertFirst(69);
        myLinkedList.insertFirst(68);
        myLinkedList.insertFirst(67);
        myLinkedList.insertFirst(66);

        int expectedSize = 0;
        myLinkedList.clear();
        int actualSize = myLinkedList.getSize();

        assertEquals(expectedSize, actualSize);
    }
}
