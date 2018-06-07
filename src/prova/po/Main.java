package prova.po;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //creazione dello SpeedGraph
        SpeedGraph<GNode<Integer>,GEdge<Integer,Integer>> grafo = new SpeedGraph<>();

        //riempimento dei nodi sullo SpeedGraph creato
        for(int i=1; i<=5;i++){
            Integer elem= i;
            GNode<Integer> nodo = new GNode<>(elem);
            grafo.addNode(nodo);
        }
        //vado a crearmi un ArrayList dove mi salvo tutti nodi del grafo e li stampo
        ArrayList<GNode<Integer>> nodi=grafo.getAllNode();
        System.out.print("Nodi del grafo=");
        System.out.println(nodi.toString());

        //----------INSERIMENTO ARCHI NEL GRAFO-------------------------------------
        GEdge<Integer,Integer> arco= new GEdge<>(6,nodi.get(0),nodi.get(1));
        grafo.addEdge(arco);
        GEdge<Integer,Integer> arco1= new GEdge<>(6,nodi.get(1),nodi.get(2));
        grafo.addEdge(arco1);
        GEdge<Integer,Integer> arco2= new GEdge<>(6,nodi.get(2),nodi.get(3));
        grafo.addEdge(arco2);
        GEdge<Integer,Integer> arco3= new GEdge<>(6,nodi.get(3),nodi.get(4));
        grafo.addEdge(arco3);
        GEdge<Integer,Integer> arco4= new GEdge<>(6,nodi.get(0),nodi.get(4));
        grafo.addEdge(arco4);
        //---------------------------------------------------------------------------

        //---------------STAMPA DEL GRAFO--------------------------------------------
        System.out.println("\nGRAFO");
        System.out.println(grafo.toString());
        //---------------------------------------------------------------------------
        System.out.println("ACICLICO-->"+grafo.aciclico());
    }
}