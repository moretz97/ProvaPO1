package prova.po;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        //creazione dello SpeedGraph
        SpeedGraph<GNode<Integer>,GEdge<Integer,Integer>> grafo = new SpeedGraph<>();
        SpeedGraph<GNode<Integer>,GEdge<Integer,Integer>> grafo2 = new SpeedGraph<>();
        //riempimento dei nodi sullo SpeedGraph creato
        for(int i=1; i<=5;i++){
            Integer elem= i;
            GNode<Integer> nodo = new GNode<>(elem);
            grafo.addNode(nodo);
        }
        GNode<Integer> nodo1 = new GNode<>(1);
        GNode<Integer> nodo2 = new GNode<>(2);
        GNode<Integer> nodo3 = new GNode<>(3);
        grafo2.addNode(nodo1);
        grafo2.addNode(nodo2);
        grafo2.addNode(nodo3);
        //GEdge<Integer,Integer> arco01= new GEdge<>(6,nodo1,nodo2);
        //grafo2.addEdge(arco01);
        GEdge<Integer,Integer> arco02= new GEdge<>(6,nodo2,nodo1);
        grafo2.addEdge(arco02);
        GEdge<Integer,Integer> arco03= new GEdge<>(6,nodo2,nodo3);
        grafo2.addEdge(arco03);
        GEdge<Integer,Integer> arco04= new GEdge<>(6,nodo3,nodo2);
        grafo2.addEdge(arco04);
        GEdge<Integer,Integer> arco05= new GEdge<>(6,nodo1,nodo3);
        grafo2.addEdge(arco05);
        //GEdge<Integer,Integer> arco06= new GEdge<>(6,nodo3,nodo1);
        //grafo2.addEdge(arco06);

        System.out.println("GRAFO2");
        System.out.println(grafo2);
        System.out.println("COMPLETO-->"+grafo2.iscompleted());
        System.out.println("ACICLICO-->"+grafo2.aciclico());
        System.out.println("CONNESSO-->"+grafo2.isconnected());

        //vado a crearmi un ArrayList dove mi salvo tutti nodi del grafo e li stampo
        ArrayList<GNode<Integer>> nodi=grafo.getAllNode();
        System.out.print("Nodi del grafo=");
        System.out.println(nodi.toString());

        //----------------INSERIMENTO ARCHI NEL GRAFO-------------------------------
        GEdge<Integer,Integer> arco= new GEdge<>(6,nodi.get(0),nodi.get(1));
        grafo.addEdge(arco);
        GEdge<Integer,Integer> arco1= new GEdge<>(6,nodi.get(1),nodi.get(2));
        grafo.addEdge(arco1);
        GEdge<Integer,Integer> arco2= new GEdge<>(6,nodi.get(2),nodi.get(3));
        grafo.addEdge(arco2);
        GEdge<Integer,Integer> arco3= new GEdge<>(6,nodi.get(3),nodi.get(4));
        grafo.addEdge(arco3);
        GEdge<Integer,Integer> arco4= new GEdge<>(6,nodi.get(4),nodi.get(0));
        grafo.addEdge(arco4);
        //---------------------------------------------------------------------------

        //---------------STAMPA DEL GRAFO--------------------------------------------
        System.out.println("\nGRAFO");
        System.out.println(grafo);
        //---------------------------------------------------------------------------
        //System.out.println("ACICLICO-->"+grafo.aciclico());
        System.out.println("REGOLARE-->"+grafo.isregular());
        //GNode<Integer> nodo1 = new GNode<>(1);
        //System.out.println(grafo.out_degree(nodo1));
        System.out.println("COMPLETO-->"+grafo.iscompleted());
        //GNode<Integer> nodo1 = new GNode<>(1);
        //GNode<Integer> nodo2 = new GNode<>(2);
        //GEdge<Integer,Integer> arcoProva= grafo.getEdge(nodo1,nodo2);
        //System.out.println("ARCO-->"+arcoProva.toString());
    }
}