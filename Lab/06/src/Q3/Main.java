package Q3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static Queue<Integer> shareQueue = new LinkedList<>();
    static Queue<Integer> priceQueue = new LinkedList<>();
    static int gain = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = "1";

        while(true){
            System.out.println("Enter");
            input = sc.nextLine();
            if(input.equals("")) return;
            addToQueue(input);
            System.out.println(shareQueue.toString());
            System.out.println(priceQueue.toString());
        }

        
    }

    public static void addToQueue(String input){
        String[] parts = input.split(" ");
        int share = Integer.parseInt(parts[1]);
        int price = Integer.parseInt(parts[4].replace("$", ""));
        shareQueue.offer(share);
        priceQueue.offer(price);
    }

    public static void calculate(String input){
        String[] parts = input.split(" ");
        int sell = Integer.parseInt(parts[1]);
        int priceSell = Integer.parseInt(parts[4].replace("$", ""));

        while(sell > 0 && !shareQueue.isEmpty()){
            int 

        }
    }
}
