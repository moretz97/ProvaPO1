package prova.po;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class SpeedGraph<V,E> implements Algorithm<V,E>{
    private ArrayList<V> nodi;
    private ArrayList<E> archi;

    public SpeedGraph(){
        nodi=new ArrayList<V>();
        archi=new ArrayList<E>();
    }

    public SpeedGraph(ArrayList<V> nodi, ArrayList<E> archi){
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
            nodi.add(n);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean deleteNode(V n) {
        int i=0;
        V nodo;
        while (nodi.get(i).equals(n)){
            i++;
        }
        nodo=nodi.get(i);
        deleteEdgeWithThisNode(nodo);
        nodi.remove(i);
        return true;
    }

    private void deleteEdgeWithThisNode(V nodo) {
        for (int i=0; i<nodi.size();++i){
            if (isExistEdge(nodo,nodi.get(i))){
                removeEdge(getEdge(nodo,nodi.get(i)));
            }
            if (isExistEdge(nodi.get(i),nodo)){
                removeEdge(getEdge(nodi.get(i),nodo));
            }
        }
    }

    @Override
    public boolean searchNode(V n) {
        for (V aNodi : nodi) {
            if (aNodi.equals(n)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Set<V> getNode(V i) {
        return (Set<V>) nodi;
    }

    @Override
    public void setNode(V oldVal, V newVal) {
        int i=0;
        while(!nodi.get(i).equals(oldVal)){
            i++;
        }
        nodi.set(i,newVal);
    }

    @Override
    public int in_degree(V n) {
        int degree=0;
        for (V aNodi : nodi) {
            if (isExistEdge(aNodi, n)) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public int out_degree(V n) {
        int degree=0;
        for (V aNodi : nodi) {
            if (isExistEdge(n, aNodi)) {
                degree++;
            }
        }
        return degree;
    }

    @Override
    public int degree(V n) {
        return in_degree(n)+out_degree(n);
    }

    @Override
    public boolean isEmpty() {
        return nodi.isEmpty();
    }

    @Override
    public boolean addEdge(E n) {
        archi.add(n);
        return true;
    }

    @Override
    public boolean removeEdge(E n) {
        int i=0;
        while (!archi.get(i).equals(n)){
            i++;
        }
        archi.remove(i);
        return true;
    }

    @Override
    public E getEdge(V source, V destination) {
        int i=0;
        while (i<archi.size()){
            if (archi.get(i).equals(source)){
                if (archi.get(i).equals(destination)){
                    return archi.get(i);
                }
            }
        }
        return null;
    }

    @Override
    public void setEdge(V source, V destination, E newVal) {
        int i=0;
        while(!archi.get(i).equals(getEdge(source,destination))){
            i++;
        }
        archi.set(i,newVal);
    }

    @Override
    public boolean isExistEdge(V source, V destination) {
        for (E anArchi : archi) {
            if (anArchi.equals(getEdge(source, destination))) {
                return true;
            }
        }
        return false;
    }
}