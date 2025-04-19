package Q3;

public class DoublyLinkedList<E> {
    int size;
    Node<E> head;
    Node<E> tail;

    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        size = 0;
    }

    public void addFirst(E element){
        Node<E> temp = new Node<>(element,head,null);
        if(head != null) head.prev = temp;
        head = temp;
        if(tail == null) tail = temp;
        size ++;
    }

    public void addLast(E element){
        Node<E> temp = new Node<>(element,null,tail);
        if(tail != null) tail.next = temp;
        tail = temp;
        if(head == null) head = temp;
        size ++;
    }

    public void add(int index, E element){
        if(index < 0 || index > size){
            System.out.println("index out of bound");
            return;
        }
        if(index == 0) addFirst(element);
        else if(index == size) addLast(element);
        else{
            Node<E> temp = head;
            for(int i = 0; i < index ; i++){
                temp = temp.next;
            }
            Node<E> insert = new Node<>(element, temp, temp.prev);
            temp.prev.next = insert;
            temp.prev = insert;
            size++;
        }
        


    }
    
    public void iterateFoward(){
        Node<E> temp = head;
        while(temp != null){
            System.out.print(temp.element + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void iterateBackword(){
        Node<E> temp = tail;
        while(temp != null){
            System.out.print(temp.element + " ");
            temp = temp.prev;
        }
        System.out.println( );
    }

    public E removeFirst(){
        if(size == 0) return null;
        Node<E> temp = head;
        head = head.next;
        head.prev = null;
        size --;
        return temp.element;
    }

    public E removeLast(){
        if(size == 0) return null;
        Node<E> temp = tail;
        tail = tail.prev;
        tail.next = null;
        size --;
        return temp.element;
    }

    public E remove(int index){
        E element = null;
        if(index < 0 || index > size) return null;
        if(index == 0) removeFirst();
        else if(index == size-1) removeLast();
        else{
            Node<E> temp = head;
            for(int i = 0; i < index ; i++) temp = temp.next;

            element = temp.element;
            temp.next.prev = temp.prev;
            temp.prev.next = temp.next;
            temp.next = null;
            temp.prev = null;
            size --;
            
        }
        return element;
    }

    public void clear(){
        Node<E> temp = head;
        while(head != null){
            temp = head.next;
            head.prev = head.next = null;
            head = temp;
        }
        temp = null;
        tail.prev = tail.next = null;
        size = 0;
    }
}
