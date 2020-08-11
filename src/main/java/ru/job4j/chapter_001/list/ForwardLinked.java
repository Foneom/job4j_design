package ru.job4j.chapter_001.list;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T>{
    /**
     * Ссылка на первый элемент
     */
    private Node<T> head;
    /**
     * Размер списка
     */
    private int size = 0;

    /**
     * Метод добавления элемента в список
     * @param value
     */
    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            size++;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    /**
     * Вывод элемента списка по индексу
     * @param index - индекс элемента
     * @return - элемент
     */
    public T getByIndex(int index) {
        Node<T> target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.value;
    }

    /**
     * Возвращает размер списка
     * @return
     */
    public int getSize() {
        return size;
    }

    public void deleteFirst() {
        if (head.next == null && size == 0) {
            throw new NoSuchElementException();
        }
            head = head.next;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
    private static class Node<T> {
        /**
         * Текущий элемент
         */
        T value;
        /**
         * Следующий элемент
         */
        Node<T> next;

        /**
         * Коснтруктор
         * @param value
         * @param next
         */
        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}
