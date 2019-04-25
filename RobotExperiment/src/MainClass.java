import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

public class MainClass {

    static double amountEntered = 0.00;
    static String timeEntered;


    public static void main(String[] args)  {

        boolean programWorking = true;
        String nextBill = "y";
        ArrayList<String> receiptTime = new ArrayList<>();
        ArrayList<Double> receiptAmount = new ArrayList<>();

        while(programWorking) {
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
        }
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
}
