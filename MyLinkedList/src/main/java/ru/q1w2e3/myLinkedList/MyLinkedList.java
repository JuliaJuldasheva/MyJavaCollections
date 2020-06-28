package ru.q1w2e3.myLinkedList;

import java.util.NoSuchElementException;

/**
 * Класс для работы с двунаправленным связанным списком
 *
 * @param <T> тип элемента списка
 * @author Yuldasheva Yuliya
 */
public class MyLinkedList<T> {

    /**
     * first - ссылка на первый элемент
     * last - ссылка на последний элемент
     * size - количество элементов в списке
     */
    private Node<T> first;
    private Node<T> last;

    private int size = 0;

    public void setLast(Node<T> last) {
        this.last = last;
    }

    public void setFirst(Node<T> first) {
        this.first = first;
    }

    /**
     * Количесвто элементов списка
     *
     * @return количесвто элементов списка
     */
    public int getSize() {
        return size;
    }

    /**
     * Поиск индекса элемента по значению
     *
     * @param value значение элемента
     * @return индекс элемента, если элемент найден;
     * -1 если элемент не найден
     */
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

    /**
     * Проверка наличия элемента в списке по значению
     *
     * @param value значение элемента
     * @return true, если элемент есть; false, если элемента нет
     */
    public boolean contains(T value) {
        return indexOf(value) > -1;
    }

    /**
     * Проверка списка на пустоту
     *
     * @return true, если список пустой; false - если список непустой
     */
    public boolean isEmpty() {
        return this.getSize() == 0;
    }

    /**
     * Получение значения первого элемента списка
     *
     * @return значение первого элемента списка
     */
    public T getFirst() {
        checkListSize();
        checkFirstLinkIsNull();
        return first.value;
    }

    /**
     * Получение значения последнего элемента списка
     *
     * @return значение последнего элемента списка
     */
    public T getLast() {
        checkListSize();
        checkLastLinkIsNull();
        return last.value;
    }

    /**
     * Получение значения элемента списка по индексу
     *
     * @param index
     * @return значение элемента списка
     */
    public T getElementByIndex(int index) {
        checkListSize();
        checkFirstLinkIsNull();
        checkElementIndex(index);

        if (index == 0) {
            getFirst();
        }
        if (index == size - 1) {
            getLast();
        }
        Node<T> current = first.next;
        for (int i = 1; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    /**
     * Создание полной копии списка
     *
     * @return новый список, идентичный заданному
     */
    public MyLinkedList<T> clone() {
        checkListSize();

        MyLinkedList<T> cloneLinkedList = new MyLinkedList<T>();

        for(Node<T> current = first; current != null; current = current.next) {
            cloneLinkedList.insertLast(current.value);
        }
        return cloneLinkedList;
    }

    /**
     * Вставка элемента в начало списка
     *
     * @param value значение нового элемента списка
     */
    public void insertFirst(T value) {
        checkElementValue(value);
        Node<T> newFirstNode = new Node<T>(value, first);
        if (isEmpty()) {
            last = newFirstNode;
        } else {
            first.previous = newFirstNode;
        }
        first = newFirstNode;
        size++;
    }

    /**
     * Вставка элемента в конец списка
     *
     * @param value значение нового элемента списка
     */
    public void insertLast(T value) {
        checkElementValue(value);
        Node<T> newLastNode = new Node<T>(last, value);
        if (isEmpty()) {
            first = newLastNode;
        } else {
            checkLastLinkIsNull();
            newLastNode.previous = last;
            last.next = newLastNode;
        }
        last = newLastNode;
        size++;
    }

    /**
     * Вставка элемента в произвольное место списка
     *
     * @param index позиции, куда будет вставлен элемент
     * @param value значение нового элемента списка
     */
    public void insert(int index, T value) {
        checkElementIndex(index);
        checkElementValue(value);
        if (index == 0 || isEmpty()) {
            insertFirst(value);
            return;
        }
        if (index == size - 1) {
            insertLast(value);
            return;
        }
        checkFirstLinkIsNull();
        Node<T> current = first;
        int i = 0;
        while (i != index - 1) {
            current = current.next;
            i++;
        }
        Node<T> newNode = new Node<T>(value, current.next, current);
        current.next = newNode;
        newNode.next.previous = newNode;
        size++;
    }

    /**
     * Удаление первого элемента
     *
     * @return значение удаленного элемента
     */
    public T removeFirst() {
        checkListSize();
        checkFirstLinkIsNull();
        Node<T> oldFirst = first;
        first = first.next;
        if (isEmpty()) {
            last = null;
        } else {
            first.previous = null;
        }
        size--;
        return oldFirst.value;
    }

    /**
     * Удаление последнего элемента
     *
     * @return значение удаленного элемента
     */
    public T removeLast() {
        checkListSize();
        checkLastLinkIsNull();
        Node<T> oldLast = last;
        if (last.previous != null) {
            last.previous.next = null;
        } else {
            first = null;
        }
        last = last.previous;
        size--;
        return oldLast.value;
    }

    /**
     * Удаление элемента по значению
     *
     * @param value удаляемое значение
     * @return true, если элемент удален;
     * false, если элемент не удалось удалить - нет в списке
     */
    public boolean remove(T value) {
        checkListSize();
        checkFirstLinkIsNull();
        checkLastLinkIsNull();
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
        size--;
        return true;
    }

    /**
     * Удаление элемента по индексу
     *
     * @param index индекс удаляемого элемента
     * @return true, если элемент удален;
     * false, если элемент не удалось удалить - нет в списке
     */
    public boolean remove(int index) {
        checkListSize();
        checkElementIndex(index);
        if (index == 0) {
            removeFirst();
            return true;
        }
        if (index == size - 1) {
            removeLast();
            return true;
        }
        checkFirstLinkIsNull();
        Node<T> current = first;
        int i = 0;
        while (i != index) {
            current = current.next;
            i++;
        }
        return remove(current.value);
    }

    /**
     * Удаление всех элементов списка
     */
    public void clear() {
        checkListSize();
        checkFirstLinkIsNull();
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
        if(isEmpty()){
            StringBuilder sb = new StringBuilder("[]");
            return sb.toString();
        }
        Node current = first;
        StringBuilder sb = new StringBuilder("[");

        while (current != null) {
            sb.append(current.value.toString() + ", ");
            current = current.next;
        }
        String result = sb.toString().substring(0, sb.length() - 2);
        return result + "]";
    }

    /**
     * Проверка списка на пустоту
     *
     * @throws NoSuchElementException если список пустой
     */
    private void checkListSize() {
        if (isEmpty()) {
            throw new NoSuchElementException("Список пуст");
        }
    }

    /**
     * Проверка индекса элемента
     *
     * @param index проверяемый индекс
     * @throws IndexOutOfBoundsException если индекс некорректный
     */
    private void checkElementIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Некорректный индекс");
        }
    }

    /**
     * Проверяет значение элемента списка
     * элемент не может быть null
     *
     * @param value значение проверяемого элемента
     * @throws IllegalArgumentException если значение проверяемого элемента null
     */
    private void checkElementValue(T value) {
        if (value == null) {
            throw new IllegalArgumentException("value не может быть null");
        }
    }

    /**
     * Проверяет, что ссылка на последний элемент не пустая
     * Предполагаем при этом, что список не пустой
     * @throws NullPointerException если ссыка на последний элемент null
     */
    private void checkLastLinkIsNull() {
        if (last == null) {
            throw (new NullPointerException("Ссылка last не должна быть null"));
        }
    }

    /**
     * Проверяет, что ссылка на первый элемент не пустая
     * Предполагаем при этом, что список не пустой
     * @throws NullPointerException если ссылка на первый элемент null
     */
    private void checkFirstLinkIsNull() {
        if (first == null) {
            throw (new NullPointerException("Ссылка first не должна быть null"));
        }
    }

    /**
     * Класс элемент списка
     *
     * @param <T> тип элемента списка
     * value - значение элемента списка
     * next - ссылка на следующий элемент списка
     * previous - ссылка на предыдущий элемент списка
     */
    private class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> previous;

        public Node(T value, Node<T> next, Node<T> previous) {
            this.value = value;
            this.next = next;
            this.previous = previous;
        }

        public Node(T value, Node<T> next) {
            this(value, next, null);
        }

        public Node(Node<T> previous, T value) {
            this(value, null, null);
        }
    }
}





