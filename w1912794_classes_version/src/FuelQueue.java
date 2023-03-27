import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FuelQueue {
    public static int q1liters = 0;
    public static int q2liters = 0;
    public static int q3liters = 0;
    public static int q4liters = 0;
    public static int q5liters = 0;

    private static void menu() {
        System.out.println("""
                
                =======Welcome to Fuel Queue Management System=======
                
                100 or VFQ: View all Fuel Queues.
                101 or VEQ: View all Empty Queues.
                102 or ACQ: Add customer to a Queue.
                103 or RCQ: Remove a customer from a Queue. (From a specific location)
                104 or PCQ: Remove a served customer.
                105 or VCS: View Customers Sorted in alphabetical order.
                106 or SPD: Store Program Data into file.
                107 or LPD: Load Program Data from file.
                108 or STK: View Remaining Fuel Stock.
                109 or AFS: Add Fuel Stock.
                110 or ACQ: Income of Fuel
                999 or EXT: Exit the Program.
                """);
    }


    public static void main(String[] args){

        String[][] queue1 = new String[7][4];
        String[][] queue2 = new String[7][4];
        String[][] queue3 = new String[7][4];
        String[][] queue4 = new String[7][4];
        String[][] queue5 = new String[7][4];
        int queue =6;
        passenger obj1 = new passenger();
        int[] price = new int[5];


        int fuel = 6600;

        loop:
        while (true)
        {
            menu();
            System.out.println("Input Code number: ");
            Scanner customer = new Scanner(System.in);
            String code = customer.nextLine();
            if (code.equalsIgnoreCase("100") || code.equalsIgnoreCase("VFQ")) {
                ViewAll(queue1,queue2,queue3,queue4,queue5);
            }
            if (code.equalsIgnoreCase("101") || code.equalsIgnoreCase("VEQ")) {
                ViewAllEmpty(queue1,queue2,queue3,queue4,queue5);
            }
            if (code.equalsIgnoreCase("102") || code.equalsIgnoreCase("ACQ")) {
                fuel = AddCustomer(queue1,queue2,queue3,queue4,queue5,fuel,obj1);
            }
            if (code.equalsIgnoreCase("103") || code.equalsIgnoreCase("RCQ")) {
                fuel = RemoveCustomer(queue1,queue2,queue3,queue4,queue5,fuel,obj1);
            }
            if (code.equalsIgnoreCase("104") || code.equalsIgnoreCase("PCQ")) {
                RemoveServed(queue1,queue2,queue3,queue4,queue5);
            }
            if (code.equalsIgnoreCase("105") || code.equalsIgnoreCase("VCS")) {
                ViewAlphabetically(queue1,queue2,queue3,queue4,queue5,obj1, queue);
            }
            if (code.equalsIgnoreCase("106") || code.equalsIgnoreCase("SPD")) {
                StoreData(queue1,queue2,queue3,queue4,queue5,fuel);
            }
            if (code.equalsIgnoreCase("107") || code.equalsIgnoreCase("LPD")) {
                fuel = LoadData(queue1,queue2,queue3,queue4,queue5);
            }
            if (code.equalsIgnoreCase("108") || code.equalsIgnoreCase("STK")) {
                ViewRemaining(fuel);
            }
            if (code.equalsIgnoreCase("109") || code.equalsIgnoreCase("AFS")) {
                fuel=AddFuel(fuel);
            }
            if (code.equalsIgnoreCase("110") || code.equalsIgnoreCase("IFQ")) {
                FuelInc();
            }
            if (code.equalsIgnoreCase("999") || code.equalsIgnoreCase("EXT")) {
                System.out.println("Thank you!!!");
                break;


            }
        }
    }

    public static void ViewAll(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5) {

        System.out.println("-----------------------------------------------"+"\n"+"Queue 1"+"\n");
        for (int j = 1; j < 7; j++) {
            System.out.println("Passenger "+j+"--> "+Arrays.toString(queue1[j]));
        }
        System.out.println("-----------------------------------------------"+"\n"+"Queue 2"+"\n");
        for (int j = 1; j < 7; j++) {
            System.out.println("Passenger "+j+"--> "+Arrays.toString(queue2[j]));
        }
        System.out.println("-----------------------------------------------"+"\n"+"Queue 3"+"\n");
        for (int j = 1; j < 7; j++) {
            System.out.println("Passenger "+j+"--> "+Arrays.toString(queue3[j]));
        }
        System.out.println("-----------------------------------------------"+"\n"+"Queue 4"+"\n");
        for (int j = 1; j < 7; j++) {
            System.out.println("Passenger "+j+"--> "+Arrays.toString(queue4[j]));
        }
        System.out.println("-----------------------------------------------"+"\n"+"Queue 5"+"\n");
        for (int j = 1; j < 7; j++) {
            System.out.println("Passenger "+j+"--> "+Arrays.toString(queue5[j]));
        }


    }

    public static void ViewAllEmpty(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5){

        for (int i = 0; i < 6; i++) {
            if (queue1[i][0] == null) {
                System.out.println("Queue 1 is empty");
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (queue2[i][0] == null) {
                System.out.println("Queue 2 is empty");
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (queue3[i][0] == null) {
                System.out.println("Queue 3 is empty");
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (queue4[i][0] == null) {
                System.out.println("Queue 4 is empty");
                break;
            }
        }
        for (int i = 0; i < 6; i++) {
            if (queue5[i][0] == null) {
                System.out.println("Queue 5 is empty");
                break;
            }
        }
    }


    public static int AddCustomer(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5, int fuel,passenger obj1) {

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter First Name: ");
        obj1.setFirst_name(customer.nextLine());
        System.out.println("Enter Sur Name: ");
        obj1.setSur_name(customer.nextLine());
        System.out.println("Enter Vehicle number: ");
        obj1.setVehicle_no(customer.nextLine());
        System.out.println("Enter litres requires: ");
        obj1.setLitres_require(customer.nextLine());
        System.out.println(obj1.getFirst_name() + " added to the queue");
        String[] info = {obj1.getFirst_name(), obj1.sur_name, obj1.vehicle_no, obj1.litres_require};
        String[][] queue = new String[6][4];
        int[] loop = new int[5];
        int count = 0;
        fuel -= Integer.parseInt(obj1.litres_require);


        for (int i = 0; i < 6; i++) {
            if (queue1[i][0] == (null)) {
                count++;
            }
        }
        loop[0] = count;

        count = 0;
        for (int i = 0; i < 6; i++) {
            if (queue2[i][0] == (null)) {
                count++;
            }
        }
        loop[1] = count;

        count = 0;
        for (int i = 0; i < 6; i++) {
            if (queue3[i][0] == (null)) {
                count++;
            }
        }
        loop[2] = count;

        count = 0;
        for (int i = 0; i < 6; i++) {
            if (queue4[i][0] == (null)) {
                count++;
            }
        }
        loop[3] = count;

        count = 0;
        for (int i = 0; i < 6; i++) {
            if (queue5[i][0] == (null)) {
                count++;
            }
        }
        loop[4] = count;

        int max = 0;
        for (int i = 1; i < loop.length; i++) {
            if (loop[i] > loop[max]) max = i;
        }
        if (max == 0) {
            queue = queue1;
        } else if (max == 1) {
            queue = queue2;
        } else if (max == 2) {
            queue = queue3;
        } else if (max == 3) {
            queue = queue4;
        } else {
            queue = queue5;
        }

        for (int i = 1; i < 7; i++) {
            if (queue[i][0] == null) {
                queue[i] = info;
                break;
            }
        }
        return fuel;
    }

    public static int RemoveCustomer(String[][] queue1, String[][] queue2, String[][] queue3, String[][] queue4, String[][] queue5, int fuel,passenger obj1){

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter the Queue number 1/2/3/4/5 :");
        int queueNo= customer.nextInt();
        customer.nextLine();
        System.out.println("Enter a position :");
        int queueposition = customer.nextInt();
        customer.nextLine();
        fuel += Integer.parseInt(obj1.litres_require);


        if (queueNo==1){
            queue1[queueposition] = new String[]{null, null, null, null};
            for(int i = 0; i <  6; i++){
                try {
                    if ((queue1[i+2][0] == null)) {
                        queue1[i] = queue1[i + 1];
                    }
                    else if (queue1[i+1][0]== null) {
                        continue;
                    }
                    else {
                        queue1[i] = queue1[i + 1];
                    }
                }catch (Exception e){
                    queue1[i] = queue1[i + 1];
                }
            }
            queue1[5] =new String[]{null, null, null, null} ;
        }
        if (queueNo==2){
            queue2[queueposition] = new String[]{null, null, null, null};
            for(int i = 0; i <  6; i++){
                try {
                    if ((queue2[i+2][0] == null)) {
                        queue2[i] = queue2[i + 1];
                    }
                    else if (queue2[i+1][0]== null) {
                        continue;
                    }
                    else {
                        queue2[i] = queue2[i + 1];
                    }
                }catch (Exception e){
                    queue2[i] = queue2[i + 1];
                }
            }
            queue2[5] =new String[]{null, null, null, null} ;
        }
        if (queueNo==3){
            queue3[queueposition] = new String[]{null, null, null, null};
            for(int i = 0; i <  6; i++){
                try {
                    if ((queue3[i+2][0] == null)) {
                        queue3[i] = queue3[i + 1];
                    }
                    else if (queue3[i+1][0]== null) {
                        continue;
                    }
                    else {
                        queue3[i] = queue3[i + 1];
                    }
                }catch (Exception e){
                    queue3[i] = queue3[i + 1];
                }
            }
            queue3[5] =new String[]{null, null, null, null} ;
        }
        if (queueNo==4){
            queue1[queueposition] = new String[]{null, null, null, null};
            for(int i = 0; i <  6; i++){
                try {
                    if ((queue4[i+2][0] == null)) {
                        queue4[i] = queue4[i + 1];
                    }
                    else if (queue4[i+1][0]== null) {
                        continue;
                    }
                    else {
                        queue4[i] = queue4[i + 1];
                    }
                }catch (Exception e){
                    queue4[i] = queue4[i + 1];
                }
            }
            queue4[5] =new String[]{null, null, null, null} ;
        }
        if (queueNo==5){
            queue1[queueposition] = new String[]{null, null, null, null};
            for(int i = 0; i <  6; i++){
                try {
                    if ((queue5[i+2][0] == null)) {
                        queue5[i] = queue5[i + 1];
                    }
                    else if (queue5[i+1][0]== null) {
                        continue;
                    }
                    else {
                        queue5[i] = queue5[i + 1];
                    }
                }catch (Exception e){
                    queue5[i] = queue5[i + 1];
                }
            }
            queue5[5] =new String[]{null, null, null, null} ;
        }
        return fuel;

    }

    public static void RemoveServed(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5) {

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter the Queue number 1/2/3/4/5 :");
        int queueNo = customer.nextInt();
        customer.nextLine();


        if (queueNo == 1) {
            q1liters = q1liters+Integer.parseInt(queue1[1][3]);
            for (int i = 0; i < 6; i++) {
                try {
                    if ((queue1[i + 2][0] == null)) {
                        queue1[i] = queue1[i + 1];
                    } else if (queue1[i + 1][0] == null) {
                        continue;
                    } else {
                        queue1[i] = queue1[i + 1];
                    }
                } catch (Exception e) {
                    queue1[i] = queue1[i + 1];
                }
            }
            queue1[5] = new String[]{null, null, null, null};
        }
        if (queueNo == 2) {
            q2liters = q2liters+Integer.parseInt(queue2[1][3]);
            for (int i = 0; i < 6; i++) {
                try {
                    if ((queue2[i + 2][0] == null)) {
                        queue2[i] = queue2[i + 1];
                    } else if (queue2[i + 1][0] == null) {
                        continue;
                    } else {
                        queue2[i] = queue2[i + 1];
                    }
                } catch (Exception e) {
                    queue2[i] = queue2[i + 1];
                }
            }
            queue2[5] = new String[]{null, null, null, null};
        }
        if (queueNo == 3) {
            q3liters = q3liters+Integer.parseInt(queue3[1][3]);
            for (int i = 0; i < 6; i++) {
                try {
                    if ((queue3[i + 2][0] == null)) {
                        queue3[i] = queue3[i + 1];
                    } else if (queue3[i + 1][0] == null) {
                        continue;
                    } else {
                        queue3[i] = queue3[i + 1];
                    }
                } catch (Exception e) {
                    queue3[i] = queue3[i + 1];
                }
            }
            queue3[5] = new String[]{null, null, null, null};
        }
        if (queueNo == 4) {
            q4liters = q4liters+Integer.parseInt(queue4[1][3]);
            for (int i = 0; i < 6; i++) {
                try {
                    if ((queue4[i + 2][0] == null)) {
                        queue4[i] = queue4[i + 1];
                    } else if (queue4[i + 1][0] == null) {
                        continue;
                    } else {
                        queue4[i] = queue4[i + 1];
                    }
                } catch (Exception e) {
                    queue4[i] = queue4[i + 1];
                }
            }
            queue4[5] = new String[]{null, null, null, null};
        }
        if (queueNo == 5) {
            q5liters = q5liters+Integer.parseInt(queue5[1][3]);
            for (int i = 0; i < 6; i++) {
                try {
                    if ((queue5[i + 2][0] == null)) {
                        queue5[i] = queue5[i + 1];
                    } else if (queue5[i + 1][0] == null) {
                        continue;
                    } else {
                        queue5[i] = queue5[i + 1];
                    }
                } catch (Exception e) {
                    queue5[i] = queue5[i + 1];
                }
            }
            queue5[5] = new String[]{null, null, null, null};


        }

    }

    public static void ViewAlphabetically(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5,passenger obj1,int queue) {
        Scanner customer = new Scanner(System.in);
        System.out.println("Enter Queue number");
        int queueNo = customer.nextInt();
        if (queueNo == 1) {
            String[] temp;
            for (int i = 0; i < queue; i++) {
                for (int j = i + 1; j < queue; j++) {
                    if (Arrays.toString(queue1[i]).compareTo(Arrays.toString(queue1[j])) > 0){
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }

            }
            System.out.println("After sorted: ");
            for (int i=0; i<queue; i++){
                System.out.println(Arrays.toString(queue1[i]));
            }
        }
        if (queueNo == 2) {
            String[] temp;
            for (int i = 0; i < queue; i++) {
                for (int j = i + 1; j < queue; j++) {
                    if (Arrays.toString(queue1[i]).compareTo(Arrays.toString(queue1[j])) > 0){
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }

            }
            System.out.println("After sorted: ");
            for (int i=0; i<queue; i++){
                System.out.println(Arrays.toString(queue1[i]));
            }
        }
        if (queueNo == 3) {
            String[] temp;
            for (int i = 0; i < queue; i++) {
                for (int j = i + 1; j < queue; j++) {
                    if (Arrays.toString(queue1[i]).compareTo(Arrays.toString(queue1[j])) > 0){
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }

            }
            System.out.println("After sorted: ");
            for (int i=0; i<queue; i++){
                System.out.println(Arrays.toString(queue1[i]));
            }
        }
        if (queueNo == 4) {
            String[] temp;
            for (int i = 0; i < queue; i++) {
                for (int j = i + 1; j < queue; j++) {
                    if (Arrays.toString(queue1[i]).compareTo(Arrays.toString(queue1[j])) > 0){
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }

            }
            System.out.println("After sorted: ");
            for (int i=0; i<queue; i++){
                System.out.println(Arrays.toString(queue1[i]));
            }
        }
        if (queueNo == 5) {
            String[] temp;
            for (int i = 0; i < queue; i++) {
                for (int j = i + 1; j < queue; j++) {
                    if (Arrays.toString(queue1[i]).compareTo(Arrays.toString(queue1[j])) > 0){
                        temp = queue1[i];
                        queue1[i] = queue1[j];
                        queue1[j] = temp;
                    }
                }

            }
            System.out.println("After sorted: ");
            for (int i=0; i<queue; i++){
                System.out.println(Arrays.toString(queue1[i]));
            }
        }

    }
    public static void StoreData(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5, int fuel){
        try {
            FileWriter myWriter = new FileWriter("Data.txt");
            for(int i=0;i<6;i++){
                for(int j=0; j<4;j++){
                    myWriter.write(queue1[i][j]+"\n");
                    myWriter.write(q1liters*430);
                }
                for(int j=0; j<4;j++) {
                    myWriter.write(queue2[i][j] + "\n");
                    myWriter.write(q2liters*430);
                }
                for(int j=0; j<4;j++) {
                    myWriter.write(queue3[i][j] + "\n");
                    myWriter.write(q3liters*430);
                }
                for(int j=0; j<4;j++) {
                    myWriter.write(queue4[i][j] + "\n");
                    myWriter.write(q4liters*430);
                }
                for(int j=0; j<4;j++) {
                    myWriter.write(queue5[i][j] + "\n");
                    myWriter.write(q5liters*430);
                }
            }
            myWriter.close();
            System.out.println("Successfully stored.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static int LoadData(String[][] queue1, String[][] queue2, String[][] queue3,String[][] queue4,String[][] queue5) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("Data.txt"));
            String line = null;
            try {
                for (int i=0; i<19; i++){
                    for (int j=0; j<6; j++){
                        while ((line = reader.readLine()) != null) {
                            System.out.println(line);
                            if (i<6){
                                queue1[i][j] = line;
                            } else if (i<12) {
                                queue2[i][j] = line;
                            } else if (i<18) {
                                queue3[i][j] = line;
                            } else if (i<24) {
                                queue4[i][j] = line;
                            } else if (1<30) {
                                queue5[i][j] = line;
                            }
                        }
                    }
                }

                reader.close();
            } catch (IOException ex) {
                System.out.println("An error occurred.");
                ex.printStackTrace();
            }
        } catch (FileNotFoundException ex) {
            System.out.println("file not found.");

        }
        System.out.println("Loaded Data successful!!\n\n");

        return 0;
    }


    public static int ViewRemaining(int fuel){

        System.out.println("\nRemaining amount of fuel is :"+fuel+"\n");
        if (fuel<500){
            System.out.println("Warning Low Fuel Quantity !!!");
        }
        return fuel;
    }

    public static int AddFuel(int fuel){

        Scanner customer = new Scanner(System.in);
        System.out.println("Enter value of new stock");
        int addstock = customer.nextInt();
        fuel = fuel+addstock;
        return fuel;
    }

    public  static int FuelInc(){
        System.out.println("Income of First  queue --> " + q1liters*430 );
        System.out.println("Income of Second queue --> " + q2liters*430);
        System.out.println("Income of Third  queue --> " + q3liters*430);
        System.out.println("Income of Fourth queue --> " + q4liters*430);
        System.out.println("Income of Fifth  queue --> " + q5liters*430);
        return 0;
    }

}