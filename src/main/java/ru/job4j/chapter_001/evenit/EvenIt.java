package ru.job4j.chapter_001.evenit;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {
    private final int[] arr;
    private int index;
    private int number;

    public EvenIt(int[] arr) {
        this.arr = arr;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
        EvenIt evenIt = new EvenIt(arr);
        while (evenIt.hasNext()) {
            int number = evenIt.next();
            if (evenIt.isEven(number)) {
                System.out.println(number);
            }
        }
    }

    public boolean isEven(int number) {
        if (number % 2 == 0) {
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        return index < arr.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return arr[index++];
    }
}
