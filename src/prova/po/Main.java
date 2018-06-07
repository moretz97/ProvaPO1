package prova.po;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        SpeedGraph<GNode<Integer>,GEdge<Integer,Integer>> grafo = new SpeedGraph<>(); //creazione dello SpeedGraph

        for(int i=1; i<=5;i++){
            Integer elem= i;
            GNode<Integer> nodo = new GNode<>(elem);
            grafo.addNode(nodo);
        }
        ArrayList<GNode<Integer>> nodi=grafo.getAllNode();

        System.out.println(nodi.toString());

        GEdge<Integer,Integer> arco= new GEdge<>(6,nodi.get(0),nodi.get(1));
        grafo.addEdge(arco);

        int matrice [][];
        matrice=grafo.build_matrix();

        System.out.println("GRAFO="+grafo.toString());

        for(int i=0;i<matrice[0].length;i++){
            for (int j=0;j<matrice[0].length;j++){
                System.out.print(matrice[i][j]+" ");
            }
            System.out.println();
        }

    }
}