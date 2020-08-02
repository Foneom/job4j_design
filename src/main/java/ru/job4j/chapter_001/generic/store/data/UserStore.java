package ru.job4j.chapter_001.generic.store.data;

import ru.job4j.chapter_001.generic.store.model.Store;
import ru.job4j.chapter_001.generic.store.model.User;

/**
 * Хранилище объектов User
 */
public class UserStore extends MemStore<User> {

    public UserStore(int size) {
        super();
    }

}