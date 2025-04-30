package Q5;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int move = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Stack<Integer> s3 = new Stack<>();

        System.out.print("Enter tower height : ");
        int n = sc.nextInt();

        for(int i = n; i > 0 ; i--) s1.push(i);
        System.out.println("Initial : ");
        System.out.println("Tower 1 : " + s1.toString());
        System.out.println("Tower 2 : " + s2.toString());
        System.out.println("Tower 3 : " + s3.toString());

        long start = System.nanoTime();
        hanoi(n, s1, s2, s3);
        long end = System.nanoTime();

        System.out.println("After   : ");
        System.out.println("Tower 1 : " + s1.toString());
        System.out.println("Tower 2 : " + s2.toString());
        System.out.println("Tower 3 : " + s3.toString());
        System.out.println((double)(end-start)/1000000000 + " seconds");
        System.err.println(move + " moves");

    }

    public static void hanoi(int n, Stack<Integer> start, Stack<Integer> end, Stack<Integer> other ){
        if(n == 1) move(start, end);
        else{
            hanoi(n-1, start,other, end);
            move(start,end);
            hanoi(n-1, other, end, start);
        }
    }
    public static void move(Stack<Integer> start, Stack<Integer> end){
        end.push(start.pop());
        move++;
    }
}
