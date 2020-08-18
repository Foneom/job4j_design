package ru.job4j.chapter_001.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int size;




    public T pop() {
        size--;
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
        size++;
    }

    public boolean isEmpty() {
        return (size == 0);
    }
}
