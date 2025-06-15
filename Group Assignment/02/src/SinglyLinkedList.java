public class SinglyLinkedList {
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
            this.next = null;
        }

    }
    private Node head;
    private int size=0;
    public void addFirst(String msg) {
    Node newNode = new Node(msg);
    newNode.next = head;
    head = newNode;
    size++;
    }
    public void addLast(String msg) {
        Node newNode = new Node(msg);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void removeFirst() {
        if (head != null) {
        }
        head = head.next;
        size--;
    }
    public void print(){
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    public int getSize() {
        return size;
    }
}