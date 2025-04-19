package Q1;

public class SNode <E> {
    E data;
    SNode<E> next;

    public SNode(){
        this.data = null;
        this.next = null;
    }

    public SNode(E e) {
        data = e;
        next = null;
    }
}
