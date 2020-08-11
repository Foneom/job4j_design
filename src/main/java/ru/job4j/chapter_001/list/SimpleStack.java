package ru.job4j.chapter_001.list;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();
    private int top;

    public T pop() {
       return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
    }

    public boolean isEmpty() {
        return (top == -1);
    }

}
