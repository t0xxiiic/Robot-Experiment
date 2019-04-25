import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.security.Key;

public class Clicker {
    public static int delay = 200;
   private static int productButtonX = 1640,productButtonY = 220;

    public static void openProgram(Robot robot){
        try{
            Thread.sleep(delay);
            robot.mouseMove(122,1059);
            Thread.sleep(delay);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void productButtons(Robot robot){
        try{
            Thread.sleep(2000);

           for(int i = 0; i < 32; i++){
               robot.mouseMove(productButtonX,productButtonY);
               Thread.sleep(500);
               productButtonY+= 50;
               if(i == 15){
                   productButtonX += 100;
                   productButtonY = 220;
               }
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void enterProduct(Robot robot){
        try{
            int y = 220;
            Thread.sleep(delay);
            robot.mouseMove(840,y);
            leftClick();
            Thread.sleep(delay);
            robot.mouseMove(685,781);
            leftClick();
            //Thread.sleep(delay);
            //System.out.println("Right before the for loop");
            for(int i = 0; i < ProductPicker.products.size(); i++){
                leftClick();
                //System.out.println("for loop for product: " + i);
                char[] productID;
                productID = ProductPicker.products.get(i).toCharArray();
                for(int j = 0; j < productID.length; j++){
                    //System.out.println("For loop for charToKeyPress");
                    charToKeyPress(productID[j]);
                }
                Thread.sleep(delay);
                robot.keyPress(KeyEvent.VK_ENTER);
                Thread.sleep(delay);
                robot.keyPress(KeyEvent.VK_TAB);
                Thread.sleep(delay);
                robot.keyPress(KeyEvent.VK_TAB);
                Thread.sleep(delay);
                robot.keyPress(KeyEvent.VK_TAB);
                Thread.sleep(delay);
                robot.mouseMove(840,y+=25);
                Thread.sleep(delay);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void correctLastProduct(Robot robot){
        int x = 1300, y = 195;
        try {
            if(ProductPicker.productCount > 0){
                for (int i = 0; i < ProductPicker.productCount; i++) {
                    y += 25;
                }
            }
            Thread.sleep(delay);
            robot.mouseMove(x, y);
            Thread.sleep(delay);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(delay);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            Thread.sleep(delay);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            for(int i = 0; i < ProductPicker.lastProductPrice.length; i++){
                charToKeyPress(ProductPicker.lastProductPrice[i]);
            }
            robot.keyPress(KeyEvent.VK_ENTER);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void changeDate(Robot robot){
        try{
            /*char[] hours = MainClass.timeEntered.substring(0,1).toCharArray(),
                    minutes = MainClass.timeEntered.substring(2).toCharArray();*/
            Thread.sleep(delay);
            robot.keyPress(KeyEvent.VK_WINDOWS);
            robot.keyRelease(KeyEvent.VK_WINDOWS);
            Thread.sleep(delay);
            robot.mouseMove(170,1055); // Move to second icon on status bar
            leftClick();
            Thread.sleep(delay);
            robot.mouseMove(1500,710); // Move to "Change" Button in the date & time settings
            leftClick();
            /*Thread.sleep(delay);
            robot.mouseMove(1250, 730); // Move to the hours
            leftClick();

            for(int i = 0; i < hours.length; i++){  // Enter hours
                charToKeyPress(hours[i]);
            }
            Thread.sleep(delay);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.mouseMove(1350, 730); // Move to the minutes
            leftClick();

            for(int i = 0; i < minutes.length; i++){   // Enter minutes
                charToKeyPress(minutes[i]);
            }
            Thread.sleep(delay);
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.mouseMove(1690, 810); // Move to the "Change" button
            leftClick(); */


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void systemDate(String date){
        try{
            Runtime.getRuntime().exec("cmd /C time " + date); // dd-MM-yy
            System.out.println("Time has changed to: " + date);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void finishOrder(Robot robot){
        try{
            robot.mouseMove(35,55);
            leftClick();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void charToKeyPress(char ch) {
        try {
            Robot robot = new Robot();
            switch (ch) {
                case '0':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_0);
                    //System.out.println("Entered 0");
                    break;
                case '1':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_1);
                    //System.out.println("Entered 1");
                    break;
                case '2':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_2);
                    //System.out.println("Entered 2");
                    break;
                case '3':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_3);
                    //System.out.println("Entered 3");
                    break;
                case '4':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_4);
                    //System.out.println("Entered 4");
                    break;
                case '5':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_5);
                    //System.out.println("Entered 5");
                    break;
                case '6':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_6);
                    //System.out.println("Entered 6");
                    break;
                case '7':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_7);
                    //System.out.println("Entered 7");
                    break;
                case '8':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_8);
                    //System.out.println("Entered 8");
                    break;
                case '9':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_9);
                    //System.out.println("Entered 9");
                    break;
                case '.':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_STOP);
                    //System.out.println("Entered .");
                    break;
                case ',':
                    Thread.sleep(delay);
                    robot.keyPress(KeyEvent.VK_COMMA);
                    //System.out.println("Entered ,");
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void leftClick(){
        try{
            Robot robot = new Robot();
            Thread.sleep(delay);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

        }catch (Exception e){
            e.printStackTrace();
        }
    }

}