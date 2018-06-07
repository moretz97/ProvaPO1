package prova.po;

import javafx.beans.binding.Bindings;

public class GEdge<A, T> {
    private A weight;
    private GNode<T> sorgente;
    private GNode<T> destinazione;

    public GEdge(A weight, GNode<T> sorgente, GNode<T> destinazione) {
        this.weight = weight;
        this.sorgente = sorgente;
        this.destinazione = destinazione;
    }

    public GNode<T> getSorgente() {
        return sorgente;
    }

    public A getWeigth() {
        return weight;
    }

    public GNode<T> getDestinazione() {
        return destinazione;
    }

    @Override
    public String toString() {
        String stringa = new String();
        stringa= stringa+getSorgente()+getDestinazione();
        return stringa;
    }
}
