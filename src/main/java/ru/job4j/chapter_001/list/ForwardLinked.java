package ru.job4j.chapter_001.list;

import org.w3c.dom.ls.LSOutput;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;


public class ForwardLinked<T> implements Iterable<T> {
    /**
     * Ссылка на первый элемент
     */
    private Node<T> head;
    /**
     * Ссылка на последний элемент
     */
    private Node<T> last;
    /**
     * Размер списка
     */
    private int size = 0;

    /**
     * Метод добавления элемента в список
     *
     * @param value
     */
    public void add(T value) {
        Node node = new Node(value);
        if (isEmpty()) {
            head = node;
        } else {
            last.next = node;
            node.prev = last;
        }
        last = node;
        size++;
    }

    /**
     * Вывод элемента списка по индексу
     *
     * @param index - индекс элемента
     * @return - элемент
     */
    public T getByIndex(int index) {
        Objects.checkIndex(index, size);
        Node<T> target = head;
        for (int i = 0; i < index; i++) {
            target = target.next;
        }
        return target.value;
    }

    /**
     * Возвращает размер списка
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    public void deleteFirst() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void revert() {
        Node<T> curr = head;
        Node<T> pre = null;
        Node<T> incoming = null;

        while (curr != null) {
            incoming = curr.next;   // store incoming item

            curr.next = pre;        // swap nodes
            pre = curr;             // increment also pre

            curr = incoming;        // increment current
        }

        head = pre; // pre is the latest item where
        // curr is null
    }


    public T deleteLast() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        Node node = last;
        if (last.prev == null) {
            head = null;
        } else {
            last.prev.next = null;
        }
        last = last.prev;
        size--;
        return (T) node.value;
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
        private T value;
        /**
         * Следующий элемент
         */
        private Node next;
        /**
         * Предыдущий элемент
         */
        private Node prev;

        /**
         * Коснтруктор
         */
        public Node(T value) {
            this.value = value;
        }
    }
}
