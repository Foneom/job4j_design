package ru.job4j.chapter_001.generic.store.model;

/**
 * Класс User, наследник Base
 */
public class User extends Base {
    /**
     * Конструктор с вызовом суперкласса
     * @param id
     */
    public User(String id) {
        super(id);
    }
}
