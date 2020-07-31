package ru.job4j.chapter_001.generic.simple_array;

import java.util.Iterator;
import java.util.Objects;

/**
 * Универсальный контейнер.
 *
 * @param <T> - тип объектов массива
 */
public class SimpleArray<T> implements Iterable<T> {
    /**
     * Массив объектов
     */
    private Object[] container;
    /**
     * Индекс первой свободной ячейки и фак4тический размер массива
     */
    private int index = 0;

    /**
     * @param size - необходимый размер массива
     */
    public SimpleArray(int size) {
        this.container = new Object[size];
    }

    /**
     * Метод добавления элемента в свободную ячейку массива
     *
     * @param value
     */
    public void add(T value) {
        this.container[index++] = value;
    }

    /**
     * Метод вывода элемента по индексу
     *
     * @param position - позиция ячейки
     * @return
     */
    public T get(int position) {
        Objects.checkIndex(position, index);
        return (T) this.container[position];
    }

    /**
     * Метод удаления элемента массива по индексу
     *
     * @param position - индекс ячейки дшля удаления
     * @return
     */
    public T remove(int position) {
        Objects.checkIndex(position, index);
        T value = (T) this.container[position];
        System.arraycopy(
                this.container, position + 1, this.container,
                position, this.container.length - position - 1);
        this.container[index] = null;
        return value;
    }

    /**
     * Метод замены элемента массива на другой
     *
     * @param position - номер ячейки заменяемого элемента
     * @param value    - новый элемент
     */

    public void set(int position, T value) {
        Objects.checkIndex(position, index);
        this.container[position] = value;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int position = 0;

            @Override
            public boolean hasNext() {
                return position < index;
            }

            @Override
            public T next() {
                return (T) container[position++];
            }
        };
    }
}
