package prova.po;


import java.util.ArrayList;
import java.util.Iterator;

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
        visitati=new ArrayList<>();
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

    private void azzeraVisitati (){
        for(int i=0;i<nodi.size();i++){
            visitati.add(false);
        }
    }

    //---------------------------IMPLEMENTAZIONE OPERAZIONI GRAFO--------------------------
    /*
    * Costruisce la matrice di adiacenza con le stringhe mettendo il peso dell'arco se esso esiste altrimenti *
    * */
    private String[][] build_matrixString() {
        int numeroVertici=nodi.size();
        String[][] matriceAdiacenza = new String[numeroVertici][numeroVertici]; //creo una matrice n*n dove n sono i numeri dei vertici
        String stringa="*";

        for (int i=0;i<numeroVertici;i++){
            for (int j=0;j<numeroVertici;j++){
                matriceAdiacenza[i][j]="";
            }
        }
        for(int i =0; i<numeroVertici;i++){
            for (int j = 0; j < numeroVertici; j++) {
                for (E arco : archi) {
                    if (arco.getSorgente().equals(nodi.get(i))) {
                        if (arco.getDestinazione().equals(nodi.get(j))) {
                            stringa= arco.getWeigth().toString();
                            matriceAdiacenza[i][j] = stringa;
                        } else {
                            if (!matriceAdiacenza[i][j].equals(stringa)) {
                                matriceAdiacenza[i][j] = "*";
                            }
                        }
                    }
                }
            }
        }
        return matriceAdiacenza;
    }

    /*
    * Va a verificare se il grafo in questione è aciclico. Se lo è allora restituisce true altrimenti false
    * */
    @Override
    public boolean aciclico() {
        int matriceAd[][]=build_matrix();
        azzeraVisitati();
        boolean ris=dfsAciclico(matriceAd,0);
        visitati.clear();
        return ris;
    }

    /*
    * Mi va ad effettuare la visita dfs sul grafo
    * */
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

    /*
    * Mi va restituisce un ArrayList con tutti i vicini del nodo passato
    * */
    private ArrayList<Integer> findNeighbours(int[][] adjacency_matrix, int node) {

        ArrayList<Integer> neighbours=new ArrayList<>();
        for (int j = 0; j < adjacency_matrix[node].length; j++) {
            if(adjacency_matrix[node][j]==1){
                neighbours.add(j);
            }
        }

        return neighbours;
    }

    /*
    * Mi va a dire se il grafo in questione è connesso
    * */
    @Override
    public boolean isconnected() {
        return this.iscompleted();
    }

    /*
    * Mi dice se un grafo è regolare cioè se tutti i gradi dei vertici sono uguali.
    * Essendo nel nostro caso un grafo orientato devo vedere anche che siano uguali anche i gradi dei vertici in entrata e in uscita
    * */
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
                }
                j++;
            }
            i++;
        }
        return !diverso;
    }

    /*
    * Mi va a costruire la matrice di adiacenza del grafo in questione (matrice di interi dove metto 0 se non c'è l'arco e 1 altrimenti)
    * */
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

    /*
    * Mi va a dire se il grafo è completo, cioè se presi 2 vertici esiste un arco
    * */
    @Override
    public boolean iscompleted() {
        int nVertici = nodi.size();
        for (int i = 0; i < nVertici; i++) {
            V nodo = nodi.get(i);
            if(out_degree(nodo) != nVertici-1){
                return false;
            }
        }
        return true;
    }

    //---------------------IMPLEMENTAZIONE OPERAZIONI NODI--------------------------------
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
    public boolean deleteNode(V n) throws NotFoundException {
        int i=0;
        V nodo;
        while (!nodi.get(i).equals(n)){
            i++;
            if(nodi.size() <= i) {
                throw new NotFoundException();
            }
        }

            nodo=nodi.get(i);
            deleteEdgeWithThisNode(nodo);
            nodi.remove(i);
            return true;


    }


    @Override
    public boolean searchNode(V n){
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
    public void setNode(V oldVal, V newVal) throws NotFoundException {
        int i=0;
        while(!nodi.get(i).equals(oldVal)){
            i++;
            if(nodi.size() <= i) {
                throw new NotFoundException();
            }
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

    //--------------------------IMPLEMENTAZIONE OPERAZIONI ARCHI--------------------------
    private void deleteEdgeWithThisNode(V nodo) throws NotFoundException {
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
    public boolean addEdge(E n) {
        archi.add(n);
        return true;
    }

    @Override
    public boolean removeEdge(E n) throws NotFoundException {
        int i=0;
        while (!archi.get(i).equals(n)){
            i++;
            if(archi.size() <= i) {
                throw new NotFoundException();
            }
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
    public void setEdge(V source, V destination, E newVal) throws NotFoundException {
        int i=0;
        while(!archi.get(i).equals(getEdge(source,destination))){
            i++;
            if(archi.size() <= i) {
                throw new NotFoundException();
            }
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