package prova.po;

import java.util.ArrayList;
import java.util.Collection;

public class SpeedGraph<V,E> implements Algorithm<V,E>{
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

    @Override
    public boolean aciclico(Collection<E> v) {
        return false;
    }

    @Override
    public boolean isconnected(Collection<V> v, Collection<E> a) {
        return false;
    }

    @Override
    public boolean isregular(Collection<V> v) {
        return false;
    }

    @Override
    public int[][] build_matrix(Collection<V> v) {
        return new int[0][];
    }

    @Override
    public boolean iscompleted(Collection<V> v, Collection<E> a) {
        return false;
    }

    @Override
    public Graph<V, E> findST(Collection<V> v, Collection<E> a) {
        return null;
    }

    @Override
    public Graph<V, E> findMST(Collection<V> v, Collection<E> a) {
        return null;
    }

    @Override
    public boolean addNode(V n) {
        if (!searchNode(n)){
            nodi.add(new GNode<>(n));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteNode(V n) {
        return false;
    }

    @Override
    public boolean searchNode(V n) {
        for (int i=0;i<nodi.size();i++){
            if(nodi.get(i).getData().equals(n)){
                return true;
            }
        }
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
    public int in_degree(V n) {
        return 0;
    }

    @Override
    public int out_degree(V n) {
        return 0;
    }

    @Override
    public int degree(V n) {
        return 0;
    }

    @Override
    public boolean isempty() {
        return false;
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