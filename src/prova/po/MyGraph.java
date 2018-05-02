package prova.po;

import java.util.ArrayList;
import java.util.Collection;

public class MyGraph<V,E> implements Graph<V,E>,Algorithm<V,E>{
    private ArrayList<GNode<V>> nodi;
    private ArrayList<GEdge<E,V>> archi;

    public MyGraph(){
        nodi=new ArrayList<GNode<V>>();
        archi=new ArrayList<GEdge<E,V>>();
    }

    public MyGraph(ArrayList<GNode<V>> nodi, ArrayList<GEdge<E,V>> archi){
        this.nodi=nodi;
        this.archi=archi;
    }

    @Override
    public boolean aciclico(Collection<E> v) {
        return false;
    }

    @Override
    public boolean addNode(V n) {
        return false;
    }

    @Override
    public boolean deleteNode(V n) {
        return false;
    }

    @Override
    public boolean searchNode(V n) {
        return false;
    }

    @Override
    public E getNode(V i) {
        return null;
    }

    @Override
    public void setNode(V oldVal, V newVal) {

    }

    @Override
    public boolean addEdge(E n) {
        return false;
    }

    @Override
    public boolean removeEdge(E n) {
        return false;
    }

    @Override
    public E getEdge(V source, V destination) {
        return null;
    }

    @Override
    public void setEdge(V source, V destination, E newVal) {

    }
}