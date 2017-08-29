package org.compsci.datastructures;

/**
 * Created by zaiyangli on 26/08/2017.
 */
public interface Array<T> extends  Collection<T> {
    T get(int index);
    void set(int index, T value);
}
