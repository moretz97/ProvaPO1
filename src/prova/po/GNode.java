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

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof GNode) {
            return ((GNode) obj).data.equals(this.data);
        }else{
            return false;
        }
    }
}
