package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 27.01.2018.
 */
public class ClassesWindow extends JFrame implements ActionListener {

    JButton addClasses = new JButton("Add Classes");
    JButton remClasses = new JButton("Remove Classes");
    JButton back = new JButton("Back");



    public ClassesWindow() {

        this.setSize(500, 500);
        this.setLayout(new GridLayout(0, 1));

        addClasses.addActionListener(this);
        remClasses.addActionListener(this);
        back.addActionListener(this);

        addClasses.setBackground(Color.lightGray);
        addClasses.setFont(new Font("Arial", Font.BOLD, 18));
        addClasses.setForeground(Color.darkGray);

        remClasses.setBackground(Color.lightGray);
        remClasses.setFont(new Font("Arial", Font.BOLD, 18));
        remClasses.setForeground(Color.darkGray);

        back.setBackground(Color.lightGray);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setForeground(Color.darkGray);

        add(addClasses);
        add(remClasses);
        add(back);

        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addClasses){
            System.out.println("Dodaje zajecia");
        }
        else if (source == remClasses){
            System.out.println("Usuwa zajecia");
        }
        else if(source == back){
            new MainWindow();
        }

        this.setVisible(false);
    }
}
