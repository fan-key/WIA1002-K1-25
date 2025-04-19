package Q3;

public class Node<E> {
    E element;
    Node<E> prev;
    Node<E> next;
    
    public Node(E element){
        this.element = element;
        this.prev = null;
        this.next = null;
    }

    public Node(E element, Node<E> next, Node<E> prev){
        this.element = element;
        this.next = next;
        this.prev = prev;
    }
}
