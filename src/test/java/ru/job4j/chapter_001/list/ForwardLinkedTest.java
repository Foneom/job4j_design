package ru.job4j.chapter_001.list;

import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class ForwardLinkedTest {
    @Test
    public void whenAddThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
    }

    @Test
    public void whenAddAndRevertThenIter() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.add(2);
        linked.revert();
        Iterator<Integer> it = linked.iterator();
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(1));
    }

    @Test
    public void whenAddAndGet() {
        ForwardLinked<Integer> list = new ForwardLinked<>();
        list.add(1);
        list.add(4);
        list.add(7);
        Integer result = list.getByIndex(1);
        assertThat(result, is(4));
    }

    @Test
    public void whenIteratorValid() {
        ForwardLinked<Integer> list = new ForwardLinked<>();
        list.add(1);
        list.add(4);
        list.add(7);
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(7));
    }

    @Test
    public void whenDelete() {
        ForwardLinked<Integer> list = new ForwardLinked<>();
        list.add(1);
        list.add(4);
        list.add(7);
        list.deleteFirst();
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(4));
        assertThat(iterator.next(), is(7));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteFirst() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.add(1);
        linked.deleteFirst();
        linked.iterator().next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDeleteEmptyLinked() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteFirst();
    }

    @Test
    public void whenDeleteLast() {
        ForwardLinked<Integer> list = new ForwardLinked<>();
        list.add(1);
        list.add(4);
        list.add(7);
        list.deleteLast();
        Iterator<Integer> iterator = list.iterator();
        assertThat(iterator.next(), is(1));
        assertThat(iterator.next(), is(4));
    }

    @Test(expected = NoSuchElementException.class)
    public void whenDelLastNPE() {
        ForwardLinked<Integer> linked = new ForwardLinked<>();
        linked.deleteLast();
    }
}