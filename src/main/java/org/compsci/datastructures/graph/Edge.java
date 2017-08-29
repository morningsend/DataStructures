package org.compsci.datastructures.graph;

/**
 * Created by zaiyangli on 26/08/2017.
 */
public interface Edge<T> {
    int weight();
    Node<T> fromNode();
    Node<T> toNode();
}
