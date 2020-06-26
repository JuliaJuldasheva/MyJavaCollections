package ru.q1w2e3.myLinkedList;

public class MainApp {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        myLinkedList.insertFirst("First");
        myLinkedList.insertFirst("Second");
        myLinkedList.insertFirst("Third");
        //myLinkedList.insertFirst(null);

        MyLinkedList<Integer> mll = new MyLinkedList<Integer>();
        mll.insert(0,1);
        mll.insert(1,2);
        System.out.println(mll.toString());

       // mll.insert(2,null);

        System.out.println(myLinkedList);
        System.out.println(myLinkedList.getSize());

        System.out.println(myLinkedList.indexOf("Second"));
        System.out.println(myLinkedList.indexOf("Four"));

        System.out.println(myLinkedList.contains("First"));
        System.out.println(myLinkedList.contains("Four"));

        System.out.println(myLinkedList.isEmpty());

        System.out.println(myLinkedList.getFirst());
        System.out.println(myLinkedList.getLast());

        System.out.println(myLinkedList.getElementByIndex(1));

        System.out.println("1 " + myLinkedList.clone());

//        myLinkedList.setLast(null);
       // myLinkedList.setFirst(null);
        myLinkedList.insertFirst("3");
        myLinkedList.insertLast("5");
        myLinkedList.insert(0,"null");
        System.out.println(myLinkedList);

//        System.out.println(myLinkedList.getElementByIndex(1));
        System.out.println(myLinkedList.getElementByIndex(3));

        myLinkedList.insert(1,"10");
        System.out.println(myLinkedList);
    }
}

