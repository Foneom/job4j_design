package ru.job4j.chapter_001.matrixit;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * @position - номер текущег элемента
 * @size - количество элементов в матрице
 * @row - строка
 * @column - cтолбец
 */
public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int position;
    private int size;
    private int row;
    private int column;

    public MatrixIt(int[][] data) {
        this.data = data;
        this.size = countElements(data);
    }

    /**
     * Метод подсчета количества элемнтов в матрице
     * @param data
     * @return
     */
    private int countElements(int[][] data) {
        int count = 0;
        for (int[] row : data) {
            count += row.length;
        }
        return count;
    }

    @Override
    public boolean hasNext() {
        return position < size;
    }

    @Override
    public Integer next() {
        if (position >= size) {
            throw new NoSuchElementException();
        }
        Integer element = data[row][column];
        position++;
        column++;
        while (row < data.length && column >= data[row].length) {
            column = 0;
            row++;
        }
        return element;
    }
}
