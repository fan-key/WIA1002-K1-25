package Q1;

public class Main {
    public static void main(String args[]){
        String[] fruit = {"Durian", "BlueBerry"};
        MyQueue<String> fruitQ = new MyQueue<>(fruit);
        fruitQ.enqueue("Apple");
        fruitQ.enqueue("Orange");
        fruitQ.enqueue("Grapes");
        fruitQ.enqueue("Cherry");
        System.out.println(fruitQ.getSize());
        
        fruitQ.dequeue();
        System.out.println(fruitQ.getElement(1));

        System.out.println(fruitQ.contains("Cherry"));
        System.out.println(fruitQ.contains("Durian"));
        System.out.println(fruitQ.toString());

    }
}
