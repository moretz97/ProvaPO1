package prova.po;

public interface Graph<V,E> {

//operazioni per nodi

    boolean addNode(V n);

    boolean deleteNode(V n);

    boolean searchNode(V n);

    GNode<V> getNode(V i);

    void setNode(V oldVal, V newVal);

    void setNode(GNode<V> old, V newVal);

//operazioni per archi

    boolean addEdge(GEdge<E,V> n);

    boolean removeEdge(GEdge<E,V> n);

    GEdge<E,V> getEdge(V source, V destination);

    void setEdge(V source, V destination, E newVal);

}
