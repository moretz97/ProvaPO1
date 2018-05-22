package prova.po;

import java.util.Set;

public interface Graph<V,E> {

//operazioni per nodi

    boolean addNode(V n);

    boolean deleteNode(V n);

    boolean searchNode(V n);

    Set<V> getNode(V data);

    void setNode(V oldVal, V newVal);

    int in_degree(V n);     //mi dice il numero di archi entranti

    int out_degree(V n);    //mi dice il numero di archi uscenti

    int degree(V n);        //mi da il grado del vertice(somma tra in_degree e out_degree)

    boolean isEmpty();      //mi dice se un grafo è vuoto


//operazioni per archi

    boolean addEdge(E n);

    boolean removeEdge(E n);

    E getEdge(V source, V destination);

    void setEdge(V source, V destination, E newVal);

    boolean isExistEdge(V source, V destination);

}