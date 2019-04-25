import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    //All variables go here:
    public static String file;
    public static ArrayList<String> time = new ArrayList<>();
    public static ArrayList<String> amount = new ArrayList<>();
    public static String startDate, endDate;
    public static ArrayList<Double> cleanAmounts = new ArrayList<>();
    static double amountEntered = 0.00;
    static String timeEntered;


    public static void main(String[] args)  {

        boolean programWorking = true;
//        String nextBill = "y";
//        ArrayList<String> receiptTime = new ArrayList<>();
//        ArrayList<Double> receiptAmount = new ArrayList<>();
        DecimalFormat df = new DecimalFormat("####0.00");
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter start date: ");
        startDate = scanner.nextLine();
        System.out.println("Please enter end date:");
        endDate = scanner.nextLine();
        scanner.close();

        file = openFile();
        getReceipts(file);

        System.out.println("receipts: " + amount.size() + "\ntime: " + time.size());
        convertStringToDouble(amount);

        /*System.out.println("  Bills For " + startDate + " are: \n" + "````````````````````````");

        for(int i = 0; i < time.size(); i++){
            System.out.println("Amount: " + amount.get(i) + " @ " + time.get(i));
        }*/

        System.out.println("Clean amounts are: ");
        for(double i : cleanAmounts){
            System.out.print(i + ", ");
        }
        System.out.println();

        System.out.println("  Bills For " + startDate + " are: \n" + "````````````````````````");
        for(int i = 0; i < time.size(); i++){
            System.out.println("Amount("+ (i+1) + "): " + cleanAmounts.get(i) + "лв. " + "@ " + time.get(i) + "ч.");
        }

        writeReceiptsToFile();

        System.out.print("If you are sure enter 'y': ");
        if(scanner.nextLine().equals("y")){
            for(int i = 0; i < cleanAmounts.size(); i++){
                amountEntered = cleanAmounts.get(i);
                timeEntered = time.get(i);
                df.format(amountEntered);
                System.out.println(amountEntered);
                testProductPicker();
                Program prog = new Program();
                prog.open();
//                amountEntered = 0.00;
            }
        }


        /*while(programWorking) {
            DecimalFormat df = new DecimalFormat("####0.00");
            Scanner scanner = new Scanner(System.in);

            while(nextBill.equals("y")){
                System.out.println("Please enter amount: ");
                receiptAmount.add(Double.parseDouble(scanner.nextLine()));
                System.out.println("Please enter time: ");
                receiptTime.add(scanner.nextLine());
                System.out.print("Next bill? (y/n): ");
                nextBill = scanner.nextLine();
                System.out.println();
            }
            for(int i = 0; i < receiptAmount.size(); i++){
                amountEntered = receiptAmount.get(i);
                timeEntered = receiptTime.get(i);
                df.format(amountEntered);
                System.out.println(amountEntered);
                testProductPicker();
                Program prog = new Program();
                prog.open();
                amountEntered = 0.00;
            }
            programWorking = false;
        }*/
    }

    public static void testProductPicker(){
        ProductPicker pp = new ProductPicker();
        pp.pickProducts(amountEntered);
        for(String i : pp.products){
            System.out.println("Product Entered: " + i);
        }
        System.out.println("Products count: " + pp.productCount);
        System.out.print("Last product price: ");
        for(char i : pp.lastProductPrice){
            System.out.print(i);
        }
        System.out.println();
    }

    //All methods are located under here:
    public static String openFile() {
        FileDialog dialog = new FileDialog((Frame) null, "Select File to Open");

        dialog.setMode(FileDialog.LOAD);
        dialog.setVisible(true);

        String file = dialog.getFile();
        String directory = dialog.getDirectory();

        System.out.println(directory + file + " chosen.");

        return directory + file;
    } //Opens a File Dialog to choose a file and then returns its path.

    public static void getReceipts(String file) {

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            String bufferedReaderString, container;

            while ((bufferedReaderString = bufferedReader.readLine()) != null) {
                if(bufferedReaderString.contains(endDate)){
                    break;
                }
                if (bufferedReaderString.contains("Обща сума")) {
                    container = bufferedReaderString.substring(25);
                    //System.out.println(container);
                    amount.add(container);
                } else if (bufferedReaderString.contains(startDate)) {
                    container = bufferedReaderString.substring(27);
                    //System.out.println(container);
                    time.add(container);
                }
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeReceiptsToFile(){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("Receipts.txt", true));
            bufferedWriter.newLine();
            bufferedWriter.write("Receipts for " + startDate + " are: ");
            bufferedWriter.newLine();
            bufferedWriter.write("````````````````````````");
            bufferedWriter.newLine();
            for(int i = 0; i < time.size(); i++){
                bufferedWriter.write("Amount("+ (i+1) + "): " + cleanAmounts.get(i) + "лв. " + "@ " + time.get(i) + "ч.");
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void convertStringToDouble(ArrayList<String> amount){
        char[] container;
        int counter = 0;

        for(int i = 0; i < amount.size(); i++){
            container = amount.get(i).toCharArray();
            for(int j = 0; j < 4; j++){
                if(container[j] == '.'){
                    counter++;
                }
            }
            cleanAmounts.add(Double.parseDouble(amount.get(i).substring(counter)));
            counter = 0;
        }
    }
}

