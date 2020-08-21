package ru.job4j.chapter_001.set;

import ru.job4j.chapter_001.generic.simple_array.SimpleArray;

import java.util.Iterator;

public class SimpleSet<T> {

    private SimpleArray<T> array = new SimpleArray<>();

    public SimpleSet(int size) {
        array = new SimpleArray<>(size);
    }

    public boolean add(T value) {
        boolean flag = false;
        if (!array.contains(value)) {
            array.add(value);
            flag = true;
        }
        return flag;
    }

    public Iterator<T> iterator() {
        return array.iterator();
    }
}

