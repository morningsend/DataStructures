package org.compsci.datastructures;

/**
 * First In, Last Out
 */
public interface Stack<T> extends Collection{
    void push(T obj);
    T pop();
}
