package ru.job4j.chapter_001.generic.store.data;

import ru.job4j.chapter_001.generic.simple_array.SimpleArray;
import ru.job4j.chapter_001.generic.store.model.Base;
import ru.job4j.chapter_001.generic.store.model.Role;
import ru.job4j.chapter_001.generic.store.model.Store;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        if (mem.get(index).getId().equals(id)) {
            model.setId(id);
            mem.set(index, model);
            return true;
        }
        return false;
    }

    @Override
    public boolean delete(String id) {
        Iterator<T> iterator = this.mem.iterator();
        boolean result = false;
        while (iterator.hasNext()) {
            if (iterator.next().getId().equals(id)) {
                iterator.remove();
                result = true;
                break;
            }
        }
        return result;
    }

    /**
     * Метод поиска объукта в хранилище по id
     * @param id
     * @return объект или null
     */
    @Override
    public T findById(String id) {
        T rsl = null;
        for (int index = 0; index < mem.size(); index++) {
            T element = mem.get(index);
            if (mem.get(index).getId().equals(id)) {
                rsl = element;
                break;
            }
        }
        return rsl;
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
