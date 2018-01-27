import javax.swing.*;
import java.awt.*;

/**
 * Created by Jenny on 27.01.2018.
 */
public class Main {
    public static void main (String args[]){

        JFrame startWindow = new JFrame("Namaste");
        startWindow.setSize(500,500);
        startWindow.setBackground(Color.white);
        startWindow.setLayout(new GridLayout(2,2));

        String []names = {"Schedule", "Members", "Classes", "Payment"};
        JButton []buttons = new JButton[4];

        for (int i =0; i<names.length; i++) {
            JButton b = new JButton(names[i]);
            b.setBackground(Color.lightGray);
            b.setFont(new Font("Arial",Font.BOLD,18));
            b.setForeground(Color.darkGray);
            startWindow.add(b);
            buttons[i] =b;
        }


        startWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        startWindow.setLocationRelativeTo(null);
        startWindow.setVisible(true);

    }
}
