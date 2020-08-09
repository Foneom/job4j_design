package ru.job4j.chapter_001.list;

import java.util.*;


public class DynamicArray<T> implements Iterable<T> {
    /**
     * Массив объектов
     */
    private Object[] container;
    /**
     * Индекс первой свободной ячейки и фактический размер массива
     */
    private int nElement = 0;

    /**
     * @param size - необходимый размер массива
     */
    public DynamicArray(int size) {
        this.container = new Object[size];
    }

    /**
     * Метод добавления элемента в свободную ячейку массива
     *
     * @param value
     */
    public void add(T value) {
        checkSize(nElement + 1);
        this.container[nElement++] = value;
    }

    /**
     * Метод вывода элемента по индексу
     *
     * @param position - позиция ячейки
     * @return
     */
    public T get(int position) {
        Objects.checkIndex(position, nElement);
        return (T) this.container[position];
    }

    public void checkSize(int nextIndex) {
        if (container.length - nextIndex < 0) {
            int nextLength = container.length * 3;
            container = Arrays.copyOf(container, nextLength);
        }
    }

    public int size() {
        return this.nElement;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return this.position < nElement;
            }

            @Override
            public T next() {
                if (position != nElement) {
                    throw new ConcurrentModificationException();
                }
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }

                return (T) container[position++];
            }
        };
    }
}
