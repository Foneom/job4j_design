package ru.job4j.chapter_001.generic.simple_array;

public class SimpleArray<T> {

    Object[] objects;
    int index = 0;

    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    public void add(T value) {
        this.objects[index++] = value;
    }

    public T get(int position) {
        return (T) this.objects[position];
    }

    public void remove(int position) {
        System.arraycopy(
               this.objects, position + 1, this.objects,
                position, this.index - position);
        this.index--;
    }

    public void set(int position, T value) {
        System.arraycopy(
                this.objects, position, this.objects,
                position, 1);
        this.index++;
    }

}
