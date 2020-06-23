package ru.q1w2e3.myLinkedList;

public class Node<T> {
    T value;
    Node next;
    Node previous;

    public Node(T value, Node next) {
        this.value = value;
        this.next = next;
    }

    public Node(T value, Node next, Node previous) {
        this.value = value;
        this.next = next;
        this.previous = previous;
    }

    public Node(T value) {
        this.value = value;
    }
}

