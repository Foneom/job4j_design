package ru.job4j.chapter_001.generic.simple_array;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleArrayTest {
    /**
     * Тест метода добавления элемнта массива
     */
    @Test
    public void whenAddToArray() {
        SimpleArray<String> simpleArray = new SimpleArray(5);
        simpleArray.add("Hello");
        String result = simpleArray.get(0);
        assertThat(result, is("Hello"));
    }
    /**
     * Тест метода удаления элемента массива
     */
    @Test
    public void whenRemove() {
        SimpleArray<String> simpleArray = new SimpleArray<>(4);
        simpleArray.add("Test");
        simpleArray.remove(0);
        String result = simpleArray.get(0);
        assertNull(result);
    }
    /**
     * Тест метода замены элемента массива
     */
    @Test
    public void whenSet() {
        SimpleArray<String> simpleArray = new SimpleArray(5);
        simpleArray.add("Hello");
        simpleArray.set(0, "Test");
        String result = simpleArray.get(0);
        assertThat(result, is("Test"));
    }
    /**
     * Тест работы итератора
     */
    @Test
    public void whenIterator() {
        SimpleArray<Integer> list = new SimpleArray<>(3);
        list.add(1);
        list.add(2);
        list.add(3);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), Matchers.is(1));
        assertThat(iterator.next(), Matchers.is(2));
        assertThat(iterator.next(), Matchers.is(3));
    }
}