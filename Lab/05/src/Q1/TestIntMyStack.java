package Q1;

import java.util.Scanner;

public class TestIntMyStack {
    public static void main(String[] args) {
        MyStack<Integer> stack = new MyStack<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter num : ");
        int num = sc.nextInt();

        for(int i = 1 ; i <= num ; i++) stack.push(i);

        System.out.println("Stack size : " + stack.getSize());
        while(!stack.isEmpty()) System.out.print(stack.pop() + " ");
        
        sc.close();
    }
}
