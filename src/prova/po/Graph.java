package prova.po;

public interface Graph<V,E> {

//operazioni per nodi

    boolean addNode(V);

    boolean deleteNode(V);

    GNode<V> searchNode(V);

//operazioni per archi

    boolean addEdge(GEdge<E,V>);

    boolean removeEdge(GEdge<E,V>);

}
