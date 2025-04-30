package Q1;

import java.util.LinkedList;

public class MyQueue <E>{
    private LinkedList<E> queue = new LinkedList<>();

    public MyQueue(E[] e){
        for(E element : e) queue.addLast(element);
    }

    public MyQueue(){
    }

    public void enqueue(E e){
        queue.addLast(e);
    }

    public E dequeue(){
        return queue.removeFirst();
    }

    public E getElement(int i){
        return queue.get(i);
    }

    public E peek(){
        return queue.peek();
    }

    public int getSize(){
        return queue.size();
    }

    public boolean contains(E e){
        return queue.contains(e);
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    @Override
    public String toString(){
        return queue.toString();
    }


}
