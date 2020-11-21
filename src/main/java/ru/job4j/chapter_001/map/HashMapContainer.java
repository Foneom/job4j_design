package ru.job4j.chapter_001.map;

import java.security.Key;
import java.util.*;

public class HashMapContainer<K, V> {
    /**
     * Хранилище пары ключ-значение
     */
    private Node<K, V>[] table;
    /**
     * Колличество элементов в массиве
     */
    private int size = 0;
    /**
     * Параметр расширения массива
     */
    private float threshold;
    /**
     * Счетчик
     */
    private int modCount;
    private static final float LOAD_FACTOR = 0.75f;

    public HashMapContainer() {
        table = new Node[16];
        threshold = table.length * 0.75f;
    }
/**
    public boolean insert(K key, V value) {
        boolean duplicate = false;
        if (this.size >= this.threshold) {
            this.resize();
        }
        int hash = key.hashCode() ^ (key.hashCode() >>> 16);
        int index = hash & (this.table.length - 1);
        for (Node<K, V> e = this.table[index]; e != null; e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                e.value = value;
                this.modCount++;
                duplicate = true;
                break;
            }
        }
        if (!duplicate) {
            this.table[index] = new Node<>(hash, key, value, this.table[index]);
            this.size++;
            this.modCount++;
        }
        return !duplicate;
    }

    public Node<K, V> nextEntry() {
        Node<K, V>[] tab = table;
        Node<K, V> e = this.next;
        this.current = e;
        if (e == null) {

            throw new NoSuchElementException();
        }
        if (this.count != modCount) {
            throw new ConcurrentModificationException();
        }
        if (tab != null && e.next == null) {
            do {
                this.index++;
            } while (this.index < tab.length - 1 && tab[this.index] == null);
            this.next = tab[this.index];
        } else {
            this.next = e.next;
        }
        return e;
    }
}
*/
    /**
     * Метод возвращения значения
     * @param key
     * @return
     */
    public V get(K key) {
        V value = null;
        int hash = key.hashCode() ^ (key.hashCode() >>> 16);
        int index = hash & (this.table.length - 1);
        Node<K, V> first = this.table[index];
        if (first != null) {
            for (Node<K, V> e = first; e != null; e = e.next) {
                if (e.hash == hash && e.key.equals(key)) {
                    value = e.value;
                }
            }
        }
        return value;
    }

    /**
     * Удаления значения
     * @param key
     * @return
     */
    public boolean delete(K key) {
        boolean flag = false;
        Node<K, V>[] tab = this.table;
        int hash = key.hashCode() ^ (key.hashCode() >>> 16);
        int index = hash & (tab.length - 1);
        Node<K, V> e = tab[index];
        for (Node<K, V> prev = null; e != null; prev = e, e = e.next) {
            if (e.hash == hash && e.key.equals(key)) {
                if (prev == null) {
                    this.table[index] = null;
                } else {
                    prev.next = e.next;
                }
                flag = true;
                this.size--;
                this.modCount++;
            }
        }
        return flag;
    }
/*
    private void resize() {
        Node<K, V>[] oldTab = this.table;
        int oldSize = this.table.length;
        int newSize = oldSize * 2;
        this.threshold = (int) (LOAD_FACTOR * newSize);
        Node<K, V>[] newTab = (Node<K, V>[]) new Node<>()[newSize];
        this.table = newTab;
        for (int i = 0; i < oldTab.length; i++) {
            Node<K, V> e = oldTab[i];
            if (e != null) {
                newTab[e.hash & (newSize - 1)] = e;
                oldTab[i] = null;
            }
        }
    }
*/
/**
 * Вложенный класс пары ключ-значение
 * @param <K> - ключ
 * @param <V> - значение
 */
public class Node<K, V> {
    private Node<K, V> next;
    /**
     * Хэш-код ключа
     */
    private int hash;
    /**
     * Значение ключа
     */
    private K key;
    /**
     * Значение
     */
    private V value;

    public Node(int hash, K key, V value, Node<K, V> next) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        this.next = next;
    }
}
}
