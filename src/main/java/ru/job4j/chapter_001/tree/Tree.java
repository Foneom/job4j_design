package ru.job4j.chapter_001.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * Эллеменарная структура дерева
 *
 * @param <E>
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E> {
    /**
     * Корень дерева
     */
    private final Node<E> root;

    /**
     * Конструктор дерева с указанным корнем
     *
     * @param root
     */
    public Tree(final E root) {
        this.root = new Node<E>(root);
    }

    /**
     * Метод добавления элемента child по ключу parent
     *
     * @param parent
     * @param child
     * @return
     */
    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (findBy(child).isEmpty()) {
            findBy(parent).ifPresent(node -> node.add(new Node<>(child)));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Поиск узла по условию
     *
     * @param predicate
     * @return
     */
    private Optional<Node<E>> findNode(Predicate<Node<E>> predicate) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (predicate.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Метод проверки дерева на бинарность
     *
     * @return
     */
    public boolean isBinary() {
        boolean rsl = true;
        if (findNode(node -> node.leaves().size() > 2).isPresent()) {
            rsl = false;
        }
        return rsl;
    }


    /**
     * Метод поиска по ключу
     *
     * @param value
     * @return
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        return findNode(node -> node.eqValue(value));
    }

}