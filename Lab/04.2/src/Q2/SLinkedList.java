package Q2;

public class SLinkedList<E> {
    Node<E> head;
    Node<E> tail;
    int size;

    public SLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    public void add(E e){
        Node<E> newNode = new Node<>(e);
        if(head == null){
            head = newNode;
            tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size ++;
    }

    public void removeElement(E e){
        if(head == null) return;
        if(head.data.equals(e)){
            head = head.next;
            size--;
            return;
        }
        Node<E> curr = head;
        while(curr.next != null){
            if(curr.next.data.equals(e)){
                curr.next = curr.next.next;
                size--;
                return;
            }
            curr = curr.next;
        }
    }

    public void printList(){
        Node<E> curr = head;
        while(curr != null){
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public int getSize(){
        return size;
    }

    public boolean contains(E e){
        Node<E> curr = head;
        while(curr != null){
            if(curr.data.equals(e)) return true;
            curr = curr.next;
        }
        return false;
    }

    public void replace(E old, E newValue){
        if(head == null) return;
        Node<E> newNode = new Node<>(newValue);
        if(head.data.equals(old)){
            newNode.next = head.next;
            head = newNode;
            return;
        }
        
        Node<E> curr = head;
        while(curr.next != null){
            if(curr.next.data.equals(old)){
                newNode.next = curr.next.next;
                curr.next = newNode;
                return;
            }
            curr = curr.next;
        }
        
    }
}
