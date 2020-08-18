package ru.job4j.chapter_001.list;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    /**
     * Возвращает первое значение и удаляет его из коллекции
     * @return
     */
    public T poll() {
        if (out.isEmpty()) {
            while (!in.isEmpty()) {
                out.push(in.pop());
            }
        }
        return out.pop();
    }

    /**
     * Помещает значение в конец
     * @param value
     */
    public void push(T value) {
        in.push(value);
    }
}
