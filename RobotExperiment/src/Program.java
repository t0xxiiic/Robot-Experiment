import java.awt.*;

public class Program {
    private Robot robot;
    private Clicker click;

    public void open(){
        try {
            robot = new Robot();
        }catch (Exception e){
            e.printStackTrace();
        }
        //click.changeDate(robot);
        click.systemDate(MainClass.timeEntered);
        click.openProgram(robot);
                //click.productButtons(robot);
        click.enterProduct(robot);
        click.correctLastProduct(robot);
        click.finishOrder(robot);
    }
}
