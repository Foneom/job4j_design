package ru.job4j.chapter_001.map;

import org.junit.Test;

import java.util.GregorianCalendar;
import java.util.Iterator;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
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
        MyHashMap<String, Integer> store = new MyHashMap<>();
        store.put("Papa", 67);
        assertThat(store.get("Papa"), is(67));
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
    public void whenInsertValueByKeyShouldGetByKeySameValue() {
        MyHashMap<String, Integer> simpleMap = new MyHashMap<>();
        simpleMap.put("ss", 5);
        assertThat(simpleMap.get("ss"), is(5));
    }


    @Test
    public void whenGetByKeyDoesNotExistShouldNull() {
        MyHashMap<String, Integer> simpleMap = new MyHashMap<>();
        assertNull(simpleMap.get("ss"));
    }

    @Test
    public void whenAddMoreThan16ValuesShouldIncreaseSize() {
        MyHashMap<Integer, Integer> simpleMap = new MyHashMap<>();
        for (int i = 0; i < 16; i++) {
            simpleMap.put(i, i);
        }
        assertTrue(simpleMap.put(25, 25));
        assertThat(simpleMap.get(25), is(25));
    }

    @Test
    public void whenDeleteValueShouldGetNullByKey() {
        MyHashMap<String, Integer> simpleMap = new MyHashMap<>();
        assertTrue(simpleMap.put("ss", 5));
        assertThat(simpleMap.get("ss"), is(5));
        assertTrue(simpleMap.delete("ss"));
        assertNull(simpleMap.get("ss"));
    }

    @Test
    public void whenDeleteValueNotPresentShouldFalse() {
        MyHashMap<String, Integer> simpleMap = new MyHashMap<>();
        assertFalse(simpleMap.delete("ss"));
    }

    @Test
    public void whenInsertKeyNullShouldGetValueByKey() {
        MyHashMap<Integer, Integer> simpleMap = new MyHashMap<>();
        assertTrue(simpleMap.put(5, 5));
        assertTrue(simpleMap.put(null, 7));
        assertTrue(simpleMap.put(15, 15));
        assertThat(simpleMap.get(null), is(7));
    }
    @Test
    public void whenIterateThanTrue() {
        MyHashMap<Integer, String> simpleMap = new MyHashMap<>();
        simpleMap.put(12, "first");
        simpleMap.put(16, "second");
        Iterator itr = simpleMap.iterator();
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(true));
        System.out.println(itr.next());
        assertThat(itr.hasNext(), is(false));
    }


}