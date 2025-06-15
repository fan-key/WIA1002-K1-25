package Q1;

import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    public static void main(String[] args){
        int[] arr = {4,8,1,2,9,6,3,7};
        Queue<Integer> queue = new PriorityQueue<>();
        for(int i : arr) queue.add(i);
        System.out.println(queue.toString());
        queue.poll();
        System.out.println(queue.toString());
        Object[] array = queue.toArray();
        for(Object i : array) System.out.print(i);
        

    }
}