package Q3;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> S = new Stack<>();
        S.push(1);
        S.push(1);
        S.push(1);
        S.push(1);
        S.push(1);
        S.push(1);
        S.push(1);
        System.out.println(sumInStack(S));
        System.out.println(S.size());
    }

    public static int sumInStack(Stack<Integer> S){
        Stack<Integer> temp = new Stack<>();
        int sum = 0;
        while(!S.isEmpty()){
            int x = S.pop();
            sum += x;
            temp.push(x);
        } 
        while(!temp.isEmpty()) S.push(temp.pop());
        return sum;
        
    }
}
