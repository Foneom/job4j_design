package ru.job4j.chapter_001.generic.store.data;

import ru.job4j.chapter_001.generic.simple_array.SimpleArray;
import ru.job4j.chapter_001.generic.store.model.Base;
import ru.job4j.chapter_001.generic.store.model.Role;
import ru.job4j.chapter_001.generic.store.model.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 * Класс, реализующий интерфейс Store
 * @param <T>
 */
public class MemStore<T extends Base> implements Store<T> {
    /**
     * Хранилище объектов
     */
    private final List<T> mem = new ArrayList<>();
    /**
     * Метод добавления объекта в хранилище
     * @param model - объект типа Base
     */
    @Override
    public void add(T model) {
        this.mem.add(model);
    }

    /**
     * Метод замены объекта на новый
     * @param id - id объекта
     * @param model - новый объект
     * @return
     */
    @Override
    public boolean replace(String id, T model) {
        int index = this.indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            model.setId(id);
            mem.set(index, model);
        }
        return rsl;
    }

    /**
     * Метод удаления объекта из хранилища
     * @param id - id объекта
     * @return
     */
    @Override
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            mem.remove(index);
        }
        return rsl;
    }

    /**
     * Метод поиска объукта в хранилище по id
     * @param id
     * @return объект или null
     */
    @Override
    public T findById(String id) {
        int index = indexOf(id);
        return index != -1 ? mem.get(index) : null;
    }

    /**
     * Вспомогательный метод
     * @param id
     * @return
     */
    private int indexOf(String id) {
        int rsl = -1;
        for (int index = 0; index < mem.size(); index++) {
            if (mem.get(index).getId().equals(id)) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
}
