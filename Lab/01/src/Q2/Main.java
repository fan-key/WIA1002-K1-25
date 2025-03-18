package Q2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        String file1 = "src\\Q2\\text1.txt";
        String file2 = "src\\Q2\\text2.txt";
        String file3 = "src\\Q2\\text3.txt";
        String file4 = "src\\Q2\\text4.txt";

        readFile(file1, ",");
        readFile(file2, "[ ,]");
        readFile(file3, "[ ;]");
        readFile(file4, "[0-9]");
    }
    public static void readFile(String fileName, String regex){
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            while((line = br.readLine()) != null){
                line = line.replaceAll(regex, "");
                System.out.println("Number of characters : " + line.length());
                System.out.println("Words : " + line);
            }
            System.out.println();
            br.close();
        }
        catch(IOException e){
            System.out.println("An error occurred.");
        }
    }
}
