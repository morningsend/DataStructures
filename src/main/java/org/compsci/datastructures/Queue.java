package org.compsci.datastructures;

/**
 * First In, First Out.
 */
public interface Queue<T> extends Collection {
    void enque(T obj);
    T dequeue();
}
