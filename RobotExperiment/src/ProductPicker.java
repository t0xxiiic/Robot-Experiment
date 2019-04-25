import java.text.DecimalFormat;
import java.util.ArrayList;

public class ProductPicker {
    public static char[] lastProductPrice;
    public static int productCount;
    public static ArrayList<String> products = new ArrayList<>();
    DecimalFormat df = new DecimalFormat("####0.00");

    public ProductPicker(){
        productCount = 0;
        products.clear();
    }

    public void pickProducts( double amount){
        while(amount != 0.00){
            if(amount <= 5){
                productCount++;
                lastProductPrice = df.format(amount).toCharArray();
                products.add("288");
                amount = 0.00;

            }else if(amount <= 10.00){
                products.add("285");
                products.add("304");
                products.add("39");
                amount-= 5.00;
                productCount+=3;

            }else if(amount <= 20.00){
                products.add("396");
                products.add("251");
                amount-= 9.80;
                productCount+=2;

            }else if(amount <= 30.00){
                products.add("229");
                products.add("1115");
                products.add("228");
                amount-= 15.50;
                productCount+=3;

            }else if(amount <= 40.00){
                products.add("1051");
                products.add("1074");
                products.add("1047");
                amount-= 20.70;
                productCount+=3;

            }else if(amount <= 50.00){
                products.add("1008");
                products.add("210");
                products.add("336");
                amount-= 25.00;
                productCount+=3;

            }else if(amount <= 60.00){
                products.add("1010");
                products.add("366");
                products.add("194");
                products.add("337");
                amount-= 30.00;
                productCount+=4;

            }else if(amount <= 70.00){
                products.add("355");
                products.add("423");
                products.add("86");
                products.add("269");
                amount-= 34.90;
                productCount+=4;

            }else if(amount <= 80.00){
                products.add("423");
                products.add("280");
                products.add("496");
                products.add("355");
                amount-= 40.00;
                productCount+=4;

            }else if(amount <= 90.00){
                products.add("496");
                products.add("1056");
                products.add("71");
                products.add("86");
                products.add("369");
                amount-= 45.00;
                productCount+=5;

            }else if(amount <= 100.00){
                products.add("134");
                amount-= 49.00;
                productCount++;

            }else if(amount <= 200.00){
                products.add("487");
                amount-= 99.00;
                productCount++;

            }else if(amount <= 300.00){
                products.add("449");
                products.add("428");
                amount-= 149.00;
                productCount+=2;

            }else if(amount <= 400.00){
                products.add("186");
                amount-= 199.00;
                productCount++;

            }else if(amount <= 500.00){
                products.add("1083");
                products.add("1071");
                amount-= 250.00;
                productCount+=2;

            }else if(amount <= 1000.00){
                products.add("1040");
                products.add("1025");
                amount-= 500.00;
                productCount+=2;
            }
        }
    }
}