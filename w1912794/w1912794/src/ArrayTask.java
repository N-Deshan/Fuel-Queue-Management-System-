import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArrayTask {

    private static void menu() {
        System.out.println("""
                
                =======Welcome to Fuel Queue Management System=======
                
                100 or VFQ: View all Fuel Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue.
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order.
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining Fuel Stock.
                109 or AFS: Add Fuel Stock.
                999 or EXT: Exit the Program.
                """);
    }

    public static void main(String[] args){

        String[] queue1 = new String[]{"ﻩnull","ﻩnull","ﻩnull","ﻩnull","ﻩnull","ﻩnull"};
        String[] queue2 = new String[]{"ﻩnull","ﻩnull","ﻩnull","ﻩnull","ﻩnull","ﻩnull"};
        String[] queue3 = new String[]{"ﻩnull","ﻩnull","ﻩnull","ﻩnull","ﻩnull","ﻩnull"};
        int fuel = 6600;

        loop:
        while (true)
        {
            menu();
            System.out.println("Input Code number: ");
            Scanner customer = new Scanner(System.in);
            String code = customer.nextLine();
            if (code.equalsIgnoreCase("100") || code.equalsIgnoreCase("VFQ")) {
                ViewAll(queue1,queue2,queue3);
            }
            if (code.equalsIgnoreCase("101") || code.equalsIgnoreCase("VEQ")) {
                ViewAllEmpty(queue1,queue2,queue3);
            }
            if (code.equalsIgnoreCase("102") || code.equalsIgnoreCase("ACQ")) {
                fuel=AddCustomer(queue1,queue2,queue3,fuel);
            }
            if (code.equalsIgnoreCase("103") || code.equalsIgnoreCase("RCQ")) {
                fuel=RemoveCustomer(queue1,queue2,queue3,fuel);
            }
            if (code.equalsIgnoreCase("104") || code.equalsIgnoreCase("PCQ")) {
                RemoveServed(queue1,queue2,queue3);
            }
            if (code.equalsIgnoreCase("105") || code.equalsIgnoreCase("VCS")) {
                ViewAlphabetically(queue1,queue2,queue3);
            }
            if (code.equalsIgnoreCase("106") || code.equalsIgnoreCase("SPD")) {
                StoreData(queue1,queue2,queue3,fuel);
            }
            if (code.equalsIgnoreCase("107") || code.equalsIgnoreCase("LPD")) {
                fuel = LoadData(queue1,queue2,queue3);
            }
            if (code.equalsIgnoreCase("108") || code.equalsIgnoreCase("STK")) {
                ViewRemaining(fuel);
            }
            if (code.equalsIgnoreCase("109") || code.equalsIgnoreCase("AFS")) {
                fuel=AddFuel(fuel);
            }
            if (code.equalsIgnoreCase("999") || code.equalsIgnoreCase("EXT")) {
                System.out.println("Thank you!!!");
                break ;
            }

        }


    }

    public static void ViewAll(String[] queue1, String[] queue2, String[] queue3) {

            //System.out.println("queue 1--> "+(queue1[j])+"\t\t\t\t"+"queue 2--> "+(queue2[j])+"\t\t\t\t"+"queue 3--> "+ (queue3[j])+" ");
            System.out.println("Queue 1 -->"+Arrays.toString(queue1));
            System.out.println("Queue 2 -->"+Arrays.toString(queue2));
            System.out.println("Queue 3 -->"+Arrays.toString(queue3));
        }


    public static void ViewAllEmpty(String[] queue1, String[] queue2, String[] queue3){

        for (int i = 0; i < 6; i++) {
            if (queue1[i].equals("ﻩnull")) {
                System.out.println("Queue 1 is empty");
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (queue2[i].equals("ﻩnull")) {
                System.out.println("Queue 2 is empty");
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (queue3[i].equals("ﻩnull")) {
                System.out.println("Queue 3 is empty");
                break;
            }
        }

    }


    public static int AddCustomer(String[] queue1, String[] queue2, String[] queue3, int fuel) {

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter the Queue number 1/2/3 :");
        int queueNo= customer.nextInt();
        customer.nextLine();
        System.out.println("Enter a position :");
        int queueposition = customer.nextInt();
        customer.nextLine();
        System.out.println("Enter Customer Name :");
        String name= customer.nextLine();
        System.out.println(name+" added to the queue"+queueNo+" successfully");
        fuel -= 10;



        for (int i=0; i<3; i++){

            if (queueNo == 1) {
                queue1[queueposition] = name;

            }
            if (queueNo == 2) {
                queue2[queueposition] = name;

            }
            if (queueNo == 3) {
                queue3[queueposition] = name;

            }
            }
        return fuel;
        }

    public static int RemoveCustomer(String[] queue1, String[] queue2, String[] queue3, int fuel){

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter the Queue number 1/2/3 :");
        int queueNo= customer.nextInt();
        customer.nextLine();
        System.out.println("Enter a position :");
        int queueposition = customer.nextInt();
        customer.nextLine();
        fuel += 10;

        if (queueNo==1){
            queue1[queueposition]="ﻩnull";
        }
        if (queueNo==2){
            queue2[queueposition]="ﻩnull";
        }
        if (queueNo==3){
            queue3[queueposition]="ﻩnull";
        }

        for(int i = 0; i <  5; i++){
            queue1[i] = queue1[i + 1];
        }
        queue1[5] = "ﻩnull";

        for (int i=0; i < 5; i++){
            queue2[i] = queue2[i + 1];
        }
        queue2[5] = "ﻩnull";

        for (int i=0; i < 5; i++){
            queue3[i] = queue3[i + 1];
        }
        queue3[5] = "ﻩnull";
    return fuel;

    }

    public static void RemoveServed(String[] queue1, String[] queue2, String[] queue3){

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter the Queue number 1/2/3 :");
        int queueNo= customer.nextInt();
        customer.nextLine();

        if (queueNo==1){
            queue1[0] = "ﻩnull";
        }
        if (queueNo==2){
            queue2[0] = "ﻩnull";
        }
        if (queueNo==3){
            queue3[0] = "ﻩnull";
        }

        for(int i = 0; i <  5; i++){
            queue1[i] = queue1[i + 1];
        }
        queue1[5] = "ﻩnull";

        for (int i=0; i < 5; i++){
            queue2[i] = queue1[i + 1];
        }
        queue2[5] = "ﻩnull";

        for (int i=0; i < 5; i++){
            queue3[i] = queue3[i + 1];
        }
        queue3[5] = "ﻩnull";

    }

    public static void ViewAlphabetically(String[] queue1, String[] queue2, String[] queue3){
        Scanner customer = new Scanner(System.in);
        System.out.println("Enter the Queue Number to sort: ");
        int queueNo = customer.nextInt();
        customer.nextLine();

        if (queueNo == 1){
            int n = queue1.length;
            String temp;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {

                    // to compare one string with other strings
                    if (queue1[i].compareTo(queue1[j]) > 0) {
                        // swapping
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }
            }

            // print output array
            System.out.println(
                    "The names in alphabetical order are: ");
            for (String s : queue1) {
                System.out.println(s);
            }

        }
        else if (queueNo == 2) {
            int n = queue2.length;
            String temp;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {

                    // to compare one string with other strings
                    if (queue2[i].compareTo(queue2[j]) > 0) {
                        // swapping
                        temp = queue2[i];
                        queue2[i] = queue2[j];
                        queue2[j] = temp;

                    }
                }
            }
            // print output array
            System.out.println(
                    "The names in alphabetical order are: ");
            for (String s : queue2) {
                System.out.println(s);
            }
        }
        else if (queueNo == 3) {
            int n = queue3.length;
            String temp;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {

                    // to compare one string with other strings
                    if (queue3[i].compareTo(queue3[j]) > 0) {
                        // swapping
                        temp = queue3[i];
                        queue3[i] = queue3[j];
                        queue3[j] = temp;

                    }
                }
            }
            // print output array
            System.out.println(
                    "The names in alphabetical order are: ");
            for (String s : queue3) {
                System.out.println(s);
            }
        }
    }

    public static void StoreData(String[] queue1, String[] queue2, String[] queue3, int fuel){

        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt"));
            for (int i = 1; i < queue1.length; i++) {
                writer.write(queue1[i] + "\n");
            }
            for (int i = 1; i < queue2.length; i++) {
                writer.write(queue2[i] + "\n");
            }
            for (int i=1; i< queue3.length; i++){
                writer.write(queue3[i] + "\n");
            }
            writer.write(String.valueOf(fuel));
            writer.close();

        } catch (IOException ex) {
            Logger.getLogger(ArrayTask.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Data Stored complete !!\n\n");

    }

    public static int LoadData(String[] queue1, String[] queue2, String[] queue3){
        int fuel = 0;
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.txt"));
            String line;
            try {
                for (int i = 1; i < 6; i++){
                    line = reader.readLine();
                        queue1[i] = line;
                    }
                for (int i = 1; i < 6; i++){
                    line = reader.readLine();
                        queue2[i] = line;
                }
                for (int i = 1; i < 6; i++){
                    line = reader.readLine();
                        queue3[i] = line;
                }
                line = reader.readLine();
                fuel = Integer.parseInt(line);
                
                reader.close();
            } catch (IOException ex) {
                Logger.getLogger(ArrayTask.class.getName()).log(Level.SEVERE,null, ex);
            }
        } catch (FileNotFoundException ex) {
        }
        System.out.println("Loaded Data successful!!\n\n");

        return fuel;
    }
    public static void ViewRemaining(int fuel){

        System.out.println("\nRemaining amount of fuel is :"+fuel+"\n");
        if (fuel<500){
            System.out.println("Warning Low Fuel Quantity !!!");
        }
    }
    public static int AddFuel(int fuel){

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter value of new stock");
        int addstock = customer.nextInt();
        fuel = fuel+addstock;

        return fuel;
    }
}
