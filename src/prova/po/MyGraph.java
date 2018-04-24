package prova.po;

public class MyGraph<V,E> implements Graph<V,E>{
    @Override
    public boolean aggiungiNode(V n) {
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
    public boolean addEdge(GEdge<E, V> n) {
        return false;
    }

    @Override
    public boolean removeEdge(GEdge<E, V> n) {
        return false;
    }
}
