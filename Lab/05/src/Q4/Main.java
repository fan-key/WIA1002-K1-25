package Q4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String line = "racecar";
        System.out.println(isPalindrome(line));
    }

    public static boolean isPalindrome(String line){
        Stack<Character> stack = new Stack<>();
        for(char ch : line.toCharArray()) stack.push(ch);
        for(int i = 0 ; i < line.length() ; i ++) if(stack.pop() != line.charAt(i)) return false;
        return true;
    }
}
