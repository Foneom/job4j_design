package ru.job4j.chapter_001.generic.store.data;

import org.junit.Test;
import ru.job4j.chapter_001.generic.store.model.User;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MemStoreTest {
    @Test
    public void whenAddAndFindById() {
        UserStore store = new UserStore(4);
        store.add(new User("First"));
        String result = store.findById("First").getId();
        assertThat(result, is("First"));
    }

    @Test
    public void whenReplaceReturnTrue() {
        UserStore store = new UserStore(4);
        store.add(new User("First"));
        boolean result = store.replace("First", new User("Second"));
        assertTrue(result);
    }

    @Test
    public void whenDelete() {
        UserStore store = new UserStore(4);
        store.add(new User("First"));
        store.add(new User("Second"));
        store.add(new User("Third"));
        store.add(new User("Fourth"));
        boolean result = store.delete("Third");
        assertTrue(result);
    }

}