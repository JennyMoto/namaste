package gui;

import gui.MainWindow;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 27.01.2018.
 */
public class PaymentWindow extends JFrame implements ActionListener{

    public PaymentWindow(){
        JOptionPane.showMessageDialog(null, "JESZCZE NIE GOTOWE!!!");
        new MainWindow();
    }

    public void actionPerformed(ActionEvent e) {

    }
}
