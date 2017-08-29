package org.compsci.datastructures.impl;

import org.compsci.datastructures.LinkedList;

import java.lang.reflect.Array;

/**
 * Created by zaiyangli on 29/08/2017.
 */
public class SinglyLinkedList<T> implements LinkedList<T>{

    private class ListNode<T> {
        private final T value;
        private ListNode<T> tail = null;

        private ListNode(T value) {
            this.value = value;
        }
        public T getValue() {
            return value;
        }

        public ListNode<T> tail() {
            return tail;
        }
        public void tail(ListNode<T> tail) {
            this.tail = tail;
        }
    }

    private ListNode<T> headNode;
    private int size = 0;

    @Override
    public void insert(T obj) {
        ensureNotNull(obj);
        if(headNode != null) {
            ListNode<T> newNode = new ListNode<>(obj);
            newNode.tail(headNode);
            headNode = newNode;
            size++;
        }else {
            headNode = new ListNode<>(obj);
            size = 1;
        }
    }

    /**
     * Deletes obj from list
     * @param obj
     */
    @Override
    public void delete(T obj) {
        ensureNotNull(obj);
        if(isEmpty()){
            return;
        }
        ListNode<T> currentNode = headNode;

        if(currentNode
                .getValue()
                .equals(obj)){
            headNode = currentNode.tail();
            // set tail reference to null otherwise can affect garbage collection.
            currentNode.tail(null);
        } else {
            // Invariant: currentNode.tail == nextNode
            boolean deleted = false;
            ListNode<T> nextNode = currentNode.tail();
            while(nextNode != null) {
                T value = nextNode.getValue();
                if(value.equals(obj)) {
                    // found match at last node.
                    // set currentNode
                    if(nextNode.tail() == null) {
                        currentNode.tail(null);
                    } else {
                        currentNode.tail(nextNode.tail());
                        nextNode.tail(null);
                    }
                    size--;
                    break;
                }
                currentNode = nextNode;
                nextNode = currentNode.tail();
            }
        }
    }

    @Override
    public void append(T obj) {
        ensureNotNull(obj);
        ListNode<T> newNode = new ListNode<>(obj);
        ListNode<T> currentNode = headNode;
        if(headNode != null) {
            while (currentNode.tail() != null) {
                currentNode = currentNode.tail();
            }
            currentNode.tail(newNode);
        } else {
            headNode = newNode;
        }
        size++;
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
        if(size == 0){
            return array;
        } else if (size == 1){
            array[0] = headNode.getValue();
            return array;
        }
        ListNode<T> currentNode = headNode;
        for(int i = 0; i < size; i++) {
            array[i] = currentNode.getValue();
            currentNode = currentNode.tail();
        }

        return array;
    }

    private void ensureNotNull(T obj) {
        if(obj == null){
            throw new NullPointerException("cannot insert null into linked list");
        }
    }
}
