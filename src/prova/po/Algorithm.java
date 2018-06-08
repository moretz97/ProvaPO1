package prova.po;

import java.util.Collection;

public interface Algorithm<V,E> extends Graph<V,E> {

    boolean aciclico();

    boolean isconnected();   //mi dice se il grafo è connesso

    boolean isregular();     //mi dice se il grado dei vertici è uguale

    int[][] build_matrix();      //mi costruisce la matrice di adiacenza dove su ogni posizione ci può essere 0 se non c'è l'arco 1 altrimenti

    boolean iscompleted();      //guarda se il grafo è completo, cioè se presi 2 vertici esiste l'arco


}
