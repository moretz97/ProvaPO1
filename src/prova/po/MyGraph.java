package prova.po;

import java.util.ArrayList;
import java.util.Collection;

public class MyGraph<V,E> implements Graph<V,E>,Algorithm{
    private ArrayList<GNode<V>> nodi;
    private ArrayList<GEdge<E,V>> archi;
}