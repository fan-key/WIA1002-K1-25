package Q1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ReadMyLetter_matrixNum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);    
        String fileName = "src/Q1/ArfanZamri_23002546.txt";
        int choice = 0; 
        do{
            System.out.println("\n1. Read File");
            System.out.println("2. Write File");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt(); 
            sc.nextLine();
            switch(choice){
                case 1:
                    readFile(fileName);
                    break;
                case 2:
                    writeFile(fileName);
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }while(choice != 3);

    }
    public static void readFile(String fileName){
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

    public static void writeFile(String fileName){
        Scanner sc = new Scanner(System.in);
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(fileName,true));
            String content = sc.nextLine();
            bw.newLine();
            while(!content.equals("quit")){
                System.out.println("Enter content (type 'quit' to exit): ");
                bw.newLine();
                bw.write(content);
                content = sc.nextLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }
}
