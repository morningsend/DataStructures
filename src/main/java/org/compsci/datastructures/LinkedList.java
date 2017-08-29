package org.compsci.datastructures;

/**
 * Created by zaiyangli on 26/08/2017.
 */
public interface LinkedList<T> extends Collection<T>{
    /**
     * Add obj to beginning of list
     * @param obj
     */
    void insert(T obj);

    /**
     * Remove obj from list
     * @param obj
     */
    void delete(T obj);

    /**
     * Add obj to end of list.
     * @param obj
     */
    void append(T obj);
}
