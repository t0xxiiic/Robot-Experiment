import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class TestLogic {

    public static void main(String[] args) throws IOException {
        double amountPaid = 864.13;
        String strTime = "13:13";
        ArrayList<String>times = new ArrayList<>();
        times.add("13:30");
        times.add("12:22");
        times.add("17:44");
        times.add("22:02");

        int productCount = 0;
        DecimalFormat df = new DecimalFormat("####0.00");
        char[] numbers;

        while (amountPaid != 0.00) {
            if(amountPaid <= 5.00){
                productCount++;
                System.out.println("remainder is: " + df.format(amountPaid));
                System.out.println("product in cart: " + productCount);
                numbers = df.format(amountPaid).toCharArray();
                amountPaid = 0.00;
                System.out.print("Robot must enter: ");
                for(int i = 0; i < numbers.length; i++){
                    System.out.print(numbers[i]);
                }
                System.out.println();
            }else if(amountPaid <=10.00){
                amountPaid-=5.00;
                productCount++;
                System.out.println("+5");
            }else if(amountPaid <= 20.00){
                amountPaid-=10.00;
                productCount++;
                System.out.println("+10");

            }else if(amountPaid <= 30.00){
                amountPaid-=15.00;
                productCount++;
                System.out.println("+15");

            }else if(amountPaid <= 40.00){
                amountPaid-=20.00;
                productCount++;
                System.out.println("+20");

            }else if(amountPaid <= 50.00){
                amountPaid-=25.00;
                productCount++;
                System.out.println("+25");

            }else if(amountPaid <= 60.00){
                amountPaid-=30.00;
                productCount++;
                System.out.println("+30");

            }else if(amountPaid <= 70.00){
                amountPaid-=35.00;
                productCount++;
                System.out.println("+35");

            }else if(amountPaid <= 80.00){
                amountPaid-=40.00;
                productCount++;
                System.out.println("+40");

            }else if(amountPaid <= 90.00){
                amountPaid-=45.00;
                productCount++;
                System.out.println("+45");
            }else if(amountPaid <= 100.00){
                amountPaid-=50.00;
                productCount++;
                System.out.println("+50");
            }else if(amountPaid <= 200.00){
                amountPaid-=100.00;
                productCount++;
                System.out.println("+100");
            }else if(amountPaid <= 500.00){
                amountPaid-=250.00;
                productCount++;
                System.out.println("+250");
            }else if(amountPaid <= 1000.00){
                amountPaid-=500.00;
                productCount++;
                System.out.println("+500");
            }

        }

        for(int i = 0; i < times.size(); i++){
            try{
                Thread.sleep(2000);
                Runtime.getRuntime().exec("cmd /C time " + times.get(i)); // dd-MM-yy
                System.out.println("Time has changed to: " + times.get(i));
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }

}
