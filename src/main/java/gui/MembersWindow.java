package gui;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jenny on 27.01.2018.
 */
public class MembersWindow extends JDialog implements ActionListener{

    JButton addMember = new JButton("Add Member");
    JButton remMember = new JButton("Remove Member");
    JButton back = new JButton("Back");
    JTextArea searchMember = new JTextArea("Wpisz imię i nazwisko");


    public MembersWindow() {

        this.setLocationRelativeTo(null);
        this.setModal(true);
        this.setSize(500, 500);
        this.setLayout(new GridLayout(0, 1));

        addMember.addActionListener(this);
        remMember.addActionListener(this);
        back.addActionListener(this);

        addMember.setBackground(Color.lightGray);
        addMember.setFont(new Font("Arial", Font.BOLD, 18));
        addMember.setForeground(Color.darkGray);

        remMember.setBackground(Color.lightGray);
        remMember.setFont(new Font("Arial", Font.BOLD, 18));
        remMember.setForeground(Color.darkGray);

        back.setBackground(Color.lightGray);
        back.setFont(new Font("Arial", Font.BOLD, 18));
        back.setForeground(Color.darkGray);

        searchMember.setFont(new Font("Arial", Font.BOLD, 18));
        searchMember.setForeground(Color.darkGray);

        add(addMember);
        add(remMember);
        add(back);
        add(searchMember);

        this.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if (source == addMember){
            System.out.println("Dodaje członka");
        }
        else if (source == remMember){
            System.out.println("Usuwa członka");
        }
        else if(source == back){
            this.dispose();
        }


    }

}


