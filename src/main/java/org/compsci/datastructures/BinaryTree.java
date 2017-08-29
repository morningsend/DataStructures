package org.compsci.datastructures;

/**
 * Created by zaiyangli on 26/08/2017.
 */
public interface BinaryTree<T> extends Collection<T> {
    void insert(T obj);
    void delete(T obj);
    boolean find(T obj);
}
