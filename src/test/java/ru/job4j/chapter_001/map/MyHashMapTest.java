package ru.job4j.chapter_001.map;

import org.junit.Test;
import java.util.GregorianCalendar;
import java.util.Iterator;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class MyHashMapTest {
    @Test
    public void whenInsertThenDelete() {
        MyHashMap<String, String> store = new MyHashMap<>();
        assertThat(store.put("Ivan", "Ivanych"), is(true));
        assertThat(store.get("Fedor"), is(nullValue()));
        assertThat(store.get("Ivan"), is("Ivanych"));
        assertThat(store.delete("Makar"), is(false));
        assertThat(store.delete("Ivan"), is(true));

    }

    @Test
    public void whenInsertUserObject() {
        MyHashMap<User, Integer> store = new MyHashMap<>();
        User user1 = new User("Prokop", 5, new GregorianCalendar(1982, 7, 18));
        store.put(user1, 67);
        assertThat(store.get(user1), is(67));
    }

    @Test
    public void whenInsertObjectWithSameHashCode() {
        MyHashMap<String, String> store = new MyHashMap<>();
        assertThat(store.put("Ivan", "Ivanych"), is(true));
        assertThat(store.put("Ivan", "Ivanov"), is(false));
    }

    @Test
    public void whenTryOperateWithEmptyStore() {
        MyHashMap<String, String> store = new MyHashMap<>();
        assertThat(store.get("Ivan"), is(nullValue()));
        assertThat(store.delete("Ivan"), is(false));
    }

    @Test
    public void iteratorTest() {
        MyHashMap<String, Integer> map = new MyHashMap<>();
        map.put("first", 1);
        map.put("second", 2);
        map.put("third", 3);
        Iterator<HashNode> iterator = map.iterator();
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is(1));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getKey(), is("second"));
        assertThat(iterator.hasNext(), is(true));
        assertThat(iterator.next().getValue(), is(3));
        assertThat(iterator.hasNext(), is(false));
    }



}