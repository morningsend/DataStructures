package org.compsci.datastructures;

/**
 * Basic collection interface to support size and checking if empty
 */
public interface Collection<T> {
    int size();
    boolean isEmpty();
    T[] toJavaArray(Class<T> tClass);
}
