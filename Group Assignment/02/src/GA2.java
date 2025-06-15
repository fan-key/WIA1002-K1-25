import java.util.Stack;

public class GA2 {
    public static void main(String[] args) {
        DoublyLinkedListWithCursor list = new DoublyLinkedListWithCursor();
        System.out.println("Student 4 DEMO : ");
        list.insertAtCursor("Hello");
        list.insertAtCursor("World");
        list.insertAtCursor("This");
        list.moveLeft();
        list.insertAtCursor("is");
        list.print();


        System.out.println("\nStudent 3 DEMO : ");
        SinglyLinkedList singlyList = new SinglyLinkedList();
        singlyList.addFirst("Hello");
        singlyList.addLast("World");
        singlyList.addFirst("This");
        singlyList.print();
        
        System.out.println("\nStudent 2 DEMO : ");
        UndoRedoManager undoRedoManager = new UndoRedoManager();
        undoRedoManager.perform("add:Hello");
        undoRedoManager.perform("add:World");
        undoRedoManager.perform("add:This");
        undoRedoManager.perform("remove:That");

        undoRedoManager.printStacks();
        System.out.println("Undo: " + undoRedoManager.undo());
        undoRedoManager.printStacks();
        System.out.println("Redo: " + undoRedoManager.redo());
        undoRedoManager.printStacks();

    }
}

//Edlan Nabil - Undo/Redo with Stack
class UndoRedoManager{
    Stack<String> undo = new Stack<>();
    Stack<String> redo = new Stack<>();
    
    void perform(String action){
        String[] perform = action.split(":");
        if(perform.length>=2){
            String command = perform[0];
            String value = perform[1];
            System.out.println(command + ":"+value);
        }
        undo.push(action);//save in undo since redo only available after undo-ing action
        redo.clear();
    }
    String undo(){
        if(undo.isEmpty())
            return "cannot undo";
        String undoaction = undo.pop();
        redo.push(undoaction);
            return undoaction;
    }
    String redo(){
        if(redo.isEmpty())
            return "cannot redo";
        String redoaction = redo.pop();
        undo.push(redoaction);
            return redoaction;
    }
    void printStacks(){
        System.out.println("Undo: "+undo);
        System.out.println("Redo: "+redo);
    }
}

class SinglyLinkedList {
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

class DoublyLinkedListWithCursor {
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
