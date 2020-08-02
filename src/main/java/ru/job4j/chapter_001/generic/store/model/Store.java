package ru.job4j.chapter_001.generic.store.model;

/**
 * Интерфейс контейнера для хранения объектов
 * @param <T>
 */
public interface Store<T extends Base> {
    /**
     * Метод добавления объекта в хранилище
     * @param model - объект типа Base
     */
    void add(T model);

    /**
     * Метод замены одного объекта на другой
     * @param id - id объекта
     * @param model - новый объект
     * @return true - успешная замена
     */
    boolean replace(String id, T model);


    /**
     * Метод удаления объекта
     * @param id - id объекта
     * @return
     */
    boolean delete(String id);

    /**
     * Метод поиска объекта в хранилище
     * @param id
     * @return
     */
    T findById(String id);
}
