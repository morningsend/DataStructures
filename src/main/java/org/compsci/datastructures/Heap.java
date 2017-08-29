package org.compsci.datastructures;

/**
 * A heap is a tree that maintains the top element
 * as the maximum or minimum element in the whole collection
 */
public interface Heap<T> extends Collection<T> {
    void insert(T obj);
    T removeRoot();
}
