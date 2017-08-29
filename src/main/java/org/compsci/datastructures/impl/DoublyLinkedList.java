package org.compsci.datastructures.impl;

import org.compsci.datastructures.LinkedList;

import java.lang.reflect.Array;

/**
 * Doubly linked list is made up of nodes that includes two references,
 * to both the nodes before and after it.
 */
public class DoublyLinkedList<T> implements LinkedList<T> {

    private class DoublyLinkedNode<T> {
        private DoublyLinkedNode<T> previous;
        private DoublyLinkedNode<T> next;
        private final T value;

        private DoublyLinkedNode(T value) {
            this.value = value;
        }
        public T value() {
            return value;
        }
        public DoublyLinkedNode<T> previous() {
            return previous;
        }
        public void previous(DoublyLinkedNode<T> node) {
            this.previous = node;
        }
        public void next(DoublyLinkedNode<T> node) {
            this.next = node;
        }

        public DoublyLinkedNode<T> next() {
            return next;
        }
    }

    private DoublyLinkedNode<T> headNode;
    private DoublyLinkedNode<T> tailNode;
    private int size = 0;

    private void ensureNotNull(T obj){
        if(obj == null) {
            throw new NullPointerException("insert or delete does not accept null.");
        }
    }

    /**
     * Will insert obj into the front of the list.
     * @param obj
     */
    @Override
    public void insert(T obj) {
        ensureNotNull(obj);
        DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(obj);
        if(headNode != null) {
            headNode.previous(newNode);
            newNode.next(headNode);
            headNode = newNode;
        }
        else {
            headNode = newNode;
            tailNode = newNode;
        }
        size++;
    }

    @Override
    public void delete(T obj) {
        ensureNotNull(obj);
        if(isEmpty()){
            return;
        }
        if(size() == 1) {
            if(headNode.value().equals(obj)){
                headNode = null;
                tailNode = null;
                size--;
            }
        } else {
            DoublyLinkedNode<T> currentNode = headNode;
            while(currentNode != null) {
                if(currentNode.value().equals(obj)){
                    if(currentNode.previous() == null){
                        headNode = currentNode.next();
                    } else {
                        currentNode
                                .previous()
                                .next(currentNode.next);
                    }
                    if(currentNode.next() == null) {
                        tailNode = currentNode.previous;
                    } else {
                        currentNode
                                .next()
                                .previous(currentNode.previous);
                    }
                    size--;
                }
            }
        }
    }

    @Override
    public void append(T obj) {
        ensureNotNull(obj);
        if(tailNode != null) {
            DoublyLinkedNode<T> newNode = new DoublyLinkedNode<>(obj);
            tailNode.next(newNode);
            newNode.previous(tailNode);
            tailNode = newNode;
        } else {
            insert(obj);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return headNode == null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toJavaArray(Class<T> tClass) {
        T[] array = (T[]) Array.newInstance(tClass, size);
        if(size == 0) {
            return array;
        }
        DoublyLinkedNode<T> currentNode = headNode;

        for(int i = 0; i < size; i++) {
            array[i] = currentNode.value();
            currentNode = currentNode.next();
        }
        return array;
    }
}
