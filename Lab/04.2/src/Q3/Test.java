package Q3;

public class Test {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        list.addFirst(1);
        list.addLast(100);
        list.add(2, 2);

        list.iterateBackword();
        list.iterateFoward();

    }
}
