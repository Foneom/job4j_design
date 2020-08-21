package ru.job4j.chapter_001.set;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class SimpleSetTest {

    @Test
    public void whenTrueHashSet() {
        SimpleSet<Integer> array = new SimpleSet<>(10);
        array.add(1);
        array.add(4);
        array.add(2);
        array.add(1);
        Iterator<Integer> iterator = array.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(2));
    }

}