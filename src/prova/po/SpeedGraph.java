package prova.po;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class SpeedGraph<V,E extends GEdge> implements Algorithm<V,E>{
    private ArrayList<V> nodi;
    private ArrayList<E> archi;

    public SpeedGraph(){
        nodi=new ArrayList<>();
        archi=new ArrayList<>();
    }

    public SpeedGraph(ArrayList<V> nodi, ArrayList<E> archi){
        this.nodi=nodi;
        this.archi=archi;
    }

    @Override
    public boolean aciclico(Collection<E> v) {
        Iterator<E> it= archi.iterator();   //creo l'iteratore
        while (it.hasNext()){
            V sorg= (V) it.next().getSorgente();
            //capire come entrare e vedere il sorgente
        }
        return false;
    }

    @Override
    public boolean isconnected(Collection<V> v, Collection<E> a) {
        return false;
    }

    @Override
    //vado a vedere se il grado di tutti i vertici è uguale
    public boolean isregular(Collection<V> v) {
        ArrayList<Integer> arrayGradi= new ArrayList<Integer>();// creo array per tutti i gradi dei vertici
        Iterator<V> it= v.iterator();   //creo l'iteratore
        while (it.hasNext()){
            V vertice= (V) it.next();
            arrayGradi.add(degree(vertice));
        }
        if(arrayGradi.size()>0){    //guardo se la lunghezza dei gradi è > 0
            int gradoRif=arrayGradi.get(0); //prendo il grado del primo vertice e guardo se è uguale agli altri
            Iterator<Integer> iteratore =arrayGradi.iterator();
            while (iteratore.hasNext()){
                if (gradoRif != degree((V)iteratore.next())){
                    return false;
                }
            }
        }else{
            return false;
        }
        return true;
    }

    @Override
    public int[][] build_matrix(Collection<V> v, Collection<E> a) {
        int numeroVertici=v.size();
        int[][] matriceAdiacenza = new int[numeroVertici][numeroVertici]; //creo una matrice n*n dove n sono i numeri dei vertici

        for(int i =0; i<numeroVertici;i++){
            for(int j=0; j<numeroVertici;j++){
                //anche qui dovrei accedere alla sorgente e destinazione dell'arco
            }
        }

        return matriceAdiacenza;
    }
    @Override
    public boolean iscompleted(Collection<V> v) {
        int nVertici = v.size();
        for (int i = 0; i < nVertici; i++) {
            V nodo = nodi.get(i);
            for (int j = 0; j < nVertici; j++) {
                if (i != j) {
                    if (!isExistEdge(nodo, nodi.get(j))) {
                        return false;
                    }
                }
            }
        }
        return true;
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
        for (V aNodi : nodi) {
            if (isExistEdge(nodo, aNodi)) {
                removeEdge(getEdge(nodo, aNodi));
            }
            if (isExistEdge(aNodi, nodo)) {
                removeEdge(getEdge(aNodi, nodo));
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