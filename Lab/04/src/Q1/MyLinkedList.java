package Q1;

public class MyLinkedList <E>{
    Node<E> head;
    Node<E> tail;
    int size;

    public MyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public void addFirst(E e){
        if(head == null) {
            head = new Node<>(e);
            tail = head;
        } else {
            Node<E> newNode = new Node<>(e);
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addLast(E e){
        if(tail == null){
            head = new Node<>(e);
            tail = head;
        } else {
            Node<E> newNode = new Node<>(e);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void add(int index, E e){
        if(index < 0 || index > size) {
            System.out.println("Index " + index + " of bounds of size " + size);
            return;
        }
        if(index == 0) {
            addFirst(e);
        } else if(index == size) {
            addLast(e);
        } else {
            Node<E> newNode = new Node<>(e);
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            size++;
        }
    }

    public E removeFirst(){
        if(head == null) return null;
        else {
            E data = head.data;
            head = head.next;
            size--;
            return data;
        }
    }

    public E removeLast(){
        if(tail == null) return null;
        if(head == tail){
            E data = head.data;
            head = null;
            tail = null;
            size--;
            return data;
        } else {
            Node<E> current = head;
            while(current.next != tail) {
                current = current.next;
            }
            E data = tail.data;
            tail = current;
            tail.next = null;
            size--;
            return data;
        }
    }

    public E remove(int index){
        if(index < 0 || index >= size) {
            System.out.println("Index " + index + " of bounds of size " + size);
            return null;
        }
        if(index == 0) {
            return removeFirst();
        } else if(index == size - 1) {
            return removeLast();
        } else {
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            E data = current.next.data;
            current.next = current.next.next;
            size--;
            return data;
        }
    }

    public boolean contains(E e){
        Node<E> current = head;
        while(current != null){
            if(current.data.equals(e)) return true;
            current = current.next;
        }
        return false;
    }

    public E get(int index){
        if(index < 0 || index >= size){
            System.out.println("Index " + index + " of bounds of size " + size);
            return null;
        }
        Node<E> current = head;
        for(int i = 0 ; i < index ; i++){
            current = current.next;
        }
        return current.data;
    }

    public E getFirst(){
        if(head == null) return null;
        return head.data;
    }

    public E getLast(){
        if(tail == null) return null;
        return tail.data;
    }

    public int indexOf(E e){
        Node<E> current = head;
        for(int i = 0 ; i < size; i++){
            if(current.data.equals(e)) return i;
            current = current.next;
        }
        return -1;
    }

    public int lastIndexOf(E e){
        Node<E> current = head;
        int index = -1;
        for(int i = 0 ; i < size ; i++){
            if(current.data.equals(e)) index = i;
            current = current.next;
        }
        return index;
    }

    public E set(int index, E e){
        if(index < 0 || index >= size) {
            System.out.println("Index " + index + " of bounds of size " + size);
            return null;
        }
        Node<E> current = head;
        for(int i = 0 ; i < index ; i++){
            current = current.next;
        }
        E oldData = current.data;
        current.data = e;
        return oldData;
    }

    public void clear(){
        head = null;
        tail = null;
        size = 0;
    }

    public void print(){
        Node<E> current = head;
        while(current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public void reverse(){
        Node<E> prev = null;
        Node<E> current = head;
        Node<E> next = null;
        tail = head;
        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public E getMiddleValue(){
        if(head == null) return null;
        Node<E> slow = head;
        Node<E> fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }
}
