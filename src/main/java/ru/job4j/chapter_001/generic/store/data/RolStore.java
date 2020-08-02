package ru.job4j.chapter_001.generic.store.data;

import ru.job4j.chapter_001.generic.simple_array.SimpleArray;
import ru.job4j.chapter_001.generic.store.model.Role;
import ru.job4j.chapter_001.generic.store.model.Store;
import ru.job4j.chapter_001.generic.store.model.User;

/**
 * Контейнер объектов типа Role
 */
public class RolStore extends MemStore<Role> {
    /**
     * Конструктор, вызывающий конструктор суперкласса
     */
    public RolStore() {
        super();
    }
}
