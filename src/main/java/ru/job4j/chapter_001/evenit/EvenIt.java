package ru.job4j.chapter_001.evenit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] data;
    private int index;

    EvenIt(int[] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return isEven() == 0;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[index++];
    }
    /**
     * Метод поиска индекса четных элементов массива
     * @return
     */
    public Integer isEven() {
        int number = -1;
        for (int i = index; i < data.length; i++) {
            if (data[i] % 2 == 0) {
                index = i;
                number++;
                break;
            }
        }
        return number;
    }
}
