package ru.job4j.chapter_001.map;

import java.util.*;


public class MyHashMap<K, V> implements Iterable<HashNode> {
    private int size;
    private final int DEFAULT_SIZE = 16;
    private HashNode<K, V>[] values = new HashNode[DEFAULT_SIZE];


    public boolean put(K key, V value) {
        boolean isInsert = true;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)) {
                values[i].setValue(value);
                isInsert = false;
            }
        }
        if (isInsert) {
            values[size] = new HashNode<>(key, value);
            size++;
        }
        return isInsert;
    }

    public V get(K key) {
        V result = null;
        for (int i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)
                    && values[i] != null) {
                result = values[i].getValue();
            }
        }
        return result;
    }

    public boolean delete(K key) {
        boolean isDeleted = false;
        int i;
        for (i = 0; i < size; i++) {
            if (values[i].getKey().equals(key)
                    && values[i] != null) {
                values[i] = null;
                for (int j = i; j < size; j++) {
                    values[i] = values[i + 1];
                    size--;
                    isDeleted = true;
                }
            }
        }
        return isDeleted;
    }


    private void newSize() {
        if (size == values.length) {
            int newSize = values.length * 2;
            values = Arrays.copyOf(values, newSize);
        }
    }

    @Override
    public Iterator<HashNode> iterator() {
        return new Iterator<>() {
            private int currentIndex = 0;
            @Override
            public boolean hasNext() {
                return currentIndex < size
                        && values[currentIndex] != null;
            }

            @Override
            public HashNode next() {
                return values[currentIndex++];
            }
        };
    }
}

    class HashNode<K, V> {
        private K key;
        private V value;

        public HashNode(K key, V value) {
            this.key = key;
            this.value = value;
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
            int prime = 13;
            int mul = 11;
            if (key != null) {
                int hashCode = prime * mul + key.hashCode();
                return hashCode;
            }
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || this.getClass().getName() != o.getClass().getName()) {
                return false;
            }
            HashNode e = (HashNode) o;
            if (this.key == e.key) {
                return true;
            }
            return false;
        }
    }
