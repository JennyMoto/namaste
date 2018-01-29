package gui;

import jdk.nashorn.internal.scripts.JD;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 27.01.2018.
 */
public class MainWindow extends JFrame implements ActionListener {
    JButton[] buttons = new JButton[4];

    public MainWindow() {

        this.setTitle("Namaste");
        this.setSize(500, 500);
        this.setBackground(Color.white);
        this.setLayout(new GridLayout(2, 2));

        String[] names = {"Schedule", "Members", "Classes", "Payment"};


        for (int i = 0; i < names.length; i++) {
            JButton b = new JButton(names[i]);
            b.setBackground(Color.lightGray);
            b.setFont(new Font("Arial", Font.BOLD, 18));
            b.setForeground(Color.darkGray);
            this.add(b);
            b.addActionListener(this);
            buttons[i] = b;
        }


        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == buttons[0]) {
            openDialog(new ScheduleWindow());
        } else if (source == buttons[1]) {
            openDialog(new MembersWindow());
        } else if (source == buttons[2]) {
            openDialog(new ClassesWindow());
        } else {
            new PaymentWindow();
        }


    }

    private void openDialog(JPanel panel) {
        JDialog dialog = new JDialog();
        dialog.setSize(500, 500);
        dialog.setVisible(true);
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        dialog.setContentPane(panel);
    }

}
