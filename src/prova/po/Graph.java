package prova.po;

import java.util.ArrayList;


public interface Graph<V,E> {

//operazioni per nodi

    boolean addNode(V n);

    boolean deleteNode(V n) throws NotFoundException;

    boolean searchNode(V n);

    ArrayList<V> getAllNode();

    void setNode(V oldVal, V newVal) throws NotFoundException;

    int in_degree(V n);     //mi dice il numero di archi entranti

    int out_degree(V n);    //mi dice il numero di archi uscenti

    int degree(V n);        //mi da il grado del vertice(somma tra in_degree e out_degree)

    boolean isEmpty();      //mi dice se un grafo è vuoto


//operazioni per archi

    boolean addEdge(E n);   //aggiunge l'arco passato

    boolean removeEdge(E n) throws NotFoundException; //rimuove dal grafo l'arco passato

    E getEdge(V source, V destination); // restituisce l'arco con sorgente e destinazione passate

    void setEdge(V source, V destination, E newVal) throws NotFoundException; // va a sostituire l'arco vecchio con quello nuovo passato

    boolean isExistEdge(V source, V destination);  // dice se esiste un arco tra la sorgente e destinazione passata

}