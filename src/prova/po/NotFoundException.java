package prova.po;

public class NotFoundException extends Exception {
    @Override
    public String toString() {
        String stringa="Elemento non esistente!\n";
        return stringa+super.toString();
    }
}
