package Q1;

public class SList<E> {
    SNode<E> head;
    SNode<E> tail;
    int size;

    public SList(){
        head = null;
        tail = null;
        size = 0;   
    }

    public void appendEnd(E e){
        SNode<E> newNode = new SNode<>(e);
        if(head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public E removeInitial(){
        if(head == null) return null;
        E data = head.data;
        head = head.next;
        size--;
        return data;
    }

    public boolean contains(E e){
        if(head == null) return false;
        SNode<E> curr = head;
        while(curr != null){
            if(curr.data.equals(e)) return true;
            curr = curr.next;
        }
        return false;
    }

    public void clear(){
        head = null;
        tail = null;;
        size = 0;
    }

    public void display(){
        SNode<E> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

}
