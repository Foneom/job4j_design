package ru.job4j.chapter_001.map;

import java.util.*;


public class MyHashMap<K, V> implements Iterable<V> {
    /**
     * Количество пар ключ-значение
     */
    private transient int size;
    /**
     * Емкость хэш - таблицы по умолчанию 16
     */
    static final int DEFAULT_CAPACITY = 1 << 4;
    /**
     * Коэффициент загрузки хэш-таблицы
     */
    static final float DEFAULT_LOAD_FACTOR = 0.75f;
    /**
     * Счетчик итератора
     */
    private int count;
    /**
     * Хэш таблица
     */
    private transient Node<K, V>[] values;

    /**
     * Конструктор
     */
    public MyHashMap() {
        values = new Node[DEFAULT_CAPACITY];
        size = 0;
        count = 0;
    }

    /**
     * Метод вычисления хэш - значения ключа введенного объекта
     *
     * @param key
     * @return
     */
    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    /**
     * Метод вставки элемента в бакет
     *
     * @param key
     * @param value
     * @return
     */
    public boolean put(K key, V value) {
        boolean insert = false;
        int index = (values.length - 1) & hash(key);
        if (values[index] != null && Objects.equals(values[index].getKey(), key)) {
            values[index].setValue(value);
        } else {
            values[index] = new Node<>(key, value);
            count++;
            size++;
            resize();
            insert = true;
        }
        return insert;
    }



    /**
     * Метод увеличения количества бакетов при достижении предельной загрузки
     */
    private void resize() {
        if (size >= DEFAULT_LOAD_FACTOR * values.length) {
            Node<K, V>[] oldTab = values;
            values = (Node<K, V>[]) new Node[size];
            for (Node<K, V> node : oldTab) {
                if (node != null) {
                    K key = node.key;
                    V value = node.value;
                    int index = (values.length - 1) & hash(key);
                    values[index] = new Node<>(key, value);
                }
            }
        }
    }

        /**
         * Метод возвращает значение по ключу
         *
         * @param key
         * @return
         */
        public V get (K key) {
            V result = null;
            int index = (values.length - 1) & hash(key);
            Node<K, V> searched = values[index];
            if (searched != null) {
                if ((searched.key == null && key == null) || (searched.key != null && Objects.equals(searched.key, key))) {
                    result = searched.value;
                }
            }
            return result;
        }

        /**
         * Метод удаления данных из хранилища
         *
         * @param key
         * @return
         */
        public boolean delete (K key){
            boolean delete = false;
            int index = (values.length - 1) & hash(key);
            Node<K, V> searched = values[index];
            if (searched != null && Objects.equals(searched.getKey(), key)) {
                values[index] = null;
                size--;
                delete = true;
            }
            return delete;
        }

        private class SimpleMapIterator implements Iterator<V> {

            private int index = 0;
            Node<K, V> node = null;
            private final int expectedModCount = count;

            @Override
            public boolean hasNext() {
                boolean hasNext = false;
                if (index < values.length) {
                    do {
                        node = values[index++];
                    } while (node == null && index < values.length);
                    hasNext = (node != null);
                    index--;
                }
                return hasNext;
            }

            @Override
            public V next() {
                if (expectedModCount != count) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException("Simple map");
                }
                return values[index++].value;
            }
        }

        @Override
        public Iterator<V> iterator () {
            return new SimpleMapIterator();
        }


    /**
     * Класс узла
     *
     * @param <K>
     * @param <V>
     */
    class Node<K, V> {
        Node<K, V> next;
        K key;
        V value;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            next = null;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public int hashCode() {
            final int PRIME = 31;
            int result = 1;
            result = result * PRIME + ((key == null) ? 0 : (key.hashCode()));
            return result;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || o.getClass() != this.getClass()) {
                return false;
            }
            Node node = (Node) o;
            if (this.key == node.key) {
                return true;
            }
            return false;
        }
    }
}
