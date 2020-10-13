package ru.job4j.chapter_001.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;


public class Tree<E> implements SimpleTree<E> {

    private final Node<E> root;


    Tree(final E root) {
        this.root = new Node<>(root);
    }


    public boolean containsNode(Node<E> root, int value) {
        return containsNode(this.root, value);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        if (findBy(parent).isPresent()) {
            findBy(parent).get().add(new Node<>(child));
            rsl = true;
        } else if (findBy(child).isEmpty()) {
            root.add(new Node<>(child));
            rsl = true;
        }
            return rsl;
        }

        @Override
        public Optional<Node<E>> findBy (E value){
            Optional<Node<E>> rsl = Optional.empty();
            Queue<Node<E>> data = new LinkedList<>();
            data.offer(this.root);
            while (!data.isEmpty()) {
                Node<E> el = data.poll();
                if (el.value.equals(value)) {
                    rsl = Optional.of(el);
                    break;
                }
                data.addAll(el.children);
            }
            return rsl;
        }

        public boolean isBinary() {
        boolean result = true;
            Queue<Node<E>> data = new LinkedList<>();
            data.offer(this.root);
            while (!data.isEmpty()) {
                Node<E> el = data.poll();
                if (el.children.size() <= 2) {
                    data.addAll(el.children);
                } else {
                    result = false;
                    break;
                }
            }
            return result;
        }
    }