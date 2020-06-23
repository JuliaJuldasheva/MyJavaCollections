package ru.q1w2e3.myLinkedList;

import java.util.NoSuchElementException;

public class MyLinkedList<T> {

    private Node first; //ссылка на первый элемент
    private Node last; //ссылка на последний элемент

    private int size = 0; //количество элементов списка

    //Получение количества элементов
    public int getSize() {
        return size;
    }

    //Получение индекса элемента
    public int indexOf(T value) {
        Node<T> current = first;
        int index = 0;

        while (current != null) {
            if (current.value.equals(value)) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    //Проверка на наличие элемента в коллекции
    public boolean contains(T value) {
        return indexOf(value) > -1;
    }

    //Проверка на пустоту
    public boolean isEmpty() {
        return first == null;
    }

    public void checkListSize() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пуст");
        }
    }

    public void checkElementIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
    }

    public T getFirst() {
        return (T) first.value;
    }

    public T getLast() {
        return (T) last.value;
    }

    //Получение элемента по индексу
    public T getElementByIndex(int index) {
        checkListSize();
        checkElementIndex(index);
        if (index == 0) {
            getFirst();
        }
        if (index == size) {
            getLast();
        }
        Node<T> current = first;
        while (indexOf(current.value) != index) {
            current = current.next;
        }
        return current.value;
    }

    public MyLinkedList<T> clone() {
        checkListSize();

        MyLinkedList<T> cloneLinkedList = new MyLinkedList<T>();

        Node<T> current = first;
        while (current != null) {
            cloneLinkedList.insert(indexOf(current.value), current.value);
            current = current.next;
        }
        return cloneLinkedList;
    }

    //Вставка элемента в начало списка
    public void insertFirst(T value) {
        Node<T> newFirstNode = new Node<T>(value, first);
        if (isEmpty()) {
            last = newFirstNode;
        } else {
            first.previous = newFirstNode;
        }
        first = newFirstNode;
        size++;
    }

    //Вставка элемента в конец списка
    public void insertLast(T value) {
        Node<T> newLastNode = new Node<T>(value);
        if (isEmpty()) {
            first = newLastNode;
        } else {
            newLastNode.previous = last;
            last.next = newLastNode;
        }
        last = newLastNode;
        size++;
    }

    //Вставка элемента в произвольное место списка
    public void insert(int index, T value) {
        checkElementIndex(index);
        if (index == 0) {
            insertFirst(value);
            return;
        }
        if (index == size) {
            insertLast(value);
            return;
        }

        Node current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.next;
            i++;
        }
        Node newNode = new Node(value);
        newNode.next = current.next;
        newNode.previous = current;
        current.next = newNode;
        newNode.next.previous = newNode;
    }

    //Удаление первого элемента
    public T removeFirst() {
        checkListSize();
        Node<T> oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else first.previous = null;
        size--;
        return oldFirst.value;
    }

    //Удаление последнего элемента
    public T removeLast() {
        checkListSize();
        Node<T> oldLast = last;

        if (last.previous != null) {
            last.previous.next = null;
        } else first = null;
        last = last.previous;
        size--;
        return oldLast.value;
    }

    //Удаление элемента по значению
    public boolean remove(T value) {
        checkListSize();
        if (first.value.equals(value)) {
            removeFirst();
            return true;
        }
        Node<T> current = first;
        while (current != null && !current.value.equals(value)) {
            current = current.next;
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            removeLast();
            return true;
        }
        current.next.previous = current.previous;
        current.previous.next = current.next;
        current.next = null;
        current.previous = null;
        return true;
    }

    //Удаление элемента по индексу
    public boolean remove(int index) {
        checkListSize();
        checkElementIndex(index);
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size) {
            removeLast();
            return true;
        }
        Node<T> current = first;
        while (indexOf(current.value) != index) {
            current = current.next;
        }
        return remove(current.value);
    }

    //очистка листа
    public void clear() {
        checkListSize();

        Node<T> current = first;

        while (current != null) {
            Node<T> next = current.next;
            current.previous = null;
            current.next = null;
            current.value = null;
            current = next;
            size--;
        }
        first = null;
        last = null;
    }

    @Override
    public String toString() {
        Node current = first;
        StringBuilder sb = new StringBuilder("[");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.next;
        }
        String result = sb.toString().substring(0, sb.length() - 2);
        return result + "]";
    }
}

