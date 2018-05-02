package prova.po;

import java.util.ArrayList;
import java.util.Collection;

public class SpeedGraph<V,E> {
    private ArrayList<GNode<V>> nodi;
    private ArrayList<GEdge<E,V>> archi;

    public SpeedGraph(){
        nodi=new ArrayList<GNode<V>>();
        archi=new ArrayList<GEdge<E,V>>();
    }

    public SpeedGraph(ArrayList<GNode<V>> nodi, ArrayList<GEdge<E,V>> archi){
        this.nodi=nodi;
        this.archi=archi;
    }
}