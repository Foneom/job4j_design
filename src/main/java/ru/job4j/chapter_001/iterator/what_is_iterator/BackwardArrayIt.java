package ru.job4j.chapter_001.iterator.what_is_iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int index = 0;
    private int tmp =  0;

    public BackwardArrayIt(int[] data) {
        this.data = data;
        this.index = data.length - 1;
    }

    @Override
    public boolean hasNext() {
        return index >= 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index--];
    }
}
