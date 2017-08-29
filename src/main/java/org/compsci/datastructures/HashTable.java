package org.compsci.datastructures;

/**
 * Created by zaiyangli on 26/08/2017.
 */
public interface HashTable<Key, Value> {
    void add(Key key, Value value);
    void remove(Key key);
}
