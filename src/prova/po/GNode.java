package prova.po;

public class GNode<T> {
    private T data;

    public GNode(T data) {
        this.data = data;
    }

    public T getData(){
        return data;
    }

    @Override
    public String toString() {
        String stringa = new String();
        stringa=(data.toString());
        return stringa;
    }
}
