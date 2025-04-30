package Q2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your word : ");
        String line = sc.nextLine();
        System.out.println(checkIsPalindrome(line));
    }

    public static boolean checkIsPalindrome(String line){
        Queue<Character> queue = new LinkedList<>();    
        for(char c : line.toCharArray()) queue.offer(c);
        for(int i = line.length()-1 ; i >= 0 ; i--){
            if(line.toCharArray()[i] == queue.remove()) continue;
            else return false;
        }
        return true;
    }
}
