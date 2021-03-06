package ru.job4j.chapter_001.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface SimpleTree<E extends Comparable<E>> {

    boolean add(E parent, E child);

    Optional<Node<E>> findBy(E value);

        /**
         * Узле дерева
         *
         * @param <E>
         */
        class Node<E extends Comparable<E>> {
            private final E value;
            private final List<Node<E>> children = new ArrayList<>();

            public Node(E value) {
                this.value = value;
            }

            public void add(Node<E> child) {
                children.add(child);
            }

            public List<Node<E>> leaves() {
                return this.children;
            }

            public boolean eqValue(E that) {
                return value.compareTo(that) == 0;
            }
        }
    }

