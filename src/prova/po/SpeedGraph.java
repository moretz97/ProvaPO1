package prova.po;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class SpeedGraph<V,E extends GEdge> implements Algorithm<V,E>{
    private ArrayList<V> nodi;
    private ArrayList<E> archi;

    private ArrayList<Boolean> visitati;

    public SpeedGraph(){
        nodi=new ArrayList<>();
        archi=new ArrayList<>();
        visitati=new ArrayList<>();
    }

    public SpeedGraph(ArrayList<V> nodi, ArrayList<E> archi){
        this.nodi=nodi;
        this.archi=archi;
    }

    @Override
    public String toString(){
        String matrice [][];
        matrice=this.build_matrixString();
        String stringa=new String();

        for(int i=-1;i<matrice[0].length;i++) {
            if (i>=0) {
                stringa = stringa + nodi.get(i) + " ";
            }else {
                stringa=stringa+"  ";
            }
            for (int j = 0; j < matrice[0].length; j++) {
                if (i==-1){
                    stringa=stringa+nodi.get(j)+" ";
                }else {
                    stringa = stringa + matrice[i][j] + " ";
                }
            }
            stringa = stringa + "\n";
        }
        return stringa;
    }

    public String[][] build_matrixString() {
        int numeroVertici=nodi.size();
        String[][] matriceAdiacenza = new String[numeroVertici][numeroVertici]; //creo una matrice n*n dove n sono i numeri dei vertici

        for(int i =0; i<numeroVertici;i++){
            for (int j = 0; j < numeroVertici; j++) {
                for (E arco : archi) {
                    String stringa;
                    stringa= arco.getWeigth().toString();
                    if (arco.getSorgente().equals(nodi.get(i))) {
                        if (arco.getDestinazione().equals(nodi.get(j))) {
                            matriceAdiacenza[i][j] = stringa;
                        } else {
                            if (matriceAdiacenza[i][j]!=stringa) {
                                matriceAdiacenza[i][j] = "*";
                            }
                        }
                    }
                }
            }
        }

        return matriceAdiacenza;
    }

    @Override
    public boolean aciclico() {
        int matriceAd[][]=build_matrix();
        visitati=new ArrayList<>();
        for (int i=0;i<nodi.size();++i){
            visitati.add(false);
        }

        return dfsAciclico(matriceAd,0);
    }


    private  boolean dfsAciclico(int adjacency_matrix[][], int node)
    {
        ArrayList<Integer> neighbours=findNeighbours(adjacency_matrix,node);
        visitati.set(node,true);
        for (int i = 0; i < neighbours.size(); i++) {
            Integer n=neighbours.get(i);
            if(!visitati.get(n))
            {
                dfsAciclico(adjacency_matrix,n);
            }
            else{
                return true;
            }
        }
        return false;
    }

    private ArrayList<Integer> findNeighbours(int[][] adjacency_matrix, int node) {

        ArrayList<Integer> neighbours=new ArrayList<>();
        for (int j = 0; j < adjacency_matrix[node].length; j++) {
            if(adjacency_matrix[node][j]==1){
                neighbours.add(j);
            }
        }

        return neighbours;
    }


    @Override
    public boolean isconnected() {
        return false;
    }

    @Override
    public boolean isregular(){
        ArrayList<Integer> arrayGradiTotale= new ArrayList<>();// creo array con grado totale di tutti i vertici
        ArrayList<Integer> arrayGradiIn= new ArrayList<>();//creo array con grado in entrata di tutti i vertici
        ArrayList<Integer> arrayGradiOut=new ArrayList<>();//creo array con grado in uscita di tutti i vertici

        Iterator<V> it= nodi.iterator();   //creo l'iteratore(che alla fine vale per tutti)

        while (it.hasNext()){
            V vertice= (V) it.next();
            arrayGradiTotale.add(degree(vertice));
            arrayGradiIn.add(in_degree(vertice));
            arrayGradiOut.add(out_degree(vertice));
        }

        boolean diverso=false;
        int i=0;
        int j=0;
        while(!diverso && i<arrayGradiTotale.size()){
            while (j<arrayGradiTotale.size()){
                if(arrayGradiTotale.get(i) != arrayGradiTotale.get(j) || arrayGradiIn.get(i) != arrayGradiIn.get(j) || arrayGradiOut.get(i) != arrayGradiOut.get(j)){
                    diverso=true;
                    System.out.println(arrayGradiTotale.get(i).toString()+"toti");
                    System.out.println(arrayGradiTotale.get(j).toString()+"totj");
                }
                j++;
            }
            i++;
        }
        return !diverso;
    }

    @Override
    public int[][] build_matrix() {
        int numeroVertici=nodi.size();
        int[][] matriceAdiacenza = new int[numeroVertici][numeroVertici]; //creo una matrice n*n dove n sono i numeri dei vertici

        for(int i =0; i<numeroVertici;i++){
            for (int j = 0; j < numeroVertici; j++) {
                for (E arco : archi) {
                    if (arco.getSorgente().equals(nodi.get(i))) {
                        if (arco.getDestinazione().equals(nodi.get(j))) {
                            matriceAdiacenza[i][j] = 1;
                        } else {
                            if (matriceAdiacenza[i][j]!=1) {
                                matriceAdiacenza[i][j] = 0;
                            }
                        }
                    }
                }
            }
        }

        return matriceAdiacenza;
    }

    @Override
    public boolean iscompleted() {
        int nVertici = nodi.size();
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
    public Graph<V, E> findST() {
        return null;
    }

    @Override
    public Graph<V, E> findMST() {
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
    public ArrayList<V> getAllNode() {
        return (ArrayList<V>) nodi;
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
            if (archi.get(i).getSorgente().equals(source)){
                if (archi.get(i).getDestinazione().equals(destination)){
                    return archi.get(i);
                }
            }
            i++;
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