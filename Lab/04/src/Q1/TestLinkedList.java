package Q1;

import javax.swing.plaf.synth.SynthSplitPaneUI;

public class TestLinkedList {
    public static void main(String[] args) {
        MyLinkedList<Character> list = new MyLinkedList<>();

        list.addLast('a');
        list.addLast('b');
        list.addLast('c');
        list.addLast('d');
        list.addLast('e');
        
        System.out.print("normal list: ");
        list.print();
        System.out.print("reverse list: ");
        list.reverse();
        list.print();

        System.out.println("list size: " + list.size);

        System.out.println("first element: " + list.getFirst());
        System.out.println("last element: " + list.getLast());

        System.out.println("remove 3rd element from list: " + list.remove(2));
        System.out.print("current list: ");
        list.print();

        System.out.println("index of 'b' : " + list.indexOf('b'));
        System.out.println("index of 'c' : " + list.indexOf('c'));

        System.out.println("contain 'c' : "+ list.contains('c'));
        System.out.print("current list : ");
        list.print();

        list.set(0, 'j');
        list.set(1, 'a');
        list.set(2, 'v');

        System.out.println("set 0th element to 'j' and 1st element to 'a' and 2nd element to 'v' ");
        System.out.print("current list : ");
        list.print();

        System.out.println("middle value of list: " + list.getMiddleValue());



        
    }
}
