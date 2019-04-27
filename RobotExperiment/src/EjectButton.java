import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EjectButton extends JFrame implements ActionListener {

    private JButton ejectButton;

    public EjectButton(){
        setLayout(new FlowLayout());
        ejectButton = new JButton("#Abort!");
        ejectButton.setSize(210,90);
        ejectButton.setPreferredSize(new Dimension(210,90));
        ejectButton.setFont(new Font("Impact", Font.BOLD, 48));
        ejectButton.addActionListener(this);
        ejectButton.setActionCommand("Eject");
        add(ejectButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Eject")){
            System.exit(0);
        }
    }
}
