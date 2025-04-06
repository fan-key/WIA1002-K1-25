package Q1;

public class ArrayBagDemo {
    public static void main(String[] args) {
        ArrayBag<String> bag1 = new ArrayBag<>();
        ArrayBag<String> bag2 = new ArrayBag<>();

        String[] contentsOfBag1 = {"A", "A", "B", "A", "C", "A"};
        String[] contentsOfBag2 = {"A", "B", "A", "C", "B", "C", "D", "another String"};

        System.out.println("Bag 1: ");
        testAdd(bag1, contentsOfBag1);
        System.out.print("Adding ");
        for(String s : contentsOfBag1){
            System.out.print(s + " ");
        }
        System.out.println("\nThe bag contains " + bag1.getCurrentSize() + " string(s), as follows: ");
        displayBag(bag1);
        System.out.println();

        System.out.println("Bag 2: ");
        testAdd(bag2, contentsOfBag2);
        System.out.print("Adding ");
        for(String s : contentsOfBag2){
            System.out.print(s + " ");
        }
        System.out.println("\nThe bag contains " + bag2.getCurrentSize() + " string(s), as follows: ");
        displayBag(bag2);
        System.out.println();

        System.out.println("Bag 3, test the method union of bag1 and bag2: ");
        ArrayBag<String> bag3 =  (ArrayBag<String>) bag1.union(bag2);
        System.out.println("The bag contains " + bag3.getCurrentSize() + " string(s), as follows: ");
        displayBag(bag3);
        System.out.println();

        System.out.println("Bag 4, test the method intersection of bag1 and bag2: ");
        ArrayBag<String> bag4 =  (ArrayBag<String>) bag1.intersection(bag2);
        System.out.println("The bag contains " + bag4.getCurrentSize() + " string(s), as follows: ");
        displayBag(bag4);
        System.out.println();

        System.out.println("Bag 5, test the method difference of bag1 and bag2: ");
        ArrayBag<String> bag5 =  (ArrayBag<String>) bag1.difference(bag2);
        System.out.println("The bag contains " + bag5.getCurrentSize() + " string(s), as follows: ");
        displayBag(bag5);
        
    }

    private static void testAdd(BagInterface<String> aBag, String[] content){
        for(String s : content){
            aBag.add(s);
        }
    }

    private static void displayBag(BagInterface<String> aBag){
        for(Object s : aBag.toArray()){
            System.out.print(s + " ");
        }
        System.out.println();
    }
    

}
