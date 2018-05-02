package prova.po;

public interface Graph<V,E> {

//operazioni per nodi

    boolean addNode(V n);

    boolean deleteNode(V n);

    boolean searchNode(V n);

    E getNode(V i);

    void setNode(V oldVal, V newVal);

//operazioni per archi

    boolean addEdge(E n);

    boolean removeEdge(E n);

    E getEdge(V source, V destination);

    void setEdge(V source, V destination, E newVal);

}