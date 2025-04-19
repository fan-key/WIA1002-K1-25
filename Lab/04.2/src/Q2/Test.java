package Q2;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SLinkedList<String> list = new SLinkedList<>();
        String response = "";

        System.out.println("Enter your student name list. Enter 'n' to end..." );
        do{
            response = sc.nextLine();
            if(!response.equals("n")) list.add(response);
        }while(!response.equals("n"));

        System.out.println("You have entered the following names : ");
        list.printList();

        System.out.println("The number of names entered is : " + list.getSize());
        response = "";

        System.out.println("Are all the names correct? Enter 'r' to rename and 'n' to proceed");
        while(!response.equals("n") && !response.equals("r") ){
            response = sc.nextLine();
        }
        if(response.equals("r")){
            System.out.println("Please enter the name you want to rename:");
            String oldName = sc.nextLine();
            System.out.println("Enter the new name:");
            String newName = sc.nextLine();
            list.replace(oldName, newName);
            System.out.println("The new student list is : ");
            list.printList();
        }
        response = "";

        System.out.println("Do you want to remove any of the student name ?. Enter 'y' for yes and 'n' to proceed ");
        while(!response.equals("n") && !response.equals("y") ){
            response = sc.nextLine();
        }
        if(response.equals("y")){
            System.out.println("Enter the student name you want to remove : ");
            String name = sc.nextLine();
            list.removeElement(name);
            System.out.println("The number of updated students is : " + list.getSize());
            System.out.println("The updated students list is :");
            list.printList();
        }

        System.out.println("All students data captured complete");


    }
}
