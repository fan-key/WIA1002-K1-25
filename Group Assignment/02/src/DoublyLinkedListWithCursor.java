public class DoublyLinkedListWithCursor {
    static class Node {
        String data;
        Node next;
        Node prev;

        public Node(String data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    Node cursor;
    int size;

    public DoublyLinkedListWithCursor() {
        this.head = null;
        this.tail = null;
        this.cursor = null;
        this.size = 0;
    }



    public void insertAtCursor(String msg){
        Node newNode = new Node(msg);

        if(head == null) head = tail = cursor = newNode;

        else if(cursor == null){
            tail.next = newNode;
            newNode.prev = tail;
            tail = cursor = newNode;

        } else{

            newNode.prev = cursor;
            newNode.next = cursor.next;

            if (cursor.next != null) cursor.next.prev = newNode;
            else tail = newNode; 
    
            cursor.next = newNode;
            cursor = newNode;
        }
        size++;
    }

    public void moveLeft(){
        if (cursor != null) {
            cursor = cursor.prev;
        }
    }

    public void moveRight(){
        if (cursor != null) {
            cursor = cursor.next;
        }
    }

    public void print(){
        Node current = head;
        while (current != null) {
            if(current == cursor) {
                System.out.print("[" + current.data + "] " + "<-> ");
            } else {
                System.out.print(current.data + " <-> ");
            }
            current = current.next;
        }
        System.out.println(" null");
    }
}
