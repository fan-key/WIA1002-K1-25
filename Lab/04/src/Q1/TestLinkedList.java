package Q1;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();
        list.addLast('a');
        list.addLast('b');
        list.addLast('c');
        list.addLast('d');
        list.addLast('e');
        
        list.print();

        list.reverse();

        System.out.println(list.size);

        System.out.println(list.getFirst());
        System.out.println(list.getLast());

        list.remove(2);

        System.out.println(list.indexOf('b') + " " + list.indexOf('c'));

        System.out.println(list.contains('c'));

        list.print();

        list.set(0, 'j');
        list.set(1, 'a');
        list.set(2, 'v');

        list.print();
        
    }
}
