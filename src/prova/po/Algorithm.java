package prova.po;

import java.util.Collection;

public interface Algorithm<V,E> extends Graph<V,E> {

    boolean aciclico();

    boolean isconnected();   //mi dice se il grafo è connesso

    boolean isregular();     //mi dice se il grado dei vertici è uguale

    int[][] build_matrix();      //mi costruisce la matrice di adiacenza dove su ogni posizione ci può essere 0 se non c'è l'arco 1 altrimenti

    boolean iscompleted();      //guarda se il grafo è completo, cioè se presi 2 vertici esiste l'arco

    Graph<V,E> findST();        //mi restituisce l'albero di copertura

    Graph<V,E> findMST();       //mi restituisce l'albero di copertura minimo (Guardare algoritmo ASD e vedere se implementare metodi nuovi)


    //METODI DA CAPIRE SE FARE O MENO CON UN ALTRA LIBRERIA E NUOVE STRUTTURE PER NODI E ARCHI

    //Graph<V,E> kruskall_algorithm();
    //Graph<V,E> prim_algorithm();
    //Graph<V,E> dijkstra_algorithm();



}
