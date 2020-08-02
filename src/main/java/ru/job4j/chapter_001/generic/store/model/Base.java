package ru.job4j.chapter_001.generic.store.model;

/**
 * Описание общего поведения объектов
 */
public class Base {
    /**
     * Уникальный ключ объекта
     */
     private final String id;

    /**
     * Конструктор, инициализирует уникальный ключ
     * @param id
     */
     protected Base(final String id) {
         this.id = id;
     }

    /**
     * Метод возвращает ключ объекта
     * @return - id объекта
     */
     public String getId() {
         return id;
     }

    public void setId(String id) {
    }
}
