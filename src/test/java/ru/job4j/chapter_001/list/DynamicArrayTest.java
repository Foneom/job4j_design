package ru.job4j.chapter_001.list;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.chapter_001.generic.simple_array.SimpleArray;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DynamicArrayTest {
    @Test
    public void whenAddThenGet() {
        DynamicArray<Integer> array = new DynamicArray<>(2);
        array.add(1);
        array.add(2);
        array.add(3);
        assertThat(array.size(), is(3));
    }
 @Test
 public void whenAddAndGet() {
 DynamicArray<String> array = new DynamicArray<>(2);
 array.add("first");
 String rsl = array.get(0);
 assertThat(rsl, is("first"));
 }

 @Test(expected = IndexOutOfBoundsException.class)
 public void whenGetEmpty() {
 DynamicArray<String> array = new DynamicArray<>(10);
 array.get(0);
 }

 @Test(expected = IndexOutOfBoundsException.class)
 public void whenGetOutBound() {
 DynamicArray<String> array = new DynamicArray<>(10);
 array.add("first");
 array.get(1);
 }

    @Test(expected = NoSuchElementException.class)
    public void whenGetEmptyFromIt() {
        DynamicArray<String> array = new DynamicArray<>(0);
        array.iterator().next();
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenCorruptedIt() {
        DynamicArray<String> array = new DynamicArray<>(10);
        array.add("first");
        Iterator<String> it = array.iterator();
        array.add("second");
        it.next();
    }
}
