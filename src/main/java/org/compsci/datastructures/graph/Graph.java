package org.compsci.datastructures.graph;

import java.util.Set;

/**
 * Created by zaiyangli on 26/08/2017.
 */
public interface Graph<T> {
    Set<Node<T>> getNodes();
    Set<Edge<T>> getEdges();
}
