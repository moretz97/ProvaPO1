package prova.po;

public interface Graph<V,E> {

//operazioni per nodi

    boolean aggiungiNode(V n);

    boolean deleteNode(V n);

    boolean searchNode(V n);

//operazioni per archi

    boolean addEdge(GEdge<E,V> n);

    boolean removeEdge(GEdge<E,V> n);

}
