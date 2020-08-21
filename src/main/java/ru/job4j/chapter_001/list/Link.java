package ru.job4j.chapter_001.list;

import javax.swing.text.html.HTMLDocument;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Link<E> {
    /**
     * Данные
     */
    public E dData;
    /**
     * Следующий элемент в списке
     */
    public Link<E> next;

    /**
     * Конструктор
     *
     * @param dData
     */
    public Link(E dData) {
        this.dData = dData;
    }

    /**
     * Вывод содержимого элемента
     */
    public void displayLink() {
        System.out.println(dData + " ");
    }
}
class LastList<E> implements Iterable {
    /**
     * Ссылка на первый элемент
     */
    private Link first;
    /**
     * Сссылка на последний элемент
     */
    private Link last;
    /**
     * Количество элементов в контейнере
     */
    private int size;

    /**
     * Ссылки не содержат элементов
     */
    public LastList() {
        this.first = null;
        this.last = null;
        this.size = 0;
    }

    /**
     * Метод прверки наличия элементов
     *
     * @return true, ессли список пуст
     */
    public boolean isEmpty() {
        return first == null;
    }
    public void addFirst(E value) {
        Link eLink = new Link(value);
        if (isEmpty()) {
            last = eLink;
            eLink.next = first;
            first = eLink;
        }
        size++;
    }
    public void addLast(E value) {
        Link eLink = new Link(value);
        if (isEmpty()) {
            first = eLink;
        } else {
            last.next = eLink;
            last = eLink;
        }
        size++;
    }

    public E get(int index) {
        Link current = this.first;
        for (int i = 0; i != index; i++) {
            current = current.next;
        }
        return (E) current.dData;
    }
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Link<E> last;

            private Link<E> next = first;

            /**
             * Счетчик
             */
            private int count = 0;

            @Override
            public boolean hasNext() {
                return this.count < size;
            }

            @Override
            public E next() {
                if (!this.hasNext()) {
                    throw new NoSuchElementException();
                }
                this.last = this.next;
                this.next = this.next.next;
                this.count++;
                return this.last.dData;
            }
        };
    }
}
class LinkTest {
    public static void main(String[] args) {
        LastList<Integer> lastList = new LastList<>();

      //  lastList.addFirst(21);
       lastList.addFirst(12);
       lastList.addLast(11);

       // lastList.iterator();
    }
}
