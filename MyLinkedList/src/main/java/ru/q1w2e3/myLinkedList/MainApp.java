package ru.q1w2e3.myLinkedList;

public class MainApp {
    public static void main(String[] args) {
        MyLinkedList<String> myLinkedList = new MyLinkedList<String>();
        System.out.println(myLinkedList.isEmpty()); //true
        System.out.println(myLinkedList.getSize());
//        myLinkedList.clear();
//        System.out.println(myLinkedList.getLast());
//        System.out.println(myLinkedList.getFirst());

        myLinkedList.insert(0,"Third");
        myLinkedList.insertLast("Fourth");
        myLinkedList.insertFirst("Second");
        myLinkedList.insertFirst("First");

        System.out.println(myLinkedList.isEmpty()); //false
        System.out.println(myLinkedList.getSize()); //4
        System.out.println(myLinkedList); // [First, Second, Third, Fourth]

        System.out.println(myLinkedList.indexOf("Second")); //1
        //myLinkedList.setLast(null);
        myLinkedList.insertLast("newFourth"); //[First, Second, Third, Fourth, newFourth]
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.getSize());

        myLinkedList.insert(1,"newSecond");
        System.out.println(myLinkedList); //[First, newSecond, Second, Third, Fourth, newFourth]
        System.out.println(myLinkedList.getSize());

        System.out.println(myLinkedList.contains("newSecond")); //true
        System.out.println(myLinkedList.contains("Zero"));//false
        System.out.println(myLinkedList.getElementByIndex(4));//Fourth

        //myLinkedList.setLast(null);
        myLinkedList.removeLast();
        System.out.println(myLinkedList);//[First, newSecond, Second, Third, Fourth]
        System.out.println(myLinkedList.getSize());//5
        myLinkedList.removeFirst();
        System.out.println(myLinkedList);//[newSecond, Second, Third, Fourth]
        System.out.println(myLinkedList.getSize());//4
        myLinkedList.removeByIndex(1);
        System.out.println(myLinkedList);//[newSecond, Third, Fourth]
        System.out.println(myLinkedList.getSize());//3
        myLinkedList.removeByValue("Third");
        System.out.println(myLinkedList);//[newSecond, Fourth]
        System.out.println(myLinkedList.getSize());//2
        myLinkedList.removeFirst();
        System.out.println(myLinkedList);//[Fourth]
        System.out.println(myLinkedList.getSize());//1
        myLinkedList.insert(1,"Six");
        System.out.println(myLinkedList);
        System.out.println(myLinkedList.getElementByIndex(0));

//        System.out.println(myLinkedList.clone());
//        myLinkedList.clear();
//        System.out.println(myLinkedList.getSize());


    }
}

