package prova.po;

import java.util.Collection;

public interface Algorithm<V,E> extends Graph<V,E> {

    boolean aciclico(Collection<E> v);

    boolean isconnected(Collection<V> v,Collection<E> a);   //mi dice se il grafo è connesso

    boolean isregular(Collection<V> v);     //mi dice se il grado dei vertici è uguale

    int[][] build_matrix(Collection<V> v,Collection<E> a);      //mi costruisce la matrice di adiacenza dove su ogni posizione ci può essere 0 se non c'è l'arco 1 altrimenti

    boolean iscompleted(Collection<V> v);      //guarda se il grafo è completo, cioè se presi 2 vertici esiste l'arco

    Graph<V,E> findST(Collection<V> v, Collection<E> a);        //mi restituisce l'albero di copertura

    Graph<V,E> findMST(Collection<V> v, Collection<E> a);       //mi restituisce l'albero di copertura minimo (Guardare algoritmo ASD e vedere se implementare metodi nuovi)


    //METODI DA CAPIRE SE FARE O MENO CON UN ALTRA LIBRERIA E NUOVE STRUTTURE PER NODI E ARCHI

    //Graph<V,E> kruskall_algorithm();
    //Graph<V,E> prim_algorithm();
    //Graph<V,E> dijkstra_algorithm();



}
